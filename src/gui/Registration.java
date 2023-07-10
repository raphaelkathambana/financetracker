package gui;

import javax.swing.*;

import util.User;

import java.awt.*;
import java.awt.event.ActionEvent;

public class Registration extends JFrame {
    private static final String USERNAME = "Username";
    private static final String PASSWORD = "Password";
    private static final String CONFIRM_PASSWORD = "Confirm Password";
    private static final String NAME = "Name";
    private static final String EMAIL = "Email";
    private static final String CLEAR = "Clear";
    private static final String GENDER = "Gender";
    private static final String SUBMIT = "Submit";
    private static final String REGISTRATION_PAGE = "Registration Page";

    private JPanel contentPane;
    private RegistrationPanel registrationPanel;

    public Registration() {
        setTitle("Personal Finance Tracker");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        contentPane = new JPanel(new CardLayout());

        registrationPanel = new RegistrationPanel();
        contentPane.add(registrationPanel, REGISTRATION_PAGE);

        add(contentPane);
        setVisible(true);
    }

    public void switchToPanel(JPanel panel) {
        contentPane.removeAll();
        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.revalidate();
        contentPane.repaint();
    }

    public void showRegistrationPage() {
        switchToPanel(registrationPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Registration::new);
    }

    private class RegistrationPanel extends JPanel {
        private JTextField nameField;
        private JTextField emailField;
        private JTextField usernameField;
        private JPasswordField passwordField;
        private JPasswordField confirmPasswordField;
        private JComboBox<String> genderComboBox;
        private JButton submitButton;
        private JButton clearButton;

        public RegistrationPanel() {
            setLayout(new GridLayout(7, 2));

            JLabel nameLabel = new JLabel(NAME);
            JLabel emailLabel = new JLabel(EMAIL);
            JLabel usernameLabel = new JLabel(USERNAME);
            JLabel passwordLabel = new JLabel(PASSWORD);
            JLabel confirmPasswordLabel = new JLabel(CONFIRM_PASSWORD);
            JLabel genderLabel = new JLabel(GENDER);
            nameField = new JTextField();
            emailField = new JTextField();
            usernameField = new JTextField();
            passwordField = new JPasswordField();
            confirmPasswordField = new JPasswordField();
            genderComboBox = new JComboBox<>(new String[] { "Male", "Female", "I Identify as" });
            submitButton = new JButton(SUBMIT);
            clearButton = new JButton(CLEAR);

            add(nameLabel);
            add(nameField);
            add(emailLabel);
            add(emailField);
            add(usernameLabel);
            add(usernameField);
            add(passwordLabel);
            add(passwordField);
            add(confirmPasswordLabel);
            add(confirmPasswordField);
            add(genderLabel);
            add(genderComboBox);
            add(submitButton);
            add(clearButton);

            // Action listeners
            submitButton.addActionListener(this::actionPerformed);
            clearButton.addActionListener(this::actionPerformed);
        }

        public void actionPerformed(ActionEvent e) {
            // clearButton Clicked
            if (e.getSource() == clearButton) {
                // Clear all fields
                nameField.setText("");
                emailField.setText("");
                usernameField.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
                genderComboBox.setSelectedIndex(0);
            }

            // submitButton Clicked
            if (e.getSource() == submitButton) {
                // Perform registration logic here
                // Validate the form inputs and save user data to the database
                if (validateInput()) {
                    // Save user data to the database
                    User.addNewUser(usernameField.getText(), emailField.getText(), String.valueOf(passwordField.getPassword()));
                    // If registration is successful, switch to the login panel
                    SwingUtilities.invokeLater(Login::new);
                } else {
                    // Show error message
                    JOptionPane.showMessageDialog(this, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
        public boolean validateInput() {
            var regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
            String firstName = nameField.getText();
            String email = emailField.getText();
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());
            String confirmPassword = String.valueOf(confirmPasswordField.getPassword());
            return !firstName.isEmpty() &&
                    !email.isEmpty() &&
                    User.patternMatches(email, regexPattern) &&
                    !username.isEmpty() &&
                    !password.isEmpty() &&
                    !confirmPassword.isEmpty() &&
                    password.equals(confirmPassword);
        }
    }

}
