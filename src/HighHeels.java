import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HighHeels extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public HighHeels() {
        // Set window title
        setTitle("High Heels");
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

        // Create JLabel for "High Heels" title
        JLabel highHeelsLabel = new JLabel(" Black Leather High Heels");
        highHeelsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        highHeelsLabel.setHorizontalAlignment(SwingConstants.LEFT);
        highHeelsLabel.setForeground(trendyolColor);
        productPanel.add(highHeelsLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create high heels panel
        JPanel highHeelsPanel = new JPanel(new BorderLayout());
        highHeelsPanel.setBackground(Color.WHITE);

        // Add the high heels picture to the high heels panel
        String highHeelsImagePath = "C:/Users/Zümra Gönder/Desktop/shoe1.jpg";
        JLabel highHeelsImageLabel = new JLabel();
        try {
            ImageIcon highHeelsImageIcon = new ImageIcon(highHeelsImagePath);
            Image scaledHighHeelsImage = highHeelsImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            highHeelsImageLabel.setIcon(new ImageIcon(scaledHighHeelsImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        highHeelsPanel.add(highHeelsImageLabel, BorderLayout.CENTER);

        // Add high heels description
        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Color: Black\n" +
                "Material: Faux leather\n" +
                "Heel Height: High (10 cm)\n" +
                "Style: Pumps, Classics\n" +
                "Occasion: Party\n" +
                "Mold: Standard                                             ");
        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE);
        highHeelsPanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $59.99");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        highHeelsPanel.add(priceLabel, BorderLayout.SOUTH);

        // Add high heels panel to the product panel
        productPanel.add(highHeelsPanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "High Heels";
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
                // Close the current HighHeels frame
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
        new HighHeels();
    }
}

