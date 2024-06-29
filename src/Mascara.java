import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mascara extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; // Button for navigating to comments section
    private JLabel trendyolLabel;

    public Mascara() {
        // Set window title
        setTitle("Mascara");
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

        // Create JLabel for "Mascara for Long Eyelash" title
        JLabel mascaraLabel = new JLabel(" Mascara for Long Eyelash");
        mascaraLabel.setFont(new Font("Arial", Font.BOLD, 20));
        mascaraLabel.setHorizontalAlignment(SwingConstants.LEFT);
        mascaraLabel.setForeground(trendyolColor);
        productPanel.add(mascaraLabel, BorderLayout.NORTH);

        // Add product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create mascara panel
        JPanel mascaraPanel = new JPanel(new BorderLayout());
        mascaraPanel.setBackground(Color.WHITE); // White surface

        // Add the mascara picture to the mascara panel
        String mascaraImagePath = "C:/Users/Zümra Gönder/Desktop/makeup5.jpg";
        JLabel mascaraImageLabel = new JLabel();
        try {
            ImageIcon mascaraImageIcon = new ImageIcon(mascaraImagePath);
            Image scaledMascaraImage = mascaraImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            mascaraImageLabel.setIcon(new ImageIcon(scaledMascaraImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        mascaraPanel.add(mascaraImageLabel, BorderLayout.CENTER);

        // Add mascara description
        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Brand: LMN Cosmetics\n" +
                "Type: Mascara\n" +
                "Effect: Lengthening and Volumizing\n" +
                "Color: Black\n" +
                "Formula: Waterproof\n" +
                "Net Weight: 8ml                                         \n");
        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE); // White surface
        mascaraPanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add price label
        JLabel priceLabel = new JLabel("Price: $12.99");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mascaraPanel.add(priceLabel, BorderLayout.SOUTH);

        // Add mascara panel to the product panel
        productPanel.add(mascaraPanel, BorderLayout.CENTER);

        // Create buttons
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get product information
                String productName = "Mascara";
                double productPrice = 12.99; // Sample price

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
                // Close the current Mascara frame
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
        new Mascara();
    }
}
