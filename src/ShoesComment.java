import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShoesComment extends JFrame {
    public ShoesComment() {
        // Set window title
        setTitle("Comment Page");
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
        JLabel trendyolLabel = new JLabel("Trendyol");
        trendyolLabel.setFont(new Font("Arial", Font.BOLD, 24));
        trendyolLabel.setHorizontalAlignment(SwingConstants.CENTER);
        trendyolLabel.setForeground(Color.WHITE);
        add(trendyolLabel, BorderLayout.NORTH);

        // Create panel for Comment section
        JPanel commentPanel = new JPanel(new BorderLayout());
        commentPanel.setBorder(BorderFactory.createLineBorder(trendyolColor, 2));

        // Create JLabel for "Comments" title
        JLabel commentsLabel = new JLabel(" Comments");
        commentsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        commentsLabel.setHorizontalAlignment(SwingConstants.LEFT);
        commentsLabel.setForeground(trendyolColor);
        commentPanel.add(commentsLabel, BorderLayout.NORTH);

        // Create JTextArea for displaying user comments
        JTextArea commentTextArea = new JTextArea();
        commentTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        commentTextArea.setLineWrap(true); // Wrap text to next line if needed
        commentTextArea.setWrapStyleWord(true); // Wrap whole words
        commentTextArea.setEditable(false); // Make the text area read-only

        // Load comments from database
        loadCommentsFromDatabase(commentTextArea);

        JScrollPane scrollPane = new JScrollPane(commentTextArea);
        commentPanel.add(scrollPane, BorderLayout.CENTER);

        // Add comment panel to the frame
        add(commentPanel, BorderLayout.CENTER);

        // Set default close operation
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set window visibility
        setVisible(true);
    }

    private void loadCommentsFromDatabase(JTextArea commentTextArea) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/trendyol_db";
        String jdbcUser = "root";
        String jdbcPassword = "Eren.2011";

        try {
            // Establish connection to the database
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
            Statement statement = connection.createStatement();

            // Execute query to fetch comments
            String query = "SELECT username, comment FROM shoes_comments ORDER BY created_at DESC";
            ResultSet resultSet = statement.executeQuery(query);

            // Read comments from result set and append to the JTextArea
            StringBuilder comments = new StringBuilder();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String comment = resultSet.getString("comment");
                comments.append(username).append(": ").append(comment).append("\n\n");
            }
            commentTextArea.setText(comments.toString());

            // Close connections
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load comments from database.",
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Create an instance of ShoesComment
        new ShoesComment();
    }
}
