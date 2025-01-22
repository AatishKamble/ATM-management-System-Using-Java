import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class LoginPage extends JFrame implements ActionListener {

    JButton signin, signup, clear;
    JTextField cardfield;
    JPasswordField pinfield;

    LoginPage() {
        // Set layout for the JFrame
        setLayout(null);

        // Set the background gradient for the JFrame using JPanel
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, new Color(26, 188, 156), 0, getHeight(), new Color(22, 160, 133));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(null);
        setContentPane(panel);  // Set this panel as the content pane

        // Bank icon (replacing with a better-sized one)
        try {
            ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("images/bank1.jpg"));
            Image i2 = img.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);  // resizing for balance
            ImageIcon i3 = new ImageIcon(i2);
            JLabel label = new JLabel(i3);
            label.setBounds(50, 40, 100, 100);
            panel.add(label);
        } catch (Exception e) {
            System.out.println("Image not found!");
        }

        // Title text
        JLabel text = new JLabel("Welcome to ATM");
        text.setBounds(200, 60, 500, 60);
        text.setFont(new Font("Arial", Font.BOLD, 36));
        text.setForeground(Color.WHITE);  // White text for contrast
        panel.add(text);

        // Card number label
        JLabel card = new JLabel("Card Number:");
        card.setBounds(170, 200, 400, 30);
        card.setFont(new Font("Arial", Font.BOLD, 22));
        card.setForeground(Color.WHITE);
        panel.add(card);

        // Card number text field
        cardfield = new JTextField();
        cardfield.setBounds(400, 200, 200, 30);
        cardfield.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(cardfield);

        // Pin number label
        JLabel pin = new JLabel("Pin:");
        pin.setBounds(170, 250, 400, 30);
        pin.setFont(new Font("Arial", Font.BOLD, 22));
        pin.setForeground(Color.WHITE);
        panel.add(pin);

        // Pin number text field
        pinfield = new JPasswordField();
        pinfield.setBounds(400, 250, 200, 30);
        pinfield.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(pinfield);

        // Buttons (Sign In, Clear, Sign Up)
        signin = new JButton("SIGN IN");
        signin.setBounds(300, 350, 100, 40);
        signin.setBackground(new Color(34, 167, 240));
        signin.setForeground(Color.WHITE);
        signin.setFont(new Font("Arial", Font.BOLD, 18));
        signin.setFocusPainted(false);
        signin.addActionListener(this);
        panel.add(signin);

        clear = new JButton("CLEAR");
        clear.setBounds(420, 350, 100, 40);
        clear.setBackground(new Color(241, 196, 15));  // Yellow color
        clear.setForeground(Color.BLACK);
        clear.setFont(new Font("Arial", Font.BOLD, 18));
        clear.setFocusPainted(false);
        clear.addActionListener(this);
        panel.add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 420, 220, 40);
        signup.setBackground(new Color(46, 204, 113));  // Green color
        signup.setForeground(Color.WHITE);
        signup.setFont(new Font("Arial", Font.BOLD, 18));
        signup.setFocusPainted(false);
        signup.addActionListener(this);
        panel.add(signup);

        // Set JFrame properties
        setSize(800, 600);
        setLocation(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("ATM Management System");
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == signin) {
            mysql c = new mysql();
            String cardnumber = cardfield.getText();
            String pinnumber = String.valueOf(pinfield.getPassword());
            String query = "select * from login where cardNumber = '" + cardnumber + "' and PinNumber = '" + pinnumber + "'";
            try {
                ResultSet res = c.s.executeQuery(query);
                if (res.next()) {
                    setVisible(false);
                    new transaction(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Cardnumber or Pin");
                    cardfield.setText("");
                    pinfield.setText("");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == clear) {
            cardfield.setText("");
            pinfield.setText("");
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignUp1().setVisible(true);
        }
    }

    public static void main(String args[]) {
        new LoginPage();
    }
}
