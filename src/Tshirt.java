

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tshirt extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public Tshirt() {
        // Set window title
        setTitle("Tshirt");
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

        // Create JLabel for "Unisex Plain Turquoise T-shirt" title
        JLabel classyTshirtLabel = new JLabel(" Unisex Plain Turquoise T-shirt");
        classyTshirtLabel.setFont(new Font("Arial", Font.BOLD, 20));
        classyTshirtLabel.setHorizontalAlignment(SwingConstants.LEFT);
        classyTshirtLabel.setForeground(trendyolColor);
        productPanel.add(classyTshirtLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create tshirt panel
        JPanel tshirtPanel = new JPanel(new BorderLayout());
        tshirtPanel.setBackground(Color.WHITE); // White surface

        // Add the tshirt picture to the tshirt panel
        String tshirtImagePath = "C:/Users/Zümra Gönder/Desktop/clothe3.jpg";
        JLabel tshirtImageLabel = new JLabel();
        try {
            ImageIcon tshirtImageIcon = new ImageIcon(tshirtImagePath);
            Image scaledTshirtImage = tshirtImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            tshirtImageLabel.setIcon(new ImageIcon(scaledTshirtImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        tshirtPanel.add(tshirtImageLabel, BorderLayout.CENTER);

        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Color: Turquoise\n" +
                "Gender: Unisex\n" +
                "Style: Plain\n" +
                "Material: Cotton\n" +
                "Sleeve: Short                                             \n" );


        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE); // White surface
        tshirtPanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $29.99");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tshirtPanel.add(priceLabel, BorderLayout.SOUTH);

        // Add tshirt panel to the product panel
        productPanel.add(tshirtPanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Tshirt";
                double productPrice = 29.99; // Sample price

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
                // Create an instance of CommentPage
                ClothesComment commentPage = new ClothesComment();
                // Make the commentPage visible
                commentPage.setVisible(true);
                // Close the current Tshirt frame
            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create an instance of HomePage
                HomePage homePage = new HomePage();
                // Make the homePage visible
                homePage.setVisible(true);
                // Close the current Tshirt frame
                dispose();
            }
        });

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(trendyolColor);
        buttonPanel.add(addToCartButton);
        buttonPanel.add(commentsButton); // Add the Comments button
        buttonPanel.add(homeButton);

        // Add button panel to the frame
        add(buttonPanel, BorderLayout.SOUTH);

        // Set window visibility
        setVisible(true);
        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Create an instance of Tshirt
        new Tshirt();
    }
}
