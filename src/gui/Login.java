package gui;

import javax.swing.*;

import util.DatabaseThread;
import util.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;

public class Login extends JFrame {
    private static final String USERNAME = "Username:";
    private static final String PASSWORD = "Password:";
    private static final String LOGIN_TEXT = "Login";
    private static final String FORGOT_PASSWORD = "Forgot Password?";
    private static final String SHOW_PASSWORD = "Show Password";
    private static final String LOGIN_PAGE = "Login Page";
    private JPanel contentPane;
    private LoginPanel loginPanel;

    public Login() {
        setTitle(LOGIN_TEXT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        contentPane = new JPanel(new CardLayout());
        loginPanel = new LoginPanel();

        contentPane.add(loginPanel, LOGIN_PAGE);

        add(contentPane);
        setVisible(true);
    }
    public Login(DatabaseThread databaseThread) {
        setTitle(LOGIN_TEXT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);

        contentPane = new JPanel(new CardLayout());
        loginPanel = new LoginPanel(databaseThread);

        contentPane.add(loginPanel, LOGIN_PAGE);

        add(contentPane);
        setVisible(true);
    }

    private class LoginPanel extends JPanel implements FocusListener {
        private JTextField usernameField;
        private JPasswordField passwordField;
        private JButton loginButton;
        private JButton forgotPasswordButton;
        private JCheckBox showPassword;
        private JButton btnRegister;
        private transient User currentUser = null;
        private DatabaseThread databaseThread;

        public void setCurrentUser(User currentUser) {
            this.currentUser = currentUser;
        }

        public LoginPanel() {
            // initialize container properties
            setLayout(null);

            var lbTitle = new JLabel(LOGIN_PAGE);
            lbTitle.setFont(new Font("Serif", Font.BOLD, 20));

            JLabel usernameLabel = new JLabel(USERNAME);
            usernameField = new JTextField(USERNAME);
            usernameField.setForeground(Color.LIGHT_GRAY);
            JLabel passwordLabel = new JLabel(PASSWORD);
            passwordField = new JPasswordField();
            showPassword = new javax.swing.JCheckBox(SHOW_PASSWORD);

            btnRegister = new JButton("Register");
            loginButton = new JButton(LOGIN_TEXT);
            forgotPasswordButton = new JButton(FORGOT_PASSWORD);

            // deciding location for the components since we have no layout
            lbTitle.setBounds(300, 110, 400, 30);
            usernameLabel.setBounds(130, 160, 200, 30);
            passwordLabel.setBounds(130, 210, 200, 30);
            usernameField.setBounds(260, 160, 200, 30);
            passwordField.setBounds(260, 210, 200, 30);
            showPassword.setBounds(260, 250, 150, 15);
            loginButton.setBounds(250, 275, 100, 30);
            btnRegister.setBounds(370, 275, 100, 30);

            // add to container
            add(lbTitle);
            add(usernameLabel);
            add(usernameField);
            add(passwordLabel);
            add(passwordField);
            add(showPassword);
            add(loginButton);
            add(btnRegister);
            add(forgotPasswordButton);

            // Action listeners
            loginButton.addActionListener(this::actionPerformed);
            forgotPasswordButton.addActionListener(this::actionPerformed);
            btnRegister.addActionListener(this::actionPerformed);
            showPassword.addActionListener(this::showPasswordActionPerformed);
            usernameField.addFocusListener(this);
            passwordField.addFocusListener(this);
            addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowOpened(java.awt.event.WindowEvent evt) {
                    usernameField.requestFocus();
                }
            });
            passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    pfPasswordPressed(evt);
                }
            });
        }

        public LoginPanel(DatabaseThread databaseThread) {
            // initialize container properties
            setLayout(null);

            var lbTitle = new JLabel(LOGIN_PAGE);
            lbTitle.setFont(new Font("Serif", Font.BOLD, 20));

            JLabel usernameLabel = new JLabel(USERNAME);
            usernameField = new JTextField(USERNAME);
            usernameField.setForeground(Color.LIGHT_GRAY);
            JLabel passwordLabel = new JLabel(PASSWORD);
            passwordField = new JPasswordField();
            showPassword = new javax.swing.JCheckBox(SHOW_PASSWORD);

            btnRegister = new JButton("Register");
            loginButton = new JButton(LOGIN_TEXT);
            forgotPasswordButton = new JButton(FORGOT_PASSWORD);

            // deciding location for the components since we have no layout
            lbTitle.setBounds(300, 110, 400, 30);
            usernameLabel.setBounds(130, 160, 200, 30);
            passwordLabel.setBounds(130, 210, 200, 30);
            usernameField.setBounds(260, 160, 200, 30);
            passwordField.setBounds(260, 210, 200, 30);
            showPassword.setBounds(260, 250, 150, 15);
            loginButton.setBounds(250, 275, 100, 30);
            btnRegister.setBounds(370, 275, 100, 30);

            // add to container
            add(lbTitle);
            add(usernameLabel);
            add(usernameField);
            add(passwordLabel);
            add(passwordField);
            add(showPassword);
            add(loginButton);
            add(btnRegister);
            add(forgotPasswordButton);

            // Action listeners
            loginButton.addActionListener(this::actionPerformed);
            forgotPasswordButton.addActionListener(this::actionPerformed);
            btnRegister.addActionListener(this::actionPerformed);
            showPassword.addActionListener(this::showPasswordActionPerformed);
            usernameField.addFocusListener(this);
            passwordField.addFocusListener(this);
            addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowOpened(java.awt.event.WindowEvent evt) {
                    usernameField.requestFocus();
                }
            });
            passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    pfPasswordPressed(evt);
                }
            });

            this.databaseThread = databaseThread;
        }

        private boolean authenticateUser(String username, String password) {
            // Authentication logic
            // return true if the user is authenticated, false otherwise

            this.setCurrentUser(User.authenticateUser(username, password));
            return currentUser != null;
        }

        protected void showPasswordActionPerformed(ActionEvent evt) {
            if (showPassword.isSelected()) {
                Logger.getLogger(Login.class.getName()).info("Show Password CheckBox is selected");
                passwordField.setEchoChar((char) 0);
                passwordField.setFocusable(false);
            } else {
                Logger.getLogger(Login.class.getName()).info("Show Password CheckBox is Unselected");
                passwordField.setEchoChar('*');
                passwordField.setFocusable(true);
                passwordField.requestFocus();
            }
        }

        private void pfPasswordPressed(java.awt.event.KeyEvent evt) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                Logger.getLogger(Login.class.getName()).info("Login Button Clicked");
                loginButtonClicked();
            }
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == forgotPasswordButton) {
                // Open the forgot password panel
                // Implement the logic to reset the password and handle password recovery
                // After resetting the password, switch back to the login panel
            }
            if (e.getSource() == loginButton) {
                loginButtonClicked();
            }

            if (e.getSource() == btnRegister) {
                registerButtonCLicked();
            }
        }

        private void registerButtonCLicked() {
            SwingUtilities.invokeLater(Registration::new);
        }

        public void loginButtonClicked() {
            // Authenticate the user
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Perform authentication logic here
            if (authenticateUser(username, password)) {
                JOptionPane.showMessageDialog(LoginPanel.this, "Welcome " + username, "Login Success",
                JOptionPane.INFORMATION_MESSAGE);
                // Start the DatabaseThread
                this.databaseThread.setLoggedIn(true);
                this.databaseThread.setCurrentUser(currentUser);
                this.databaseThread.start();

                // If authentication is successful, switch to the profile panel
                SwingUtilities.invokeLater(() -> new HomeScreen(this.databaseThread));
                SwingUtilities.getWindowAncestor(contentPane).dispose();
            } else {
                JOptionPane.showMessageDialog(LoginPanel.this, "Invalid username or password", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (e.getSource() == passwordField) {
                Logger.getLogger(Login.class.getName()).info("Focus Gained on Password");
                passwordField.setEchoChar('*');
                String word = String.valueOf(passwordField.getPassword());
                if (word.equals(PASSWORD)) {
                    passwordField.setForeground(Color.BLACK);
                    passwordField.setText("");
                }
                if (word.length() <= 0 && word.equals(PASSWORD)) {
                    passwordField.setText("");
                }
            }
            if (e.getSource() == usernameField) {
                Logger.getLogger(Login.class.getName()).info("Focus Gained on username");
                String word = usernameField.getText();
                if (word.equals(USERNAME)) {
                    usernameField.setForeground(Color.BLACK);
                    usernameField.setText("");
                }
                if (word.length() <= 0 && word.equals(USERNAME)) {
                    usernameField.setText("");
                }
                String word2 = String.valueOf(passwordField.getPassword());
                if (word2.length() <= 0) {
                    passwordField.setForeground(Color.LIGHT_GRAY);
                    passwordField.setText(PASSWORD);
                    passwordField.setEchoChar((char) 0);
                }
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (e.getSource() == passwordField) {
                Logger.getLogger(Login.class.getName()).info("Focus Lost On Password");
                String word = String.valueOf(passwordField.getPassword());
                if (word.length() <= 0) {
                    passwordField.setForeground(Color.LIGHT_GRAY);
                    passwordField.setText(PASSWORD);
                    passwordField.setEchoChar((char) 0);
                }
            }
            if (e.getSource() == usernameField) {
                Logger.getLogger(Login.class.getName()).info("Focus Lost On Name");
                if (usernameField.getText().length() <= 0) {
                    usernameField.setForeground(Color.LIGHT_GRAY);
                    usernameField.setText(USERNAME);
                }
            }
        }
    }
}
