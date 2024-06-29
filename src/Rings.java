import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rings extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public Rings() {
        // Set window title
        setTitle("Rings");
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

        // Create JLabel for "Oval Diamond Ring" title
        JLabel ringLabel = new JLabel(" Oval Diamond Ring");
        ringLabel.setFont(new Font("Arial", Font.BOLD, 20));
        ringLabel.setHorizontalAlignment(SwingConstants.LEFT);
        ringLabel.setForeground(trendyolColor);
        productPanel.add(ringLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create ring panel
        JPanel ringPanel = new JPanel(new BorderLayout());
        ringPanel.setBackground(Color.WHITE); // White surface

        // Add the ring picture to the ring panel
        String ringImagePath = "C:/Users/Zümra Gönder/Desktop/acc4.jpg";
        JLabel ringImageLabel = new JLabel();
        try {
            ImageIcon ringImageIcon = new ImageIcon(ringImagePath);
            Image scaledRingImage = ringImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            ringImageLabel.setIcon(new ImageIcon(scaledRingImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ringPanel.add(ringImageLabel, BorderLayout.CENTER);

        // Add ring description
        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n"
                + "Material: Silver 925\n"
                + "Type: Ring\n"
                + "Stone: Oval Diamond\n"
                + "Color: Silver\n"
                + "Shape: Oval\n"
                + "Band Width: 2.5 mm\n"
                + "Band Thickness: 1.5 mm\n"
                + "Ring Size: US 7\n"
                + "Weight: 3.5 grams                               ");
        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE); // White surface
        ringPanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $199.99");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ringPanel.add(priceLabel, BorderLayout.SOUTH);

        // Add ring panel to the product panel
        productPanel.add(ringPanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Ring";
                double productPrice = 199.99; // Sample price

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
                // Close the current Rings frame
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
        new Rings();
    }
}

