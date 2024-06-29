import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CreditCardEntryPage extends JFrame {
    private JTextField cardNumberField;
    private JTextField cardOwnerField;
    private JTextField expirationDateField;
    private JTextField securityNumberField;
    private JTextField addressField;
    private JCheckBox agreeCheckBox;
    private JButton confirmButton;

    public CreditCardEntryPage() {
        // Set window title
        setTitle("Credit Card Entry Page");
        // Set window size
        setSize(800, 500);
        // Set layout
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setResizable(false);

        // Set background color to Trendyol color
        Color trendyolColor = new Color(250, 130, 60); // RGB values for Trendyol color
        getContentPane().setBackground(trendyolColor);

        // Create Trendyol label
        JLabel trendyolLabel = new JLabel("Trendyol");
        trendyolLabel.setFont(new Font("Arial", Font.BOLD, 24));
        trendyolLabel.setForeground(Color.WHITE);
        trendyolLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(trendyolLabel, BorderLayout.NORTH);

        // Create panel for credit card entry fields
        JPanel entryPanel = new JPanel();
        entryPanel.setLayout(new GridLayout(8, 2, 5, 5)); // Added horizontal and vertical gaps
        entryPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        entryPanel.setBackground(trendyolColor);

        // Create text fields for credit card information
        cardNumberField = new JTextField();
        cardOwnerField = new JTextField();
        expirationDateField = new JTextField();
        securityNumberField = new JTextField();
        addressField = new JTextField();
        agreeCheckBox = new JCheckBox("I agree to the terms and conditions");

        // Add labels and text fields to the entry panel
        entryPanel.add(new JLabel("Card Number:"));
        entryPanel.add(cardNumberField);
        entryPanel.add(new JLabel("Card Owner:"));
        entryPanel.add(cardOwnerField);
        entryPanel.add(new JLabel("Expiration Date:"));
        entryPanel.add(expirationDateField);
        entryPanel.add(new JLabel("Security Number:"));
        entryPanel.add(securityNumberField);
        entryPanel.add(new JLabel("Address:"));
        entryPanel.add(addressField);
        entryPanel.add(new JLabel()); // Empty label for checkbox alignment
        entryPanel.add(agreeCheckBox);

        // Create confirm button
        confirmButton = new JButton("Confirm");
        confirmButton.setBackground(Color.WHITE); // Set button background color to white
        confirmButton.setForeground(Color.BLACK); // Set button text color to black

        // Add action listener to confirm button
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if all fields are filled and the checkbox is selected
                if (isFormValid()) {
                    // Retrieve credit card information from text fields
                    String cardNumber = cardNumberField.getText();
                    String cardOwner = cardOwnerField.getText();
                    String expirationDate = expirationDateField.getText();
                    String securityNumber = securityNumberField.getText();
                    String address = addressField.getText();

                    // Generate a random order number
                    int orderNumber = generateOrderNumber();

                    // Display confirmation message
                    String message = "Your order has been received.\nOrder Number: " + orderNumber;
                    JOptionPane.showMessageDialog(null, message, "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill all fields and agree to the terms and conditions.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add entry panel and confirm button to the frame
        add(entryPanel, BorderLayout.CENTER);
        add(confirmButton, BorderLayout.SOUTH);

        // Set window visibility
        setVisible(true);
        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add key listeners to text fields
        addKeyListenerToTextFields();
    }

    // Method to check if all form fields are filled and the checkbox is selected
    private boolean isFormValid() {
        return !cardNumberField.getText().isEmpty() &&
                !cardOwnerField.getText().isEmpty() &&
                !expirationDateField.getText().isEmpty() &&
                !securityNumberField.getText().isEmpty() &&
                !addressField.getText().isEmpty() &&
                agreeCheckBox.isSelected();
    }

    // Method to generate a random order number
    private int generateOrderNumber() {
        return (int) (Math.random() * 1000000);
    }

    // Method to add key listeners to text fields
    private void addKeyListenerToTextFields() {
        cardNumberField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Limit card number field to 16 characters
                if (cardNumberField.getText().length() >= 16) {
                    e.consume();
                }
            }
        });

        securityNumberField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Limit security number field to 3 characters
                if (securityNumberField.getText().length() >= 3) {
                    e.consume();
                }
            }
        });
    }

    public static void main(String[] args) {
        // Create an instance of CreditCardEntryPage
        new CreditCardEntryPage();
    }
}
