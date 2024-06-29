import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cardigans extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton;
    private JLabel trendyolLabel;

    public Cardigans() {
        // Set window title
        setTitle("Cardigan");
        // Set window size
        setSize(800, 500);
        // Set layout
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);

        // Set background color to Trendyol color
        Color trendyolColor = new Color(250, 130, 60);
        getContentPane().setBackground(trendyolColor);

        // Create JLabel for "Trendyol" text
        trendyolLabel = new JLabel("Trendyol");
        trendyolLabel.setFont(new Font("Arial", Font.BOLD, 24));
        trendyolLabel.setHorizontalAlignment(SwingConstants.CENTER);
        trendyolLabel.setForeground(Color.WHITE);
        add(trendyolLabel, BorderLayout.NORTH);

        // Create panel for Product Page section
        JPanel productPanel = new JPanel(new BorderLayout());
        productPanel.setBorder(BorderFactory.createLineBorder(trendyolColor, 2));

        // Create JLabel for "Beige Cardigan Sweater for Women" title
        JLabel cardiganLabel = new JLabel(" Beige Cardigan Sweater for Women");
        cardiganLabel.setFont(new Font("Arial", Font.BOLD, 20));
        cardiganLabel.setHorizontalAlignment(SwingConstants.LEFT);
        cardiganLabel.setForeground(trendyolColor);
        productPanel.add(cardiganLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create cardigans panel
        JPanel cardigansPanel = new JPanel(new BorderLayout());
        cardigansPanel.setBackground(Color.WHITE); // White surface

        // Add the cardigan picture to the cardigans panel
        String cardiganImagePath = "C:/Users/Zümra Gönder/Desktop/clothe5.jpg";
        JLabel cardiganImageLabel = new JLabel();
        try {
            ImageIcon cardiganImageIcon = new ImageIcon(cardiganImagePath);
            Image scaledCardiganImage = cardiganImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            cardiganImageLabel.setIcon(new ImageIcon(scaledCardiganImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        cardigansPanel.add(cardiganImageLabel, BorderLayout.CENTER);

        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Color: Beige\n" +
                "Material: Mid-weight Knit\n" +
                "Neckline: V-neck\n" +
                "Closure: Buttons\n" +
                "Sleeve length: Long\n" +
                "Gender: Women\n" +
                "Hem length: Hip-length             \n");

        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE);
        cardigansPanel.add(descriptionTextArea, BorderLayout.EAST);

        JLabel priceLabel = new JLabel("Price: $59.99");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cardigansPanel.add(priceLabel, BorderLayout.SOUTH);

        productPanel.add(cardigansPanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Cardigan";
                double productPrice = 59.99;

                // Create an instance of MyCardPage only when adding a product
                MyCardPage cardPage = new MyCardPage();
                // Add the product to the card
                cardPage.addProductToCard(productName, productPrice);
                // Show the card page
                cardPage.setVisible(true);
            }
        });

        commentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create an instance of ClothesComment
                ClothesComment commentPage = new ClothesComment();
                // Make the commentPage visible
                commentPage.setVisible(true);
            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create an instance of HomePage
                HomePage homePage = new HomePage();
                // Make the homePage visible
                homePage.setVisible(true);
                // Close the current Cardigans frame
                dispose();
            }
        });

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(trendyolColor);
        buttonPanel.add(addToCartButton);
        buttonPanel.add(commentsButton);
        buttonPanel.add(homeButton);

        // Add button panel to the frame
        add(buttonPanel, BorderLayout.SOUTH);

        // Set window visibility
        setVisible(true);
        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Create an instance of ClassyShoes
        new Cardigans();
    }
}
