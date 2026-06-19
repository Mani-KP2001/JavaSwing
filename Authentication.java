import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Authentication implements ActionListener {
    JPanel container = new JPanel();
    CardLayout card = new CardLayout();

    Authentication() {
        JFrame f = new JFrame("Authentication");
        f.setSize(600, 600);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.setLayout(card);
        f.add(container);
        container.add(buildLoginPanel(), "LOGIN");
        container.add(buildRegisterPanel(), "REGISTER");
        f.setVisible(true);
    }

    JPanel buildLoginPanel() {
        JPanel panelLogin = new JPanel(new FlowLayout());
        JLabel title = new JLabel("Login Page");
        JButton loginBttn = new JButton("Login");
        JButton registerBttn = new JButton("Do not have an account? Register");
        registerBttn.setActionCommand("GET_REGISTER_PANEL");
        registerBttn.addActionListener(this);
        loginBttn.setActionCommand("DO_LOGIN");
        loginBttn.addActionListener(this);
        panelLogin.add(title);
        panelLogin.add(loginBttn);
        panelLogin.add(registerBttn);
        return panelLogin;
    }

    JPanel buildRegisterPanel() {
        JPanel panelRegister = new JPanel();
        JLabel title = new JLabel("Register Page");
        JButton registerBttn = new JButton("Register");
        JButton loginBttn = new JButton("Already have an account? Login");
        loginBttn.setActionCommand("GET_LOGIN_PANEL");
        loginBttn.addActionListener(this);
        registerBttn.setActionCommand("DO_REGISTER");
        registerBttn.addActionListener(this);
        panelRegister.add(title);
        panelRegister.add(registerBttn);
        panelRegister.add(loginBttn);
        return panelRegister;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "GET_REGISTER_PANEL":
                card.show(container, "REGISTER");
                break;
            case "GET_LOGIN_PANEL":
                card.show(container, "LOGIN");
                break;
            case "DO_LOGIN":
                JOptionPane.showMessageDialog(null, "Login Successful");
                break;
            case "DO_REGISTER":
                JOptionPane.showMessageDialog(null, "Register Successful");
                card.show(container, "LOGIN");
                break;
        }
    }

    public static void main(String[] args) {
        new Authentication();
    }
}