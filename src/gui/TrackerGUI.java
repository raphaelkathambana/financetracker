package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TrackerGUI extends JFrame {
    private JPanel currentPanel;

    public TrackerGUI() {
        setTitle("Personal Finance Tracker");
        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        showLoginPage();
    }

    void showLoginPage() {
        getContentPane().removeAll();
        currentPanel = new LoginPanel();
        add(currentPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    void showRegistrationPage() {
        getContentPane().removeAll();
        currentPanel = new RegistrationPanel();
        add(currentPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    void showProfilePage() {
        getContentPane().removeAll();
        currentPanel = new ProfilePanel();
        add(currentPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TrackerGUI().setVisible(true));
    }
}

class LoginPanel extends JPanel {
    private static final String USERNAME = "Username:";
    private static final String FORGOT_PASSWORD = "FORGOT Password:";
    private static final String SUBMIT = "Submit";
    private static final String PASSWORD = "Password:";

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton submitButton;
    private JButton forgotPasswordButton;

    public LoginPanel() {
        setLayout(new GridLayout(4, 2));

        JLabel usernameLabel = new JLabel(USERNAME);
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel(PASSWORD);
        passwordField = new JPasswordField();
        submitButton = new JButton(SUBMIT);
        forgotPasswordButton = new JButton(FORGOT_PASSWORD);

        forgotPasswordButton.setContentAreaFilled(false);
        forgotPasswordButton.setForeground(Color.BLUE);

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel());
        add(submitButton);
        add(new JLabel());
        add(forgotPasswordButton);

        // ActionListener for the submit button
        submitButton.addActionListener(this::actionPerformed);

        // ActionListener for the forgot password button
        forgotPasswordButton.addActionListener(this::actionPerformed);
    }

    public void actionPerformed(ActionEvent e) {
        // forgotPasswordButton Clicked
        if (e.getSource() == forgotPasswordButton) {
            // Handle the forgot password functionality here
        }
        // submitButton Clicked
        if (e.getSource() == submitButton) {
            // Handle the submit functionality here
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Authenticate the user
            if (authenticateUser(username, password)) {
                // Successful authentication, perform desired action
                // For example, switch to the profile page
                var trackerGUI = new TrackerGUI();
                trackerGUI.showProfilePage();
            } else {
                // Invalid credentials, show an error message
                JOptionPane.showMessageDialog(LoginPanel.this, "Invalid username or password", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean authenticateUser(String username, String password) {
        // Implement your authentication logic here
        // This could involve querying a database or checking against stored user
        // credentials

        // For demonstration purposes, let's assume there is a predefined username and
        // password
        String validUsername = "admin";
        String validPassword = "password";

        return username.equals(validUsername) && password.equals(validPassword);
    }
}

class RegistrationPanel extends JPanel {
    private JTextField nameField;
    private JTextField emailField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JTextField genderField;
    private JButton submitButton;
    private JButton clearButton;

    private static final String USERNAME = "Username:";
    private static final String PASSWORD = "Password:";
    private static final String CONFIRM_PASSWORD = "Confirm Password:";
    private static final String NAME = "Name:";
    private static final String EMAIL = "Email:";
    private static final String SUBMIT = "Submit";
    private static final String CLEAR = "Clear";
    private static final String GENDER = "Gender: ";

    public RegistrationPanel() {
        setLayout(new GridLayout(6, 2));

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
        JLabel genderLabel = new JLabel(GENDER);
        genderField = new JTextField();
        submitButton = new JButton(SUBMIT);
        clearButton = new JButton(CLEAR);

        submitButton.addActionListener(this::actionPerformed);

        clearButton.addActionListener(this::actionPerformed);

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
        add(genderField);
        add(submitButton);
        add(clearButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(submitButton)) {
            // Handle the registration form submission here
        }
        if (e.getSource().equals(clearButton)) {
            // Clear all form fields
            clearRegistrationForm();
        }
    }

    private void clearRegistrationForm() {
        nameField.setText("");
        emailField.setText("");
        usernameField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
        genderField.setText("");
    }
}

class ProfilePanel extends JPanel {
    private JTextField nameField;
    private JTextField emailField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JTextField genderField;
    private JButton clearButton;
    private JButton submitButton;

    private static final String USERNAME = "Username:";
    private static final String PASSWORD = "Password:";
    private static final String CONFIRM_PASSWORD = "Confirm Password:";
    private static final String NAME = "Name:";
    private static final String EMAIL = "Email:";
    private static final String SUBMIT = "Submit";
    private static final String CLEAR = "Clear";
    private static final String GENDER = "Gender: ";

    public ProfilePanel() {
        setLayout(new GridLayout(7, 2));

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
        JLabel genderLabel = new JLabel(GENDER);
        genderField = new JTextField();
        clearButton = new JButton(CLEAR);
        submitButton = new JButton(SUBMIT);

        submitButton.addActionListener(this::actionPerformed);

        clearButton.addActionListener(this::actionPerformed);

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
        add(genderField);
        add(submitButton);
        add(clearButton);
    }

    private void clearProfileForm() {
        nameField.setText("");
        emailField.setText("");
        usernameField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
        genderField.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(submitButton)) {
            // Handle the profile form submission here
        }
        if (e.getSource().equals(clearButton)) {
            // Clear all form fields
            clearProfileForm();
        }
    }
}
