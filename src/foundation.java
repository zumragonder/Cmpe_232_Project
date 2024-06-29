import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class foundation extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public foundation() {
        // Set window title
        setTitle("Foundation");
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

        // Create JLabel for "Foundation Num:02" title
        JLabel foundationLabel = new JLabel(" Foundation Num:02");
        foundationLabel.setFont(new Font("Arial", Font.BOLD, 20));
        foundationLabel.setHorizontalAlignment(SwingConstants.LEFT);
        foundationLabel.setForeground(trendyolColor);
        productPanel.add(foundationLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create foundation panel
        JPanel foundationPanel = new JPanel(new BorderLayout());
        foundationPanel.setBackground(Color.WHITE); // White surface

        // Add the foundation picture to the foundation panel
        String foundationImagePath = "C:/Users/Zümra Gönder/Desktop/makeup4.jpg";
        JLabel foundationImageLabel = new JLabel();
        try {
            ImageIcon foundationImageIcon = new ImageIcon(foundationImagePath);
            Image scaledFoundationImage = foundationImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            foundationImageLabel.setIcon(new ImageIcon(scaledFoundationImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        foundationPanel.add(foundationImageLabel, BorderLayout.CENTER);
        
        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Brand: JKL Beauty\n" +
                "Type: Foundation\n" +
                "Shade: Natural Beige\n" +
                "Coverage: Medium to Full\n" +
                "Finish: Dewy\n" +
                "Net Weight: 30ml                                   \n");

        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE); // White surface
        foundationPanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $20.99");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        foundationPanel.add(priceLabel, BorderLayout.SOUTH);

        // Add foundation panel to the product panel
        productPanel.add(foundationPanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Foundation";
                double productPrice = 20.99; // Sample price

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
                // Close the current Foundation frame
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
        new foundation();
    }
}

