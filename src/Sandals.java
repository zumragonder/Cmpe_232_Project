import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sandals extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public Sandals() {
        // Set window title
        setTitle("Sandals");
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

        // Create JLabel for "Sandals" title
        JLabel sandalsLabel = new JLabel(" Children's Sandals for Summer");
        sandalsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        sandalsLabel.setHorizontalAlignment(SwingConstants.LEFT);
        sandalsLabel.setForeground(trendyolColor);
        productPanel.add(sandalsLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create sandals panel
        JPanel sandalsPanel = new JPanel(new BorderLayout());
        sandalsPanel.setBackground(Color.WHITE);

        // Add the sandal picture to the sandals panel
        String sandalImagePath = "C:/Users/Zümra Gönder/Desktop/shoe5.jpg";
        JLabel sandalImageLabel = new JLabel();
        try {
            ImageIcon sandalImageIcon = new ImageIcon(sandalImagePath);
            Image scaledSandalImage = sandalImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            sandalImageLabel.setIcon(new ImageIcon(scaledSandalImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        sandalsPanel.add(sandalImageLabel, BorderLayout.CENTER);

        // Add sandal description
        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Color: Brown\n" +
                "Material: Smooth Leather\n" +
                "Design: Single strap\n" +
                "Suitable for: Children\n" +
                "Occasion: Beach, Park\n" +
                "Mold: Standard\n" +
                "Lightweight and comfortable                   "
        );
        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE);
        sandalsPanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $39.99");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        sandalsPanel.add(priceLabel, BorderLayout.SOUTH);

        // Add sandals panel to the product panel
        productPanel.add(sandalsPanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Sandals";
                double productPrice = 39.99; // Sample price

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
                // Close the current Sandals frame
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
        new Sandals();
    }
}
