package gui;

import javax.swing.*;

import util.User;

import java.awt.*;
import java.awt.event.ActionEvent;

public class TrackerGUI extends JFrame {
    // Constants
    private static final String USERNAME = "Username";
    private static final String PASSWORD = "Password";
    private static final String CONFIRM_PASSWORD = "Confirm Password";
    private static final String NAME = "Name";
    private static final String EMAIL = "Email";
    private static final String CLEAR = "Clear";
    private static final String GENDER = "Gender";
    private static final String SUBMIT = "Submit";
    private static final String SAVE_CHANGES = "Save Changes";
    private static final String EDIT_PROFILE = "Edit Profile";
    private static final String YES = "Yes";
    private static final String NO = "No";

    private JPanel contentPane;
    private LoginPanel loginPanel;
    private RegistrationPanel registrationPanel;
    private ProfilePanel profilePanel;

    public TrackerGUI() {
        setTitle("Personal Finance Tracker");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        contentPane = new JPanel(new CardLayout());

        loginPanel = new LoginPanel();
        registrationPanel = new RegistrationPanel();
        profilePanel = new ProfilePanel();

        contentPane.add(loginPanel, "login");
        contentPane.add(registrationPanel, "registration");
        contentPane.add(profilePanel, "profile");

        add(contentPane);
        setVisible(true);
    }

    public void switchToPanel(JPanel panel) {
        contentPane.removeAll();
        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.revalidate();
        contentPane.repaint();
    }

    public void showProfilePage() {
        switchToPanel(profilePanel);
    }

    public void showRegistrationPage() {
        switchToPanel(registrationPanel);
    }

    private class LoginPanel extends JPanel {
        private JTextField usernameField;
        private JPasswordField passwordField;
        private JButton loginButton;
        private JButton forgotPasswordButton;

        public LoginPanel() {
            setLayout(new GridLayout(3, 2));

            JLabel usernameLabel = new JLabel(USERNAME);
            JLabel passwordLabel = new JLabel(PASSWORD);
            usernameField = new JTextField();
            passwordField = new JPasswordField();
            loginButton = new JButton("Login");
            forgotPasswordButton = new JButton("Forgot Password");

            add(usernameLabel);
            add(usernameField);
            add(passwordLabel);
            add(passwordField);
            add(loginButton);
            add(forgotPasswordButton);

            // Action listeners
            loginButton.addActionListener(this::actionPerformed);
            forgotPasswordButton.addActionListener(this::actionPerformed);
        }

        private boolean authenticateUser(String username, String password) {
            // Authentication logic
            // ...
            return username.equals("raphael") && password.equals("12345"); // Replace with your authentication implementation
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == forgotPasswordButton) {
                // Open the forgot password panel
                // Implement the logic to reset the password and handle password recovery
                // After resetting the password, switch back to the login panel
            }
            if (e.getSource() == loginButton) {
                // Authenticate the user
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Perform authentication logic here

                if (authenticateUser(username, password)) {
                    JOptionPane.showMessageDialog(LoginPanel.this, "Welcome " + username, "Login Success",
                            JOptionPane.INFORMATION_MESSAGE);

                // If authentication is successful, switch to the profile panel
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "profile");
                } else {
                    JOptionPane.showMessageDialog(LoginPanel.this, "Invalid username or password", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
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
            //clearButton Clicked
            if (e.getSource() == clearButton) {
                // Clear all fields
                nameField.setText("");
                emailField.setText("");
                usernameField.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
                genderComboBox.setSelectedIndex(0);
            }

            //submitButton Clicked
            if (e.getSource() == submitButton) {
                // Perform registration logic here
                // Validate the form inputs and save user data to the database

                // If registration is successful, switch to the login panel
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.show(contentPane, "login");
            }
        }
    }
    private class ProfilePanel extends JPanel {
        private JTextField nameField;
        private JTextField emailField;
        private JTextField usernameField;
        private JTextField genderField;
        private JButton editProfileButton;
        private JButton switchToLoginButton;
        private JButton switchToRegistrationButton;
        private JButton clearButton;
        private User currentUser;

        public ProfilePanel() {
            setLayout(new GridLayout(6, 2));

            JLabel nameLabel = new JLabel(NAME);
            JLabel emailLabel = new JLabel(EMAIL);
            JLabel usernameLabel = new JLabel(USERNAME);
            JLabel genderLabel = new JLabel(GENDER);
            nameField = new JTextField();
            emailField = new JTextField();
            usernameField = new JTextField();
            genderField = new JTextField();
            editProfileButton = new JButton(EDIT_PROFILE);
            clearButton = new JButton(CLEAR);
            switchToLoginButton = new JButton("Switch to Login");
            switchToRegistrationButton = new JButton("Switch to Registration");

            // Make fields non-editable by default
            nameField.setEditable(false);
            emailField.setEditable(false);
            usernameField.setEditable(false);
            genderField.setEditable(false);

            add(nameLabel);
            add(nameField);
            add(emailLabel);
            add(emailField);
            add(usernameLabel);
            add(usernameField);
            add(genderLabel);
            add(genderField);
            add(editProfileButton);
            add(clearButton);
            add(switchToLoginButton);
            add(switchToRegistrationButton);

            // Action listeners
            editProfileButton.addActionListener(this::actionPerformed);
            switchToLoginButton.addActionListener(this::actionPerformed);
            switchToRegistrationButton.addActionListener(this::actionPerformed);
            clearButton.addActionListener(this::actionPerformed);
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == switchToLoginButton) {
                switchToPanel(loginPanel);
            }
            if (e.getSource() == switchToRegistrationButton) {
                switchToPanel(registrationPanel);
            }
            if (e.getSource() == clearButton) {
                nameField.setText("");
                emailField.setText("");
                usernameField.setText("");
                genderField.setText("");
            }
            if (e.getSource() == editProfileButton) {
                if (editProfileButton.getText().equals(EDIT_PROFILE)) {
                    // Switch to editable mode
                    nameField.setEditable(true);
                    emailField.setEditable(true);
                    usernameField.setEditable(true);
                    genderField.setEditable(true);
                    editProfileButton.setText(SAVE_CHANGES);
                } else if (editProfileButton.getText().equals(SAVE_CHANGES)) {
                    // Save changes to the database
                    // Implement the logic to update the user's profile

                    // Switch back to non-editable mode
                    nameField.setEditable(false);
                    emailField.setEditable(false);
                    usernameField.setEditable(false);
                    genderField.setEditable(false);
                    editProfileButton.setText(EDIT_PROFILE);
                }
            }

        }

        public void setUser(User user) {
            this.currentUser = user;
            updateFields();
        }

        private void updateFields() {
            nameField.setText(currentUser.getName());
            emailField.setText(currentUser.getEmail());
            usernameField.setText(currentUser.getUsername());
            genderField.setText(currentUser.getGender());
        }

        private void saveChanges() {
            String newName = nameField.getText();
            String newEmail = emailField.getText();
            String newUsername = usernameField.getText();
            String newGender = genderField.getText();

            // Update the user's information in the database
            // ...
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TrackerGUI::new);
    }
}
