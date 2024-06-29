import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cream extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public Cream() {
        // Set window title
        setTitle("Cream");
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

        // Create JLabel for "Cream" title
        JLabel creamLabel = new JLabel(" Cream For Dry Skin");
        creamLabel.setFont(new Font("Arial", Font.BOLD, 20));
        creamLabel.setHorizontalAlignment(SwingConstants.LEFT);
        creamLabel.setForeground(trendyolColor);
        productPanel.add(creamLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create cream panel
        JPanel creamPanel = new JPanel(new BorderLayout());
        creamPanel.setBackground(Color.WHITE); // White surface

        // Add the cream picture to the cream panel
        String creamImagePath = "C:/Users/Zümra Gönder/Desktop/care4.jpg";
        JLabel creamImageLabel = new JLabel();
        try {
            ImageIcon creamImageIcon = new ImageIcon(creamImagePath);
            Image scaledCreamImage = creamImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            creamImageLabel.setIcon(new ImageIcon(scaledCreamImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        creamPanel.add(creamImageLabel, BorderLayout.CENTER);

        // Add cream description
        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Brand: MNO\n" +
                "Type: Face Cream\n" +
                "Variant: Moisturizing\n" +
                "Size: 50ml\n" +
                "Skin Type: Dry/Sensitive                        \n");

        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE); // White surface
        creamPanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $7.00");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        creamPanel.add(priceLabel, BorderLayout.SOUTH);

        // Add cream panel to the product panel
        productPanel.add(creamPanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Cream";
                double productPrice = 7.00; // Sample price

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
                CareComment commentPage = new CareComment();
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
        new Cream();
    }
}
