import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lamp extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public Lamp() {
        // Set window title
        setTitle("Lamp");
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

        // Create JLabel for "Yellow Light Lamp" title
        JLabel classyLampLabel = new JLabel(" Yellow Light Lamp");
        classyLampLabel.setFont(new Font("Arial", Font.BOLD, 20));
        classyLampLabel.setHorizontalAlignment(SwingConstants.LEFT);
        classyLampLabel.setForeground(trendyolColor);
        productPanel.add(classyLampLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create lamp panel
        JPanel lampPanel = new JPanel(new BorderLayout());
        lampPanel.setBackground(Color.WHITE); // White surface

        // Add the lamp picture to the lamp panel
        String lampImagePath = "C:/Users/Zümra Gönder/Desktop/home4.jpg";
        JLabel lampImageLabel = new JLabel();
        try {
            ImageIcon lampImageIcon = new ImageIcon(lampImagePath);
            Image scaledLampImage = lampImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            lampImageLabel.setIcon(new ImageIcon(scaledLampImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        lampPanel.add(lampImageLabel, BorderLayout.CENTER);

        // Add lamp description
        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Brand: XYZ Lighting\n" +
                "Type: Table Lamp\n" +
                "Material: Ceramic Base, Fabric Shade\n" +
                "Color: White\n" +
                "Dimensions: 18\"H x 10\"W\n" +
                "Features: Modern design, adjustable brightness,\n"
                + "easy to clean  \n");
        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE); // White surface
        lampPanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: 49.99");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lampPanel.add(priceLabel, BorderLayout.SOUTH);

        // Add lamp panel to the product panel
        productPanel.add(lampPanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Lamp";
                double productPrice = 49.99; // Sample price

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
                HomeComment commentPage = new HomeComment();
                // Make the commentPage visible
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
                // Close the current Lamp frame
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
        new Lamp();
    }
}
