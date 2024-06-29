
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Watches extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public Watches() {
        // Set window title
        setTitle("Watch");
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

        // Create JLabel for "Classy Silver Watch Unisex" title
        JLabel classyWatchLabel = new JLabel("  Classy Silver Watch Unisex");
        classyWatchLabel.setFont(new Font("Arial", Font.BOLD, 20));
        classyWatchLabel.setHorizontalAlignment(SwingConstants.LEFT);
        classyWatchLabel.setForeground(trendyolColor);
        productPanel.add(classyWatchLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create watch panel
        JPanel watchPanel = new JPanel(new BorderLayout());
        watchPanel.setBackground(Color.WHITE); // White surface

        // Add the watch picture to the watch panel
        String watchImagePath = "C:/Users/Zümra Gönder/Desktop/acc1.jpg";
        JLabel watchImageLabel = new JLabel();
        try {
            ImageIcon watchImageIcon = new ImageIcon(watchImagePath);
            Image scaledWatchImage = watchImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            watchImageLabel.setIcon(new ImageIcon(scaledWatchImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        watchPanel.add(watchImageLabel, BorderLayout.CENTER);

        // Add watch description
        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Brand: Swatch\n" +
                "Material: Stainless Steel\n" +
                "Type: Analog\n" +
                "Color: Silver\n" +
                "Features: Water-resistant, Chronograph, Date Display\n" + 
                "Display: Analog\n" +
                "Case Shape: Round\n" +
                "Dial Color: Black\n" +
                "Case Diameter: 42 mm\n" +
                "Case Thickness: 11 mm\n" +
                "Warranty: 2 years "); 
        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 16));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE); // White surface
        watchPanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $99.99");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        watchPanel.add(priceLabel, BorderLayout.SOUTH);

        // Add watch panel to the product panel
        productPanel.add(watchPanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Watch";
                double productPrice = 99.99; // Sample price

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
                // Close the current Watches frame
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
        // Create an instance of Watches
        new Watches();
    }
}
