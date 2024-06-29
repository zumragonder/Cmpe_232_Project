import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentPage extends JFrame {
    private JLabel trendyolLabel;
    private JLabel totalPriceLabel;
    private JButton buyButton;
    private JButton homeButton;

    public PaymentPage(double totalPrice) {
        // Set window title
        setTitle("Payment Page");
        // Set window size
        setSize(800, 500);
        // Set layout
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setResizable(false);

        // Set background color to Trendyol color
        Color trendyolColor = new Color(250, 130, 60);
        getContentPane().setBackground(trendyolColor);

        // Create JLabel for "Trendyol" text
        trendyolLabel = new JLabel("Trendyol");
        trendyolLabel.setFont(new Font("Arial", Font.BOLD, 24));
        trendyolLabel.setHorizontalAlignment(SwingConstants.CENTER);
        trendyolLabel.setForeground(Color.WHITE);
        add(trendyolLabel, BorderLayout.NORTH);

        // Create panel for "Payment" section
        JPanel paymentPanel = new JPanel(new BorderLayout());
        paymentPanel.setBorder(BorderFactory.createLineBorder(trendyolColor, 2));

        // Create JLabel for "Payment" title
        JLabel paymentLabel = new JLabel("Payment");
        paymentLabel.setFont(new Font("Arial", Font.BOLD, 20));
        paymentLabel.setHorizontalAlignment(SwingConstants.LEFT);
        paymentLabel.setForeground(trendyolColor);
        paymentPanel.add(paymentLabel, BorderLayout.NORTH);

        // Create JLabel for displaying total price
        totalPriceLabel = new JLabel("Total Price: $" + totalPrice);
        totalPriceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        totalPriceLabel.setForeground(Color.BLACK);
        paymentPanel.add(totalPriceLabel, BorderLayout.CENTER);

        // Create buttons
        buyButton = new JButton("Buy");
        homeButton = new JButton("Home");

        // Set button background color to white
        buyButton.setBackground(Color.WHITE);
        homeButton.setBackground(Color.WHITE);

        // Set button foreground color to black
        buyButton.setForeground(Color.BLACK);
        homeButton.setForeground(Color.BLACK);

        // Add action listeners to buttons
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Instantiate the CreditCardEntryPage
                CreditCardEntryPage creditCardEntryPage = new CreditCardEntryPage();
                // Make the CreditCardEntryPage visible
                creditCardEntryPage.setVisible(true);
                // Close the PaymentPage
                dispose();
            }
        });

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle navigation to Home page
                JOptionPane.showMessageDialog(null, "Navigating to Home Page");
            }
        });

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(trendyolColor);
        buttonPanel.add(homeButton);
        homeButton.setFocusable(false);  // Butona odaklanmayı devre dışı bırak

        buttonPanel.add(buyButton);
        buyButton.setFocusable(false);  // Butona odaklanmayı devre dışı bırak

        // Add payment panel and button panel to the frame
        add(paymentPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set window visibility
        setVisible(true);
        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Method to add ActionListener to Buy button for navigating to CreditCardEntryPage
    private void addCreditCardEntryListener() {
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Instantiate the CreditCardEntryPage
                CreditCardEntryPage creditCardEntryPage = new CreditCardEntryPage();
                // Make the CreditCardEntryPage visible
                creditCardEntryPage.setVisible(true);
                // Close the PaymentPage
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        // Create an instance of PaymentPage with a sample total price
        new PaymentPage(50.0);
    }
}
