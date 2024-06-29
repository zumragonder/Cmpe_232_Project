import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Wardrope extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel wardropeLabel;

    public Wardrope() {
        // Set window title
        setTitle("Wardrope");
        // Set window size
        setSize(800, 500);
        // Set layout
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);

        // Set background color to Trendyol color
        Color trendyolColor = new Color(250, 130, 60);
        getContentPane().setBackground(trendyolColor);

        // Create JLabel for "Wardrope" text
        wardropeLabel = new JLabel("Wardrope");
        wardropeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        wardropeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        wardropeLabel.setForeground(Color.WHITE);
        add(wardropeLabel, BorderLayout.NORTH);

        // Create panel for Product Page section
        JPanel productPanel = new JPanel(new BorderLayout());
        productPanel.setBorder(BorderFactory.createLineBorder(trendyolColor, 2));

        // Create JLabel for "Dark Brown Wardrope" title
        JLabel wardropeTitleLabel = new JLabel("Dark Brown Wardrope");
        wardropeTitleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        wardropeTitleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        wardropeTitleLabel.setForeground(trendyolColor);
        productPanel.add(wardropeTitleLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create wardrope panel
        JPanel wardropePanel = new JPanel(new BorderLayout());
        wardropePanel.setBackground(Color.WHITE); // White surface

        // Add the wardrope picture to the wardrope panel
        String wardropeImagePath = "C:/Users/Zümra Gönder/Desktop/home6.jpg";
        JLabel wardropeImageLabel = new JLabel();
        try {
            ImageIcon wardropeImageIcon = new ImageIcon(wardropeImagePath);
            Image scaledWardropeImage = wardropeImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            wardropeImageLabel.setIcon(new ImageIcon(scaledWardropeImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        wardropePanel.add(wardropeImageLabel, BorderLayout.CENTER);
        
        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Brand: LMN Furniture\n" +
                "Type: Wardrope\n" +
                "Color: Dark Brown\n" +
                "Material: MDF (Medium-Density Fiberboard)\n" +
                "Dimensions: 72\"H x 48\"W x 24\"D\n" +
                "Features: Spacious storage, "
                + "\nsturdy construction, modern design\n");




        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE); // White surface
        wardropePanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $85.00");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        wardropePanel.add(priceLabel, BorderLayout.SOUTH);

        // Add wardrope panel to the product panel
        productPanel.add(wardropePanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Wardrope";
                double productPrice = 85.00; // Sample price

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
                HomeComment commentPage = new HomeComment();
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
                // Close the current Wardrope frame
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
        // Create an instance of Sandals
        new Wardrope();
    }
}