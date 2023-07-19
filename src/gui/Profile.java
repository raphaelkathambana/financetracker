package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import util.DatabaseThread;
import util.User;

public class Profile extends JFrame {

    private static final String USERNAME = "Username";
    private static final String NAME = "Name";
    private static final String EMAIL = "Email";
    private static final String CLEAR = "Clear";
    private static final String GENDER = "Gender";
    private static final String SAVE_CHANGES = "Save Changes";
    private static final String EDIT_PROFILE = "Edit Profile";
    private static final String PROFILE_PAGE = "Profile Page";

    private JPanel contentPane;
    private ProfilePanel profilePanel;

    public Profile(DatabaseThread databaseThread) {
        setTitle("Personal Finance Tracker");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        contentPane = new JPanel(new CardLayout());
        profilePanel = new ProfilePanel(databaseThread);

        contentPane.add(profilePanel, PROFILE_PAGE);

        add(contentPane);
        setVisible(true);
    }

    public Profile() {
        setTitle("Personal Finance Tracker");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        contentPane = new JPanel(new CardLayout());
        profilePanel = new ProfilePanel();

        contentPane.add(profilePanel, PROFILE_PAGE);

        add(contentPane);
        setVisible(true);
    }

    public void switchToPanel(JPanel panel) {
        contentPane.removeAll();
        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.revalidate();
        contentPane.repaint();
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
        private transient User currentUser;
        public void setCurrentUser(User currentUser) {
            this.currentUser = currentUser;
        }

        private DatabaseThread databaseThread;

        public User getCurrentUser() {
            return currentUser;
        }

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

            // Update the fields with the user's information
            updateFields();

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

        public ProfilePanel(DatabaseThread databaseThread) {
            this.databaseThread = databaseThread;
            this.currentUser = databaseThread.getCurrentUser();
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

            // Update the fields with the user's information
            updateFields();

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
                SwingUtilities.invokeLater(() -> new Login(new DatabaseThread()));
            }
            if (e.getSource() == switchToRegistrationButton) {
                SwingUtilities.invokeLater(Registration::new);
            }
            if (e.getSource() == clearButton && (editProfileButton.getText().equals(EDIT_PROFILE))) {
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
                    saveChanges();
                }
            }
        }

        private void updateFields() {
            nameField.setText(this.getCurrentUser().getName());
            emailField.setText(this.getCurrentUser().getEmail());
            usernameField.setText(this.getCurrentUser().getUsername());
            genderField.setText(this.getCurrentUser().getGender());
        }

        private void saveChanges() {
            this.currentUser.setName(nameField.getText());
            this.currentUser.setEmail(emailField.getText());
            this.currentUser.setUsername(usernameField.getText());
            this.currentUser.setGender(genderField.getText());

            // Update the user's information in the database
            currentUser.updateUser();
            this.setCurrentUser(databaseThread.getCurrentUserInfo());
        }
    }

}
