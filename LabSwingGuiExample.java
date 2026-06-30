import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LabSwingGuiExample implements ActionListener {
    JPanel container;
    CardLayout card;

    LabSwingGuiExample() {
        JFrame f = new JFrame("GUI");
        f.setSize(600, 600);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        card = new CardLayout();
        container = new JPanel(card);
        container.add(buildloginPanel(), "LOGINPANEL");
        container.add(buildregisterPanel(), "REGISTERPANEL");

        f.add(container);
        f.setVisible(true);
    }

    JPanel buildloginPanel() {
        JPanel loginpanel = new JPanel(new FlowLayout());
        JLabel loginTitle = new JLabel("Login Page");
        JButton loginBttn = new JButton("Login");
        JButton registerBttn = new JButton("Do not have an account??? Register");
        registerBttn.setActionCommand("GET_REGISTERPANEL");
        registerBttn.addActionListener(this);
        loginBttn.setActionCommand("DO_LOGIN");
        loginBttn.addActionListener(this);
        loginpanel.add(loginTitle);
        loginpanel.add(loginBttn);
        loginpanel.add(registerBttn);
           // registerBttn.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent e) {
        // card.show(container, "REGISTER");
        // }
        // });
        return loginpanel;
    }

    JPanel buildregisterPanel() {
        JPanel registerpanel = new JPanel(new FlowLayout());
        JLabel registerTitle = new JLabel("Register Page");
        JButton registerBttn = new JButton("Register");
        JButton loginBttn = new JButton("Already have an account??? Login");
        loginBttn.setActionCommand("GET_LOGINPANEL");
        loginBttn.addActionListener(this);
        registerBttn.setActionCommand("DO_REGISTER");
        registerBttn.addActionListener(this);
        registerpanel.add(registerTitle);
        registerpanel.add(registerBttn);
        registerpanel.add(loginBttn);
            // loginBttn.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent e) {
        // card.show(container, "LOGIN");
        // }
        // });
        return registerpanel;
    }

    public void actionPerformed(ActionEvent e) {
        String event = e.getActionCommand();
        System.out.println(event);
        switch (e.getActionCommand()) {
            case "GET_REGISTERPANEL":
                card.show(container, "REGISTERPANEL");
                break;
            case "GET_LOGINPANEL":
                card.show(container, "LOGINPANEL");
                break;
            case "DO_LOGIN":
                JOptionPane.showMessageDialog(null, "Login Successful");
                break;
            case "DO_REGISTER":
                JOptionPane.showMessageDialog(null, "Register Successful");
                break;
        }
    }

    public static void main(String[] args) {
        new LabSwingGuiExample();
    }
}
