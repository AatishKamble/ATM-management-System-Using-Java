import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;
import java.text.*;

class MiniStatement extends JFrame {

    String pin;
    JButton back;

    MiniStatement(String pin) {
        this.pin = pin;

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String data = dateFormat.format(date);
        String str_date = data.substring(0, 10);
        String str_time = data.substring(11);

        setLayout(null);

        // Bank Name Label
        JLabel bankName = new JLabel("Bank");
        bankName.setBounds(180, 20, 200, 30);
        bankName.setFont(new Font("Arial", Font.BOLD, 24));
        bankName.setForeground(new Color(0, 102, 204));
        add(bankName);

        // Date Heading
        JLabel d_date = new JLabel("DATE");
        d_date.setBounds(100, 60, 100, 25);
        d_date.setFont(new Font("Arial", Font.BOLD, 18));
        d_date.setForeground(new Color(0, 102, 204));
        add(d_date);

        // Time Heading
        JLabel d_time = new JLabel("TIME");
        d_time.setBounds(300, 60, 100, 25);
        d_time.setFont(new Font("Arial", Font.BOLD, 18));
        d_time.setForeground(new Color(0, 102, 204));
        add(d_time);

        // Date Display
        JLabel dis_date = new JLabel(" " + str_date + " ");
        dis_date.setBounds(80, 90, 200, 25);
        dis_date.setFont(new Font("Arial", Font.BOLD, 18));
        dis_date.setForeground(Color.BLACK);
        add(dis_date);

        // Time Display
        JLabel dis_time = new JLabel("" + str_time + "");
        dis_time.setBounds(280, 90, 150, 25);
        dis_time.setFont(new Font("Arial", Font.BOLD, 18));
        dis_time.setForeground(Color.BLACK);
        add(dis_time);

        // Card Number Display
        JLabel cardNumDisp = new JLabel();
        cardNumDisp.setBounds(70, 130, 400, 30);
        cardNumDisp.setFont(new Font("Arial", Font.BOLD, 18));
        cardNumDisp.setForeground(Color.BLACK);
        add(cardNumDisp);

        // Transaction Details Label
        JLabel types = new JLabel("DATE                      TYPE                    AMOUNT");
        types.setBounds(60, 220, 400, 30);
        types.setFont(new Font("Arial", Font.BOLD, 16));
        types.setForeground(new Color(0, 102, 204));
        add(types);

        // Details for Bank Transactions
        JLabel details = new JLabel();
        details.setBounds(50, 250, 400, 300);
        details.setFont(new Font("Arial", Font.PLAIN, 14));
        details.setForeground(Color.BLACK);
        details.setVerticalAlignment(SwingConstants.TOP);
        add(details);

        // Balance Amount
        JLabel amount = new JLabel();
        amount.setBounds(50, 500, 300, 25);
        amount.setFont(new Font("Arial", Font.BOLD, 20));
        amount.setForeground(new Color(0, 102, 204));
        add(amount);

        // Fetching Card Number
        try {
            mysql c = new mysql();
            ResultSet rs = c.s.executeQuery("select cardNumber from login where PinNumber = '" + pin + "' ");
            while (rs.next()) {
                cardNumDisp.setText("CARD NO.  :     " + rs.getString("cardNumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardNumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        // Fetching Last 5 Transactions
        try {
            int i = 0;
            mysql c = new mysql();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pin + "' ");
            while (i < 5) {
                if (i == 0) {
                    rs.last();
                } else if (i > 0) {
                    rs.previous();
                }
                details.setText(details.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br></br><br></br> <html>");
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        // Fetching Account Balance
        try {
            mysql c = new mysql();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pin + "' ");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            amount.setText("Balance:        Rs. " + balance + " ");
        } catch (Exception e) {
            System.out.println(e);
        }

        // Frame Settings
        setSize(500, 600);
        setLocation(300, 50);
        setResizable(false);
        setVisible(true);
        setTitle("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
    }

    public static void main(String args[]) {
        new MiniStatement("1234"); // Replace with a valid pin to test
    }
}
