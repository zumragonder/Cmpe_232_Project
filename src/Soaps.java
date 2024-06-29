import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Soaps extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public Soaps() {
        // Set window title
        setTitle("Soap");
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

        // Create JLabel for "White Soap" title
        JLabel whiteSoapLabel = new JLabel(" White Soap");
        whiteSoapLabel.setFont(new Font("Arial", Font.BOLD, 20));
        whiteSoapLabel.setHorizontalAlignment(SwingConstants.LEFT);
        whiteSoapLabel.setForeground(trendyolColor);
        productPanel.add(whiteSoapLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create soap panel
        JPanel soapPanel = new JPanel(new BorderLayout());
        soapPanel.setBackground(Color.WHITE); // White surface

        // Add the soap picture to the soap panel
        String soapImagePath = "C:/Users/Zümra Gönder/Desktop/care3.jpg";
        JLabel soapImageLabel = new JLabel();
        try {
            ImageIcon soapImageIcon = new ImageIcon(soapImagePath);
            Image scaledSoapImage = soapImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            soapImageLabel.setIcon(new ImageIcon(scaledSoapImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        soapPanel.add(soapImageLabel, BorderLayout.CENTER);

        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Brand: XYZ\n" +
                "Type: White Soap\n" +
                "Scent: Fresh\n" +
                "Weight: 100g                                    \n");
        
        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE); // White surface
        soapPanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $2.99");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        soapPanel.add(priceLabel, BorderLayout.SOUTH);

        // Add soap panel to the product panel
        productPanel.add(soapPanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Soap";
                double productPrice = 2.99; // Sample price

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
                // Close the current Soaps frame
            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create an instance of HomePage
                HomePage homePage = new HomePage();
                // Make the homePage visible
                homePage.setVisible(true);
                // Close the current Soaps frame
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
        new Soaps();
    }
}
