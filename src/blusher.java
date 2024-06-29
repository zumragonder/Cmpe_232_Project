import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class blusher extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public blusher() {
        setTitle("Blusher");
        setSize(800, 500);
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

        // Create JLabel for "Blusher" title
        JLabel blusherLabel = new JLabel(" Pink Blusher for Cute Women");
        blusherLabel.setFont(new Font("Arial", Font.BOLD, 20));
        blusherLabel.setHorizontalAlignment(SwingConstants.LEFT);
        blusherLabel.setForeground(trendyolColor);
        productPanel.add(blusherLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create blusher panel
        JPanel blusherPanel = new JPanel(new BorderLayout());
        blusherPanel.setBackground(Color.WHITE); // White surface

        // Add the blusher picture to the blusher panel
        String blusherImagePath = "C:/Users/Zümra Gönder/Desktop/makeup3.jpg";
        JLabel blusherImageLabel = new JLabel();
        try {
            ImageIcon blusherImageIcon = new ImageIcon(blusherImagePath);
            Image scaledBlusherImage = blusherImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            blusherImageLabel.setIcon(new ImageIcon(scaledBlusherImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        blusherPanel.add(blusherImageLabel, BorderLayout.CENTER);

        // Some informations about product
        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Brand: GHI Cosmetics\n" +
                "Type: Blush\n" +
                "Shade: Peachy Pink\n" +
                "Finish: Matte\n" +
                "Net Weight: 8g                                           \n");

        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE); // White surface
        blusherPanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $8.00");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        blusherPanel.add(priceLabel, BorderLayout.SOUTH);

        // Add blusher panel to the product panel
        productPanel.add(blusherPanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Blusher";
                double productPrice = 8.00; // Sample price

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
        // Create an instance of blusher
        new blusher();
    }
}
