import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loafers extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public Loafers() {
        // Set window title
        setTitle("Loafers");
        // Set window size
        setSize(800, 500);
        // Set layout
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);

        // Set background color to Trendyol color
        Color trendyolColor = new Color(250, 150, 60);
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

        // Create JLabel for "Brown Leather Loafers for Men" title
        JLabel loafersLabel = new JLabel(" Brown Leather Loafers for Men");
        loafersLabel.setFont(new Font("Arial", Font.BOLD, 20));
        loafersLabel.setHorizontalAlignment(SwingConstants.LEFT);
        loafersLabel.setForeground(trendyolColor);
        productPanel.add(loafersLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create loafers panel
        JPanel loafersPanel = new JPanel(new BorderLayout());
        loafersPanel.setBackground(Color.WHITE);

        // Add the loafers picture to the loafers panel
        String loafersImagePath = "C:/Users/Zümra Gönder/Desktop/shoe3.jpg";
        JLabel loafersImageLabel = new JLabel();
        try {
            ImageIcon loafersImageIcon = new ImageIcon(loafersImagePath);
            Image scaledLoafersImage = loafersImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            loafersImageLabel.setIcon(new ImageIcon(scaledLoafersImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        loafersPanel.add(loafersImageLabel, BorderLayout.CENTER);

        // Add loafers description
        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Color: Brown\n" +
                "Material: Smooth Leather\n" +
                "Style: Loafers\n" +
                "Toe: Rounded\n" +
                "Closure: Slip-On\n" +
                "Sole: Rubber\n" +
                "Occasion: Casual, Formal\n" +
                "Features: Single Saddle Across Instep               ");
        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE);
        loafersPanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $59.99");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loafersPanel.add(priceLabel, BorderLayout.SOUTH);

        // Add loafers panel to the product panel
        productPanel.add(loafersPanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Loafers";
                double productPrice = 59.99; // Sample price

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
                // Create an instance of ShoesComment
                ShoesComment commentPage = new ShoesComment();
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
                // Close the current Loafers frame
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
        new Loafers();
    }
}
