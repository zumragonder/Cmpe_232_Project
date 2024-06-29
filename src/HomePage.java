import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.List;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

public class HomePage extends JFrame implements ActionListener {
    private JButton profileButton;
    private JPanel categoriesPanel;
    private static final Color ORANGE = new Color(255, 130, 60);
    private static final Color WHITE = new Color(255, 255, 255);
    private static final Font BOLD_ARIAL_32 = new Font("Arial", Font.BOLD, 32);
    private static final Font BOLD_ARIAL_24 = new Font("Arial", Font.BOLD, 24);
    private static final Font BOLD_ARIAL_18 = new Font("Arial", Font.BOLD, 18);
    private static final Font BOLD_ARIAL_16 = new Font("Arial", Font.BOLD, 16);

    public HomePage() {
        configureFrame();
        JPanel mainPanel = setupMainPanel();
        add(mainPanel);
        setVisible(true);
    }

    private void configureFrame() {
        setTitle("Home Page");
        setSize(800, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(WHITE);
    }

    private JPanel setupMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(WHITE);
        mainPanel.add(setupTopPanel(), BorderLayout.NORTH);
        mainPanel.add(setupCategoriesPanel(), BorderLayout.CENTER);
        mainPanel.add(setupUserPanel(), BorderLayout.EAST);
        return mainPanel;
    }

    private JPanel setupTopPanel() {
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(ORANGE);
        topPanel.setPreferredSize(new Dimension(800, 100));
        topPanel.add(setupTitleLabel(), BorderLayout.NORTH);
        topPanel.add(setupSubTitlePanel(), BorderLayout.CENTER);
        return topPanel;
    }

    private JLabel setupTitleLabel() {
        JLabel titleLabel = new JLabel("                ", JLabel.CENTER);
        titleLabel.setFont(BOLD_ARIAL_32);
        titleLabel.setForeground(WHITE);
        return titleLabel;
    }

    private JPanel setupSubTitlePanel() {
        JPanel subTitlePanel = new JPanel(new FlowLayout());
        subTitlePanel.setBackground(ORANGE);
        JLabel subTitleLabel = new JLabel("Home", JLabel.CENTER);
        subTitleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        subTitleLabel.setFont(BOLD_ARIAL_24);
        subTitleLabel.setForeground(WHITE);
        subTitlePanel.add(subTitleLabel);
        return subTitlePanel;
    }

    private JPanel setupUserPanel() {
        JPanel userPanel = new JPanel();
        userPanel.setBackground(ORANGE);
        userPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        profileButton = new JButton("Profile");
        profileButton.setFont(BOLD_ARIAL_18);
        profileButton.setBackground(WHITE);
        profileButton.setForeground(ORANGE);
        profileButton.addActionListener(this);
        profileButton.setFocusable(false);
        userPanel.add(profileButton);
        return userPanel;
    }

    private JPanel setupCategoriesPanel() {
        categoriesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        categoriesPanel.setBackground(WHITE);
        String[] categories = {"Clothes", "Shoes", "Accessories", "Personal Care", "Makeup", "Home Stuff"};
        for (int i = 0; i < categories.length; i++) {
            String imagePath = null;
            if (i == 0) {
                imagePath = "C:\\Users\\Zümra Gönder\\Desktop\\clothes.jpg";
            } else if (i == 1) {
                imagePath = "C:\\Users\\Zümra Gönder\\Desktop\\shoes.jpg";
            } else if (i == 2) {
                imagePath = "C:\\Users\\Zümra Gönder\\Desktop\\accessories.jpg";
            } else if (i == 3) {
                imagePath = "C:\\Users\\Zümra Gönder\\Desktop\\personalcare.jpg";
            } else if (i == 4) {
                imagePath = "C:\\Users\\Zümra Gönder\\Desktop\\makeup.jpg";
            } else if (i == 5) {
                imagePath = "C:\\Users\\Zümra Gönder\\Desktop\\home.jpg";
            }

            categoriesPanel.add(setupCategoryButton(categories[i], imagePath));
        }
        return categoriesPanel;
    }

    private JPanel setupCategoryButton(String category, String imagePath) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(WHITE);

        JButton categoryButton = new JButton();
        categoryButton.setPreferredSize(new Dimension(200, 100));
        categoryButton.setBackground(WHITE);
        categoryButton.setFocusable(false);

        // Görüntüyü yükleme ve hata ayıklama çıktısı ekleme
        if (imagePath != null) {
            try {
                BufferedImage img = ImageIO.read(new File(imagePath));
                Image scaledImg = img.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
                categoryButton.setIcon(new ImageIcon(scaledImg));
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Görüntü yüklenemedi: " + imagePath);
            }
        } else {
            System.out.println("Geçersiz dosya yolu: " + imagePath);
        }

        JLabel categoryLabel = new JLabel(category, JLabel.CENTER);
        categoryLabel.setFont(BOLD_ARIAL_16);
        categoryLabel.setForeground(Color.BLACK);

        panel.add(categoryButton, BorderLayout.CENTER);
        panel.add(categoryLabel, BorderLayout.SOUTH);

        categoryButton.addActionListener(this);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == profileButton) {
            new ProfilePage(null).setVisible(true);  // null geçiyoruz çünkü MyCardPage artık kullanılmayacak
            this.dispose();
        } else {
            JButton source = (JButton) e.getSource();
            JPanel parentPanel = (JPanel) source.getParent();
            JLabel categoryLabel = (JLabel) parentPanel.getComponent(1);
            String category = categoryLabel.getText();
            this.dispose();
            switch (category) {
                case "Clothes":
                    new CategoriesPage1("Clothes").setVisible(true);
                    break;
                case "Shoes":
                    new CategoriesPage2("Shoes").setVisible(true);
                    break;
                case "Accessories":
                    new CategoriesPage3("Accessories").setVisible(true);
                    break;
                case "Personal Care":
                    new CategoriesPage4("Personal Care").setVisible(true);
                    break;
                case "Makeup":
                    new CategoriesPage5("Makeup").setVisible(true);
                    break;
                case "Home Stuff":
                    new CategoriesPage6("Home Stuff").setVisible(true);
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new HomePage();
    }
}
