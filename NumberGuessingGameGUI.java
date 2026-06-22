import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class NumberGuessingGameGUI extends JFrame {

    private final int targetNumber;
    private int totalAttempts = 0;

    private JTextField guessField;
    private JLabel messageLabel;
    private JLabel attemptsLabel;

    public NumberGuessingGameGUI() {

        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;

        targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;

        // Window Settings
        setTitle("✨ Number Guessing Game ✨");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Main Panel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 240, 245)); // Pastel Pink
        panel.setLayout(null);

        // Title
        JLabel titleLabel = new JLabel("Number Guessing Game");
        titleLabel.setBounds(100, 30, 400, 40);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(new Color(138, 43, 226));

        // Subtitle
        JLabel subtitleLabel = new JLabel("Guess a number between 1 and 100");
        subtitleLabel.setBounds(120, 80, 350, 25);
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        subtitleLabel.setForeground(new Color(75, 0, 130));

        // Input Field
        guessField = new JTextField();
        guessField.setBounds(175, 140, 250, 45);
        guessField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        guessField.setBackground(new Color(230, 230, 250)); // Lavender

        // Guess Button
        JButton guessButton = new JButton("Guess Number");
        guessButton.setBounds(200, 210, 200, 50);
        guessButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        guessButton.setBackground(new Color(173, 216, 230)); // Pastel Blue
        guessButton.setFocusPainted(false);

        // Message Label
        messageLabel = new JLabel("Enter your guess and click the button!");
        messageLabel.setBounds(50, 290, 500, 30);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        messageLabel.setForeground(new Color(199, 21, 133));

        // Attempts Label
        attemptsLabel = new JLabel("Attempts: 0");
        attemptsLabel.setBounds(200, 330, 200, 30);
        attemptsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        attemptsLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        attemptsLabel.setForeground(new Color(75, 0, 130));

        // Button Action
        guessButton.addActionListener(e -> checkGuess());

        // Add Components
        panel.add(titleLabel);
        panel.add(subtitleLabel);
        panel.add(guessField);
        panel.add(guessButton);
        panel.add(messageLabel);
        panel.add(attemptsLabel);

        add(panel);
        setVisible(true);
    }

    private void checkGuess() {
        try {
            int userGuess = Integer.parseInt(guessField.getText());

            totalAttempts++;
            attemptsLabel.setText("Attempts: " + totalAttempts);

            if (userGuess < targetNumber) {
                messageLabel.setText("Too low! Try a higher number.");
            } else if (userGuess > targetNumber) {
                messageLabel.setText("Too high! Try a lower number.");
            } else {
                messageLabel.setText("Congratulations! Correct Number!");

                JOptionPane.showMessageDialog(
                        this,
                        "Congratulations!!!\n\nYou found the correct number!\n\nAttempts: "
                                + totalAttempts,
                        "Winner!!",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

            guessField.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid whole number!",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NumberGuessingGameGUI::new);
    }
}