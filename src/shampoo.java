import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class shampoo extends JFrame { // "Shampoo" olarak değiştirildi
    private JButton addToCartButton;
    private JButton commentsButton; // Yorum satırını güncelledim: Navigating to comments section için
    private JLabel trendyolLabel;

    public shampoo() { // Constructor adı değiştirildi
        // Set window title
        setTitle("Shampoo");
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

        // Create JLabel for "Shampoo for All Hair Types" title
        JLabel shampooLabel = new JLabel(" Shampoo for All Hair Types");
        shampooLabel.setFont(new Font("Arial", Font.BOLD, 20));
        shampooLabel.setHorizontalAlignment(SwingConstants.LEFT);
        shampooLabel.setForeground(trendyolColor);
        productPanel.add(shampooLabel, BorderLayout.NORTH); // "Shampoo" olarak değiştirildi

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create shoes panel
        JPanel shampooPanel = new JPanel(new BorderLayout()); // "shoesPanel" yerine "shampooPanel" olarak değiştirildi
        shampooPanel.setBackground(Color.WHITE); // White surface

        // Add the shampoo picture to the shampoo panel
        String shampooImagePath = "C:/Users/Zümra Gönder/Desktop/care1.jpg"; // "shoeImagePath" yerine "shampooImagePath" olarak değiştirildi
        JLabel shampooImageLabel = new JLabel(); // "shoeImageLabel" yerine "shampooImageLabel" olarak değiştirildi
        try {
            ImageIcon shampooImageIcon = new ImageIcon(shampooImagePath); // "shoeImageIcon" yerine "shampooImageIcon" olarak değiştirildi
            Image scaledShampooImage = shampooImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH); // "scaledShoeImage" yerine "scaledShampooImage" olarak değiştirildi
            shampooImageLabel.setIcon(new ImageIcon(scaledShampooImage)); // "shoeImageLabel" yerine "shampooImageLabel" olarak değiştirildi
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        shampooPanel.add(shampooImageLabel, BorderLayout.CENTER); // "shoeImageLabel" yerine "shampooImageLabel" olarak değiştirildi

        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Brand: ABC\n" +
                "Type: Shampoo\n" +
                "Variant: Moisturizing\n" +
                "Size: 300ml\n" +
                "Hair Type: All hair types                                ");

        
        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE); // White surface
        shampooPanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $5.00");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        shampooPanel.add(priceLabel, BorderLayout.SOUTH);

        // Add shampoo panel to the product panel
        productPanel.add(shampooPanel, BorderLayout.CENTER); // "shoesPanel" yerine "shampooPanel" olarak değiştirildi

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Shampoo";
                double productPrice = 5.00; // Sample price

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
                // Create an instance of CareComment
                CareComment commentPage = new CareComment(); // "ShoesComment" yerine "CareComment" olarak değiştirildi
                // Make the commentPage visible
                commentPage.setVisible(true);
                // Close the current frame
            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create an instance of HomePage
                HomePage homePage = new HomePage();
                // Make the homePage visible
                homePage.setVisible(true);
                // Close the current Shampoo frame
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
        // Create an instance of ClassyShoes
        new shampoo();
    }
}

