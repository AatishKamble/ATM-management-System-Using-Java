import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

class PinChange extends JFrame implements ActionListener {

    JPasswordField newPin, rePin;
    JButton change, back;
    String pin;

    PinChange(String pin) {
        this.pin = pin;
        setLayout(null);

        // Background Image
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image i1 = img.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i1);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 800);
        add(image);

        // Heading Label
        JLabel heading = new JLabel("CHANGE PIN NUMBER");
        heading.setBounds(200, 240, 450, 50);
        heading.setFont(new Font("Arial", Font.BOLD, 28));
        heading.setForeground(new Color(255, 255, 255));  // White color for better visibility
        image.add(heading);

        // New PIN Label
        JLabel newpin = new JLabel("New PIN: ");
        newpin.setBounds(180, 300, 200, 20);
        newpin.setFont(new Font("Arial", Font.PLAIN, 18));
        newpin.setForeground(new Color(255, 255, 255)); // White color
        image.add(newpin);

        // New PIN Field
        newPin = new JPasswordField();
        newPin.setFont(new Font("Arial", Font.PLAIN, 18));
        newPin.setBounds(350, 300, 150, 30);
        newPin.setBackground(new Color(255, 255, 255, 150));  // Slight transparent background
        newPin.setBorder(BorderFactory.createLineBorder(new Color(34, 167, 240), 2));  // Blue border
        ((AbstractDocument) newPin.getDocument()).setDocumentFilter(new LengthFilter(4));  // Set max length to 4
        image.add(newPin);

        // Re-enter New PIN Label
        JLabel pinconfirm = new JLabel("Re-Enter New PIN: ");
        pinconfirm.setBounds(180, 350, 200, 20);
        pinconfirm.setFont(new Font("Arial", Font.PLAIN, 18));
        pinconfirm.setForeground(new Color(255, 255, 255));  // White color
        image.add(pinconfirm);

        // Re-enter New PIN Field
        rePin = new JPasswordField();
        rePin.setFont(new Font("Arial", Font.PLAIN, 18));
        rePin.setBounds(350, 350, 130, 30);
        rePin.setBackground(new Color(255, 255, 255, 150));  // Slight transparent background
        rePin.setBorder(BorderFactory.createLineBorder(new Color(34, 167, 240), 2));  // Blue border
        ((AbstractDocument) rePin.getDocument()).setDocumentFilter(new LengthFilter(4));  // Set max length to 4
        image.add(rePin);

        // Change Button
        change = new JButton("Change");
        change.setBounds(160, 450, 100, 40);
        change.setFont(new Font("Arial", Font.BOLD, 18));
        change.setBackground(new Color(34, 167, 240));
        change.setForeground(Color.WHITE);
        change.setFocusPainted(false);
        change.setBorder(BorderFactory.createLineBorder(new Color(34, 167, 240), 2));
        change.addActionListener(this);
        image.add(change);

        // Back Button
        back = new JButton("Back");
        back.setBounds(400, 450, 100, 40);
        back.setFont(new Font("Arial", Font.BOLD, 18));
        back.setBackground(new Color(255, 99, 71));  // Red color
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.setBorder(BorderFactory.createLineBorder(new Color(255, 99, 71), 2));
        back.addActionListener(this);
        image.add(back);

        // Set JFrame properties
        setSize(900, 800);
        setLocation(300, 50);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new transaction(pin).setVisible(true);
        } else {
            try {
                String num1 = String.valueOf(newPin.getPassword());
                String num2 = String.valueOf(rePin.getPassword());

                if (!num1.equals(num2)) {
                    JOptionPane.showMessageDialog(null, "PIN does not match");
                    newPin.setText("");
                    rePin.setText("");
                    return;
                } else if (num1.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter New PIN");
                    return;
                } else if (num2.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter New PIN");
                    return;
                } else {
                    mysql c = new mysql();
                    String query1 = "update bank set pin = '" + num1 + "' where pin = '" + pin + "' ";
                    String query2 = "update login set PinNumber =  '" + num1 + "' where PinNumber = '" + pin + "' ";
                    String query3 = "update signupthree set pin_number =  '" + num1 + "' where pin_number = '" + pin + "' ";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    c.s.executeUpdate(query3);
                    JOptionPane.showMessageDialog(null, "PIN changed successfully");
                    JOptionPane.showMessageDialog(null, "Login again with New Pin");
                    setVisible(false);
                    new LoginPage().setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String args[]) {
        new PinChange("1234"); // Replace with actual pin for testing
    }

    // DocumentFilter to limit the number of characters entered
    class LengthFilter extends DocumentFilter {
        private int maxLength;

        LengthFilter(int maxLength) {
            this.maxLength = maxLength;
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (fb.getDocument().getLength() + string.length() <= maxLength) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (fb.getDocument().getLength() + text.length() - length <= maxLength) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }
}
