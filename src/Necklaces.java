import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Necklaces extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public Necklaces() {
        // Set window title
        setTitle("Necklace");
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

        // Create JLabel for "Necklace" title
        JLabel classyNecklaceLabel = new JLabel(" Necklace");
        classyNecklaceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        classyNecklaceLabel.setHorizontalAlignment(SwingConstants.LEFT);
        classyNecklaceLabel.setForeground(trendyolColor);
        productPanel.add(classyNecklaceLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create necklace panel
        JPanel necklacePanel = new JPanel(new BorderLayout());
        necklacePanel.setBackground(Color.WHITE); // White surface

        // Add the necklace picture to the necklace panel
        String necklaceImagePath = "C:/Users/Zümra Gönder/Desktop/acc3.jpg";
        JLabel necklaceImageLabel = new JLabel();
        try {
            ImageIcon necklaceImageIcon = new ImageIcon(necklaceImagePath);
            Image scaledNecklaceImage = necklaceImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            necklaceImageLabel.setIcon(new ImageIcon(scaledNecklaceImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        necklacePanel.add(necklaceImageLabel, BorderLayout.CENTER);

        // Add necklace description
        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Material: 18K White Gold\n" +
                "Color: White\n" +
                "Type: Necklace\n" +
                "Pendant: Diamond                                   \n");
        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE); // White surface
        necklacePanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $39.99");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        necklacePanel.add(priceLabel, BorderLayout.SOUTH);

        // Add necklace panel to the product panel
        productPanel.add(necklacePanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Necklace";
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
                // Close the current Necklaces frame
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
        new Necklaces();
    }
}
