import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chair extends JFrame {
    private JButton addToCartButton;
    private JButton commentsButton; 
    private JLabel trendyolLabel;

    public Chair() {
        // Set up the window
        setTitle("Chair");
        setSize(800, 500);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);

        // Set the background color
        Color trendyolColor = new Color(250, 130, 60);
        getContentPane().setBackground(trendyolColor);

        // Create and configure the Trendyol label
        trendyolLabel = new JLabel("Trendyol");
        trendyolLabel.setFont(new Font("Arial", Font.BOLD, 24));
        trendyolLabel.setHorizontalAlignment(SwingConstants.CENTER);
        trendyolLabel.setForeground(Color.WHITE);
        add(trendyolLabel, BorderLayout.NORTH);

        // Create the panel for the product information
        JPanel productPanel = new JPanel(new BorderLayout());
        productPanel.setBorder(BorderFactory.createLineBorder(trendyolColor, 2));

        // Create and configure the label for the product title
        JLabel chairLabel = new JLabel(" Confortable Chair");
        chairLabel.setFont(new Font("Arial", Font.BOLD, 20));
        chairLabel.setHorizontalAlignment(SwingConstants.LEFT);
        chairLabel.setForeground(trendyolColor);
        productPanel.add(chairLabel, BorderLayout.NORTH);

        // Add the product panel to the frame
        add(productPanel, BorderLayout.CENTER);

        // Create the panel for displaying the chair image and description
        JPanel chairPanel = new JPanel(new BorderLayout());
        chairPanel.setBackground(Color.WHITE); 

        // Add the chair image to the panel
        String chairImagePath = "C:/Users/Zümra Gönder/Desktop/home2.jpg";
        JLabel chairImageLabel = new JLabel();
        try {
            ImageIcon chairImageIcon = new ImageIcon(chairImagePath);
            Image scaledChairImage = chairImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            chairImageLabel.setIcon(new ImageIcon(scaledChairImage));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        chairPanel.add(chairImageLabel, BorderLayout.CENTER);
        
        // Add the description of the chair to the panel
        JTextArea descriptionTextArea = new JTextArea("\n\nProduct details:\n" +
                "Brand: XYZ Furniture\n" +
                "Type: Sofa\n" +
                "Color: Gray\n" +
                "Material: Fabric\n" +
                "Dimensions: 80\"W x 36\"D x 32\"H\n" +
                "Features: Comfortable seating, \n"
                + "sturdy wooden frame                              \n");
        descriptionTextArea.setFont(new Font("Arial", Font.BOLD, 20));
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.WHITE);
        chairPanel.add(descriptionTextArea, BorderLayout.EAST);

        // Add the price label to the panel
        JLabel priceLabel = new JLabel("Price: $49.99");
        priceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        chairPanel.add(priceLabel, BorderLayout.SOUTH);

        // Add the chair panel to the product panel
        productPanel.add(chairPanel, BorderLayout.CENTER);

        // Create buttons for adding to cart, viewing comments, and returning home
        addToCartButton = new JButton("Add to Cart");
        commentsButton = new JButton("Comments");
        JButton homeButton = new JButton("Home");

        // Add action listeners to the buttons
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productName = "Chair";
                double productPrice = 49.99; 

                MyCardPage cardPage = new MyCardPage();
                cardPage.addProductToCard(productName, productPrice);
                cardPage.setVisible(true);
            }
        });

        commentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeComment commentPage = new HomeComment();
                commentPage.setVisible(true);
            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomePage homePage = new HomePage();
                homePage.setVisible(true);
                dispose();
            }
        });

        // Create a panel for the buttons and add them to it
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(trendyolColor);
        buttonPanel.add(addToCartButton);
        buttonPanel.add(commentsButton); 
        buttonPanel.add(homeButton);

        // Add the button panel to the frame
        add(buttonPanel, BorderLayout.SOUTH);

        // Set the window visible and specify the close operation
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Create an instance of ClassyShoes
        new Chair();
    }
}
