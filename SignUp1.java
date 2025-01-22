import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

class SignUp1 extends JFrame implements ActionListener {

    JTextField namefield, fnamefield, emailfield, addressfield, cityfield, statefield, pincodefield;
    JButton next;
    JRadioButton malebtn, femalebtn, othersbtn, married, notMarried, otherMarried;
    JDateChooser dobfield;
    String formNo = "2912"; // A fixed number, you can take a random number also

    SignUp1() {
        setLayout(null);

        // Add heading
        JLabel heading = new JLabel("Application Form No. 2912");
        heading.setBounds(120, 20, 500, 40);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 28));
        heading.setForeground(new Color(0, 102, 204));
        add(heading);

        JLabel pageno = new JLabel("Page 1: Personal Details");
        pageno.setBounds(180, 60, 300, 30);
        pageno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        pageno.setForeground(new Color(102, 102, 102));
        add(pageno);

        // Styling for labels
        Font labelFont = new Font("Calibri", Font.PLAIN, 18);
        Color labelColor = new Color(51, 51, 51);

        // Name and text field
        JLabel name = new JLabel("Name:");
        name.setBounds(60, 110, 200, 30);
        name.setFont(labelFont);
        name.setForeground(labelColor);
        add(name);

        namefield = new JTextField();
        namefield.setBounds(200, 110, 300, 30);
        namefield.setFont(new Font("Calibri", Font.PLAIN, 16));
        add(namefield);

        // Father's name and field
        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(60, 160, 200, 30);
        fname.setFont(labelFont);
        fname.setForeground(labelColor);
        add(fname);

        fnamefield = new JTextField();
        fnamefield.setBounds(200, 160, 300, 30);
        fnamefield.setFont(new Font("Calibri", Font.PLAIN, 16));
        add(fnamefield);

        // Date of birth and calendar
        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(60, 210, 200, 30);
        dob.setFont(labelFont);
        dob.setForeground(labelColor);
        add(dob);

        dobfield = new JDateChooser();
        dobfield.setBounds(200, 210, 300, 30);
        dobfield.setForeground(Color.black);
        dobfield.setFont(new Font("Calibri", Font.PLAIN, 16));
        add(dobfield);

        // Gender and radio buttons
        JLabel gender = new JLabel("Gender:");
        gender.setBounds(60, 260, 200, 30);
        gender.setFont(labelFont);
        gender.setForeground(labelColor);
        add(gender);

        malebtn = new JRadioButton("Male");
        malebtn.setBounds(200, 260, 100, 30);
        malebtn.setFont(labelFont);
        malebtn.setBackground(Color.white);

        femalebtn = new JRadioButton("Female");
        femalebtn.setBounds(300, 260, 100, 30);
        femalebtn.setFont(labelFont);
        femalebtn.setBackground(Color.white);

        othersbtn = new JRadioButton("Others");
        othersbtn.setBounds(400, 260, 100, 30);
        othersbtn.setFont(labelFont);
        othersbtn.setBackground(Color.white);

        ButtonGroup gendergrp = new ButtonGroup();
        gendergrp.add(malebtn);
        gendergrp.add(femalebtn);
        gendergrp.add(othersbtn);

        add(malebtn);
        add(femalebtn);
        add(othersbtn);

        // Email address and text field
        JLabel email = new JLabel("Email Address:");
        email.setBounds(60, 310, 200, 30);
        email.setFont(labelFont);
        email.setForeground(labelColor);
        add(email);

        emailfield = new JTextField();
        emailfield.setBounds(200, 310, 300, 30);
        emailfield.setFont(new Font("Calibri", Font.PLAIN, 16));
        add(emailfield);

        // Marital status and radio buttons
        JLabel marital = new JLabel("Marital Status:");
        marital.setBounds(60, 360, 200, 30);
        marital.setFont(labelFont);
        marital.setForeground(labelColor);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(200, 360, 100, 30);
        married.setFont(labelFont);
        married.setBackground(Color.white);

        notMarried = new JRadioButton("Unmarried");
        notMarried.setBounds(300, 360, 100, 30);
        notMarried.setFont(labelFont);
        notMarried.setBackground(Color.white);

        otherMarried = new JRadioButton("Others");
        otherMarried.setBounds(400, 360, 100, 30);
        otherMarried.setFont(labelFont);
        otherMarried.setBackground(Color.white);

        ButtonGroup marriedgrp = new ButtonGroup();
        marriedgrp.add(married);
        marriedgrp.add(notMarried);
        marriedgrp.add(otherMarried);

        add(married);
        add(notMarried);
        add(otherMarried);

        // Address and text field
        JLabel address = new JLabel("Address:");
        address.setBounds(60, 410, 200, 30);
        address.setFont(labelFont);
        address.setForeground(labelColor);
        add(address);

        addressfield = new JTextField();
        addressfield.setBounds(200, 410, 300, 30);
        addressfield.setFont(new Font("Calibri", Font.PLAIN, 16));
        add(addressfield);

        // City and text field
        JLabel city = new JLabel("City:");
        city.setBounds(60, 460, 200, 30);
        city.setFont(labelFont);
        city.setForeground(labelColor);
        add(city);

        cityfield = new JTextField();
        cityfield.setBounds(200, 460, 300, 30);
        cityfield.setFont(new Font("Calibri", Font.PLAIN, 16));
        add(cityfield);

        // State and text field
        JLabel state = new JLabel("State:");
        state.setBounds(60, 510, 200, 30);
        state.setFont(labelFont);
        state.setForeground(labelColor);
        add(state);

        statefield = new JTextField();
        statefield.setBounds(200, 510, 300, 30);
        statefield.setFont(new Font("Calibri", Font.PLAIN, 16));
        add(statefield);

        // Pin code and text field
        JLabel pincode = new JLabel("Pin Code:");
        pincode.setBounds(60, 560, 200, 30);
        pincode.setFont(labelFont);
        pincode.setForeground(labelColor);
        add(pincode);

        pincodefield = new JTextField();
        pincodefield.setBounds(200, 560, 300, 30);
        pincodefield.setFont(new Font("Calibri", Font.PLAIN, 16));
        add(pincodefield);

        // Next button
        next = new JButton("Next");
        next.setBounds(400, 610, 100, 40);
        next.setBackground(new Color(0, 102, 204));
        next.setForeground(Color.white);
        next.setFont(new Font("Arial", Font.BOLD, 16));
        next.setFocusPainted(false);
        next.addActionListener(this);
        add(next);

        // Frame settings
        setSize(600, 700);
        setVisible(true);
        setResizable(false);
        setLocation(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        setTitle("Sign Up Page");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno = formNo;
        String name = namefield.getText();
        String fname = fnamefield.getText();
        String dob = ((JTextField) dobfield.getDateEditor().getUiComponent()).getText();
        String gender = malebtn.isSelected() ? "Male" : femalebtn.isSelected() ? "Female" : "Others";
        String email = emailfield.getText();
        String marital = married.isSelected() ? "Married" : notMarried.isSelected() ? "Unmarried" : "Other";
        String address = addressfield.getText();
        String city = cityfield.getText();
        String state = statefield.getText();
        String pincode = pincodefield.getText();

        try {
            mysql c = new mysql();
            String query = "insert into signup values('" + formno + "', '" + name + "', '" + fname + "', '" + dob
                    + "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city + "', '"
                    + state + "', '" + pincode + "')";
            c.s.executeUpdate(query);
            setVisible(false);
            new SignUp2(formNo);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignUp1();
    }
}
