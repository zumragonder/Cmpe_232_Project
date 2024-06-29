import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CategoriesPage4 extends JFrame implements ActionListener {
    private JButton homeButton;
    private JButton categoryNameButton;
    private JPanel productsPanel;

    public CategoriesPage4(String categoryName) {
        setTitle("Categories Page");
        setSize(800, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 255, 255)); 

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(255, 130, 60)); 
        topPanel.setPreferredSize(new Dimension(800, 100));

        categoryNameButton = new JButton(categoryName);
        categoryNameButton.setFont(new Font("Arial", Font.BOLD, 24));
        categoryNameButton.setForeground(Color.ORANGE); 
        categoryNameButton.setBackground(Color.WHITE);
        categoryNameButton.setFocusPainted(false); 
        categoryNameButton.addActionListener(this);
        categoryNameButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                categoryNameButton.setBackground(new Color(255, 130, 60).darker()); 
            }

            public void mouseReleased(MouseEvent e) {
                categoryNameButton.setBackground(Color.WHITE); 
            }
        });
        topPanel.add(categoryNameButton, BorderLayout.WEST);

        JLabel trendyolLabel = new JLabel("TRENDYOL", JLabel.CENTER);
        trendyolLabel.setFont(new Font("Arial", Font.BOLD, 32));
        trendyolLabel.setForeground(Color.WHITE);
        topPanel.add(trendyolLabel, BorderLayout.NORTH);

        JLabel pageLabel = new JLabel("", JLabel.CENTER);
        pageLabel.setFont(new Font("Arial", Font.BOLD, 18));
        pageLabel.setForeground(Color.WHITE); 
        topPanel.add(pageLabel, BorderLayout.SOUTH);

        homeButton = new JButton("Home");
        homeButton.setFont(new Font("Arial", Font.BOLD, 18));
        homeButton.setBackground(Color.WHITE); 
        homeButton.setForeground(new Color(255, 130, 60)); 
        homeButton.addActionListener(this);
        homeButton.setFocusable(false); 

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 130, 60)); 
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(homeButton);

        topPanel.add(buttonPanel, BorderLayout.EAST);

        productsPanel = new JPanel(new GridLayout(2, 3, 10, 10)); 
        productsPanel.setBackground(new Color(255, 255, 255));
        String[] productImages = {
            "C:/Users/Zümra Gönder/Desktop/care1.jpg",
            "C:/Users/Zümra Gönder/Desktop/care2.jpg",
            "C:/Users/Zümra Gönder/Desktop/care3.jpg",
            "C:/Users/Zümra Gönder/Desktop/care4.jpg",
            "C:/Users/Zümra Gönder/Desktop/care5.jpg",
            "C:/Users/Zümra Gönder/Desktop/care6.jpg"
        };

        for (int i = 0; i < productImages.length; i++) {
            JButton productButton = createProductButton(productImages[i], i);
            productsPanel.add(productButton);
        }

        // Ana paneli düzenle
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(productsPanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    private JButton createProductButton(String imagePath, int index) {
        ImageIcon icon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH));
        JButton productButton = new JButton(icon);
        productButton.setPreferredSize(new Dimension(200, 100)); 
        productButton.setBackground(Color.WHITE); 
        productButton.setForeground(new Color(255, 130, 60)); 
        productButton.setFocusable(false); 
        productButton.addActionListener(this);
        productButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                productButton.setBackground(new Color(255, 130, 60).darker());
            }

            public void mouseReleased(MouseEvent e) {
                productButton.setBackground(Color.WHITE);
                if (index == 0) {
                    new shampoo();
                    dispose();

                }
                else if (index == 1) {
                    new Washgel();
                    dispose();

                }
                else if (index == 2) {
                    new Soaps();
                    dispose();

                }
                else if (index == 3) {
                    new Cream();
                    dispose();

                }
                else if (index == 4) {
                    new RazorBlade();
                    dispose();

                }
                else if (index == 5) {
                    new Comb();
                    dispose();

                }
            }

            public void mouseEntered(MouseEvent e) {
                productButton.setBackground(new Color(255, 130, 60).darker());
            }

            public void mouseExited(MouseEvent e) {
                productButton.setBackground(Color.WHITE);
            }
        });
        return productButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homeButton) {
            dispose(); 
            new HomePage();
        } else if (e.getSource() == categoryNameButton) {
            categoryNameButton.setBackground(new Color(255, 130, 60).darker()); 
        } else {
        }
    }

    public static void main(String[] args) {
        new CategoriesPage4("Category Name");
    }
}
