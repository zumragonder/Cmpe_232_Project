import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lipstick extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public Lipstick() {
        // Set window title
        setTitle("Lipstick");
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

        // Create JLabel for "Red Lipstick for Night" title
        JLabel lipstickLabel = new JLabel(" Red Lipstick for Night");
        lipstickLabel.setFont(new Font("Arial", Font.BOLD, 20));
        lipstickLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lipstickLabel.setForeground(trendyolColor);
        productPanel.add(lipstickLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create lipstick panel
        JPanel lipstickPanel = new JPanel(new BorderLayout());
        lipstickPanel.setBackground(Color.WHITE); // White surface

        // Add the lipstick picture to the lipstick panel
        String lipstickImagePath = "C:/Users/Zümra Gönder/Desktop/makeup1.jpg";
        JLabel lipstickImageLabel = new JLabel();
        try {
            ImageIcon lipstickImageIcon = new ImageIcon(lipstickImagePath);
            Image scaledLipstickImage = lipstickImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            lipstickImageLabel.setIcon(new ImageIcon(scaledLipstickImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        lipstickPanel.add(lipstickImageLabel, BorderLayout.CENTER);

        // Add lipstick description
        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Brand: XYZ Cosmetics\n" +
                "Type: Lipstick\n" +
                "Color: Ruby Red\n" +
                "Finish: Matte\n" +
                "Net Weight: 3.5g                                     \n");
        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE); // White surface
        lipstickPanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $14.99");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lipstickPanel.add(priceLabel, BorderLayout.SOUTH);

        // Add lipstick panel to the product panel
        productPanel.add(lipstickPanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Lipstick";
                double productPrice = 14.99; // Sample price

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
                // Create an instance of MakeupComment
                MakeupComment commentPage = new MakeupComment();
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
                // Close the current Lipstick frame
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
        new Lipstick();
    }
}

