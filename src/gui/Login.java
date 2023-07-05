package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField genderField;

    private static final String USERNAME = "Username:";
    private static final String PASSWORD = "Password:";
    private static final String CONFIRM_PASSWORD = "Confirm Password:";
    private static final String NAME = "Name:";
    private static final String EMAIL = "Email:";    

    public Login() {
        // Set up the main JFrame
        setTitle("Personal Finance Tracker");
        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create panels for login, registration, and profile
        JPanel loginPanel = createLoginPanel();
        JPanel registrationPanel = createRegistrationPanel();
        JPanel profilePanel = createProfilePanel();

        // Add panels to the main JFrame
        add(loginPanel, BorderLayout.CENTER);
        add(registrationPanel, BorderLayout.CENTER);
        add(profilePanel, BorderLayout.CENTER);

        // Show the login panel by default
        showLoginPanel();
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel(USERNAME);
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel(PASSWORD);
        passwordField = new JPasswordField();
        JButton forgotPasswordButton = new JButton("Forgot Password");

        // Configure the forgot password button
        forgotPasswordButton.setContentAreaFilled(false);
        forgotPasswordButton.setForeground(Color.BLUE);

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(forgotPasswordButton);

        return panel;
    }

    private JPanel createRegistrationPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 2));

        JLabel nameLabel = new JLabel(NAME);
        nameField = new JTextField();
        JLabel emailLabel = new JLabel(EMAIL);
        emailField = new JTextField();
        JLabel usernameLabel = new JLabel(USERNAME);
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel(PASSWORD);
        passwordField = new JPasswordField();
        JLabel confirmPasswordLabel = new JLabel(CONFIRM_PASSWORD);
        confirmPasswordField = new JPasswordField();
        JLabel genderLabel = new JLabel("Gender:");
        genderField = new JTextField();
        JButton submitButton = new JButton("Submit");
        JButton clearButton = new JButton("Clear");

        // Configure the submit button
        submitButton.addActionListener(this::submitRegistrationForm);

        // Configure the clear button
        clearButton.addActionListener(this::clearForm);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(confirmPasswordLabel);
        panel.add(confirmPasswordField);
        panel.add(genderLabel);
        panel.add(genderField);
        panel.add(submitButton);
        panel.add(clearButton);

        return panel;
    }

    private JPanel createProfilePanel() {
        JPanel panel = new JPanel(new GridLayout(6, 2));

        JLabel nameLabel = new JLabel(NAME);
        nameField = new JTextField();
        JLabel emailLabel = new JLabel(EMAIL);
        emailField = new JTextField();
        JLabel usernameLabel = new JLabel(USERNAME);
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel(PASSWORD);
        passwordField = new JPasswordField();
        JLabel confirmPasswordLabel = new JLabel(CONFIRM_PASSWORD);
        confirmPasswordField = new JPasswordField();
        JLabel genderLabel = new JLabel("Gender:");
        genderField = new JTextField();
        JButton submitButton = new JButton("Submit");
        JButton clearButton = new JButton("Clear");

        // Configure the submit button
        submitButton.addActionListener(this::submitProfileForm);

        // Configure the clear button
        clearButton.addActionListener(this::clearForm);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(confirmPasswordLabel);
        panel.add(confirmPasswordField);
        panel.add(genderLabel);
        panel.add(genderField);
        panel.add(submitButton);
        panel.add(clearButton);

        return panel;
    }

    private void showLoginPanel() {
        getContentPane().removeAll();
        getContentPane().add(createLoginPanel(), BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void submitRegistrationForm(ActionEvent e) {
        // Perform registration form submission logic here
    }

    private void submitProfileForm(ActionEvent e) {
        // Perform profile form submission logic here
    }

    private void clearForm(ActionEvent e) {
        nameField.setText("");
        emailField.setText("");
        usernameField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
        genderField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login().setVisible(true));
    }
}
