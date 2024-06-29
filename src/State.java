import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class State extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public State() {
        // Set window title
        setTitle("State");
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

        // Create JLabel for "Modern State" title
        JLabel stateLabel = new JLabel("Modern State");
        stateLabel.setFont(new Font("Arial", Font.BOLD, 20));
        stateLabel.setHorizontalAlignment(SwingConstants.LEFT);
        stateLabel.setForeground(trendyolColor);
        productPanel.add(stateLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create state panel
        JPanel statePanel = new JPanel(new BorderLayout());
        statePanel.setBackground(Color.WHITE); // White surface

        // Add the product picture to the state panel
        String stateImagePath = "C:/Users/Zümra Gönder/Desktop/home5.jpg";
        JLabel stateImageLabel = new JLabel();
        try {
            ImageIcon stateImageIcon = new ImageIcon(stateImagePath);
            Image scaledStateImage = stateImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            stateImageLabel.setIcon(new ImageIcon(scaledStateImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        statePanel.add(stateImageLabel, BorderLayout.CENTER);
        
        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Brand: RST Rugs\n" +
                "Type: Area Rug\n" +
                "Color: Gray, Blue, Beige\n" +
                "Material: Polypropylene\n" +
                "Size: 5' x 7'\n" +
                "Features: Contemporary design, \n" +
                "soft and durable, \n" +
                "easy to clean \n");

        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE); // White surface
        statePanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: 35.00");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statePanel.add(priceLabel, BorderLayout.SOUTH);

        // Add state panel to the product panel
        productPanel.add(statePanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "State";
                double productPrice = 35.00; // Sample price

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
                // Create an instance of HomeComment
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
                // Close the current State frame
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
        // Create an instance of State
        new State();
    }
}
