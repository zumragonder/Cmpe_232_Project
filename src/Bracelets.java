import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bracelets extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public Bracelets() {
        // Set window title
        setTitle("Bracelets");
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

        // Create JLabel for "Silver Bracelet with Celtic Knot Patterns" title
        JLabel braceletLabel = new JLabel(" Silver Bracelet with Celtic Knot Patterns");
        braceletLabel.setFont(new Font("Arial", Font.BOLD, 20));
        braceletLabel.setHorizontalAlignment(SwingConstants.LEFT);
        braceletLabel.setForeground(trendyolColor);
        productPanel.add(braceletLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create bracelet panel
        JPanel braceletPanel = new JPanel(new BorderLayout());
        braceletPanel.setBackground(Color.WHITE); // White surface

        // Add the bracelet picture to the bracelet panel
        String braceletImagePath = "C:/Users/Zümra Gönder/Desktop/acc2.jpg";
        JLabel braceletImageLabel = new JLabel();
        try {
            ImageIcon braceletImageIcon = new ImageIcon(braceletImagePath);
            Image scaledBraceletImage = braceletImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            braceletImageLabel.setIcon(new ImageIcon(scaledBraceletImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        braceletPanel.add(braceletImageLabel, BorderLayout.CENTER);

        // Some informations about product
        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Brand: Celtic Creations\n" +
                "Material: Stainless Steel\n"+
                "Color: Silver\n" +
                "Gender: Unisex\n" +
                "Occasion: Casual\n" +
                "Closure: Lobster Clasp\n" +
                "Weight: 50 grams\n" +
                "Length: Adjustable\n" +
                "Warranty: 1 year                                          ");
        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE); // White surface
        braceletPanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $29.99");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        braceletPanel.add(priceLabel, BorderLayout.SOUTH);

        // Add bracelet panel to the product panel
        productPanel.add(braceletPanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Bracelet";
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
                // Create an instance of AccessoriesComment
                AccessoriesComment commentPage = new AccessoriesComment();
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
                // Close the current frame
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
        new Bracelets();
    }
}