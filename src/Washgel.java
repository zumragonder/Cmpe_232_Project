import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Washgel extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public Washgel() {
        // Set window title
        setTitle("Washgel");
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

        // Create JLabel for "Face Wash Gel Against Blackheads" title
        JLabel washgelLabel = new JLabel(" Face Wash Gel Against Blackheads");
        washgelLabel.setFont(new Font("Arial", Font.BOLD, 20));
        washgelLabel.setHorizontalAlignment(SwingConstants.LEFT);
        washgelLabel.setForeground(trendyolColor);
        productPanel.add(washgelLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create washgel panel
        JPanel washgelPanel = new JPanel(new BorderLayout());
        washgelPanel.setBackground(Color.WHITE); // White surface

        // Add the washgel picture to the washgel panel
        String washgelImagePath = "C:/Users/Zümra Gönder/Desktop/care2.jpg";
        JLabel washgelImageLabel = new JLabel();
        try {
            ImageIcon washgelImageIcon = new ImageIcon(washgelImagePath);
            Image scaledWashgelImage = washgelImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            washgelImageLabel.setIcon(new ImageIcon(scaledWashgelImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        washgelPanel.add(washgelImageLabel, BorderLayout.CENTER);

        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Brand: PQR\n" +
                "Type: Facial Cleanser\n" +
                "Variant: Acne Control\n" +
                "Size: 150ml\n" +
                "Skin Type: Oily/Combination                    \n");

        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE); // White surface
        washgelPanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $8.99");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        washgelPanel.add(priceLabel, BorderLayout.SOUTH);

        // Add washgel panel to the product panel
        productPanel.add(washgelPanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Wash gel";
                double productPrice = 8.99; // Sample price

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
                CareComment commentPage = new CareComment();
                // Make the commentPage visible
                commentPage.setVisible(true);
                // Close the current Washgel frame
            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create an instance of HomePage
                HomePage homePage = new HomePage();
                // Make the homePage visible
                homePage.setVisible(true);
                // Close the current Washgel frame
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
        // Create an instance of Sneakers
        new Washgel();
    }
}
