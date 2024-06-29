import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginSignup extends JFrame implements ActionListener {
    private JTextField emailTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signupButton;
    private JButton vendorButton;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Eren.2011";

    public LoginSignup() {
        setTitle("Login Page");
        setSize(800, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(250, 150, 60));

        JLabel titleLabel = new JLabel("Trendyol   ");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 54));
        titleLabel.setForeground(Color.WHITE);
        
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(new Color(250, 150, 70));
        titlePanel.add(titleLabel);

        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(250, 130, 60));

        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        emailPanel.setBackground(new Color(250, 130, 60));
        JLabel emailLabel = new JLabel("E-Mail:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 18));
        emailPanel.add(emailLabel);
        emailTextField = new JTextField(20);
        emailTextField.setPreferredSize(new Dimension(200, 30));
        emailTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        emailPanel.add(emailTextField);

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        passwordPanel.setBackground(new Color(250, 130, 60));
        JLabel passwordLabel = new JLabel("Şifre:  ");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        passwordPanel.add(passwordLabel);
        passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(new Dimension(200, 30));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordPanel.add(passwordField);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        buttonPanel.setBackground(new Color(250, 130, 60));

        Font buttonFont = new Font("Arial", Font.BOLD, 18);

        // Butonlar için panel
        loginButton = new JButton("Login");
        loginButton.setFont(buttonFont);
        loginButton.setPreferredSize(new Dimension(120, 30));
        loginButton.addActionListener(this);
        loginButton.setBackground(Color.WHITE);
        loginButton.setForeground(Color.BLACK);
        loginButton.setFocusable(false);

        signupButton = new JButton("Signup");
        signupButton.setFont(buttonFont);
        signupButton.setPreferredSize(new Dimension(120, 30));
        signupButton.addActionListener(this);
        signupButton.setBackground(Color.WHITE);
        signupButton.setForeground(Color.BLACK);
        signupButton.setFocusable(false);

        vendorButton = new JButton("Vendor");
        vendorButton.setFont(buttonFont);
        vendorButton.setPreferredSize(new Dimension(120, 30));
        vendorButton.addActionListener(this);
        vendorButton.setBackground(Color.WHITE);
        vendorButton.setForeground(Color.BLACK);
        vendorButton.setFocusable(false);

        buttonPanel.add(loginButton);
        buttonPanel.add(signupButton);
        buttonPanel.add(vendorButton);
       
        mainPanel.add(Box.createVerticalStrut(100)); 
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(50));
        mainPanel.add(emailPanel);
        mainPanel.add(passwordPanel);
        mainPanel.add(Box.createVerticalStrut(10)); 
        mainPanel.add(buttonPanel);

        add(mainPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton || e.getSource() == vendorButton) {
            String inputEmail = emailTextField.getText().trim();
            String inputPassword = new String(passwordField.getPassword());

    
            if (!inputEmail.isEmpty() && inputPassword.length() > 0 && isValidEmail(inputEmail)) {
                if (authenticateUser(inputEmail, inputPassword)) {
                    dispose(); 
                    if (e.getSource() == loginButton) {
                        new HomePage();
                    } else if (e.getSource() == vendorButton) {
                        new VendorPage(); 
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid email or password!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please enter valid email and password!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == signupButton) {
            dispose(); 
            new Signup(); 
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    private boolean authenticateUser(String email, String password) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        new LoginSignup();
    }
}
