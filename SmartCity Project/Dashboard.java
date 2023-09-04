import javax.swing.*;
import javax.swing.border.*;
import java.awt.Image;
import java.awt.*;
import java.awt.event.*;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dashboard extends JFrame implements ActionListener{

    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14;
    String username;
    Dashboard(String username) {
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 0, 350, 1080);
        p1.setBackground(new Color(0, 0, 0, 125));
        add(p1);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(20, 30, 300, 728);
        p2.setBackground(new Color(194, 178, 128));
        p1.add(p2);

        JPanel p3 = new JPanel();
        p3.setLayout(null);
        p3.setBounds(550, 8, 600, 80);
        p3.setBackground(new Color(0, 0, 0, 125));
        add(p3);

        b1 = new JButton("Add Personal Details");
        b1.setBackground(new Color(152, 105, 96));
        b1.setBorder(new LineBorder(Color.BLACK));
        b1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b1.setForeground(Color.BLACK);
        b1.setMargin(new Insets(0, 0, 0, 60));
        b1.setBounds(0, 0, 300, 52);
        b1.addActionListener(this);
        p2.add(b1);

        b2 = new JButton("Update Personal Details");
        b2.setBackground(new Color(152, 105, 96));
        b2.setBorder(new LineBorder(Color.BLACK));;
        b2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b2.setMargin(new Insets(0, 0, 0, 30));
        b2.setForeground(Color.BLACK);
        b2.setBounds(0, 52, 300, 52);
        b2.addActionListener(this);
        p2.add(b2);

        b3 = new JButton("View Details");
        b3.setBackground(new Color(152, 105, 96));
        b3.setBorder(new LineBorder(Color.BLACK));;
        b3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b3.setMargin(new Insets(0, 0, 0, 130));
        b3.setForeground(Color.BLACK);
        b3.setBounds(0, 104, 300, 52);
        b3.addActionListener(this);
        p2.add(b3);

        b4 = new JButton("Check Package");
        b4.setBackground(new Color(152, 105, 96));
        b4.setBorder(new LineBorder(Color.BLACK));;
        b4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b4.setMargin(new Insets(0, 0, 0, 33));
        b4.setForeground(Color.BLACK);
        b4.setBounds(0, 156, 300, 52);
        b4.addActionListener(this);
        p2.add(b4);

        b5 = new JButton("Book Package");
        b5.setBackground(new Color(152, 105, 96));
        b5.setBorder(new LineBorder(Color.BLACK));;
        b5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b5.setMargin(new Insets(0, 0, 0, 110));
        b5.setForeground(Color.BLACK);
        b5.setBounds(0, 208, 300, 52);
        b5.addActionListener(this);
        p2.add(b5);

        b6 = new JButton("View Package");
        b6.setBackground(new Color(152, 105, 96));
        b6.setBorder(new LineBorder(Color.BLACK));;
        b6.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b6.setMargin(new Insets(0, 0, 0, 120));
        b6.setForeground(Color.BLACK);
        b6.setBounds(0, 260, 300, 52);
        b6.addActionListener(this);
        p2.add(b6);

        b7 = new JButton("View Hotels");
        b7.setBackground(new Color(152, 105, 96));
        b7.setBorder(new LineBorder(Color.BLACK));;
        b7.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b7.setMargin(new Insets(0, 0, 0, 102));
        b7.setForeground(Color.BLACK);
        b7.setBounds(0, 312, 300, 52);
        b7.addActionListener(this);
        p2.add(b7);

        b8 = new JButton("Book Hotel");
        b8.setBackground(new Color(152, 105, 96));
        b8.setBorder(new LineBorder(Color.BLACK));;
        b8.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b8.setMargin(new Insets(0, 0, 0, 130));
        b8.setForeground(Color.BLACK);
        b8.setBounds(0, 364, 300, 52);
        b8.addActionListener(this);
        p2.add(b8);

        b9 = new JButton("View Booked Hotel");
        b9.setBackground(new Color(152, 105, 96));
        b9.setBorder(new LineBorder(Color.BLACK));;
        b9.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b9.setMargin(new Insets(0, 0, 0, 140));
        b9.setForeground(Color.BLACK);
        b9.setBounds(0, 416, 300, 52);
        b9.addActionListener(this);
        p2.add(b9);

        b10 = new JButton("Destinations");
        b10.setBackground(new Color(152, 105, 96));
        b10.setBorder(new LineBorder(Color.BLACK));;
        b10.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b10.setMargin(new Insets(0, 0, 0, 70));
        b10.setForeground(Color.BLACK);
        b10.setBounds(0, 468, 300, 52);
        b10.addActionListener(this);
        p2.add(b10);

        b11 = new JButton("Pay");
        b11.setBackground(new Color(152, 105, 96));
        b11.setBorder(new LineBorder(Color.BLACK));;
        b11.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b11.setMargin(new Insets(0, 0, 0, 125));
        b11.setForeground(Color.BLACK);
        b11.setBounds(0, 520, 300, 52);
        b11.addActionListener(this);
        p2.add(b11);

        b12 = new JButton("Payment Details");
        b12.setBackground(new Color(152, 105, 96));
        b12.setBorder(new LineBorder(Color.BLACK));;
        b12.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b12.setMargin(new Insets(0, 0, 0, 155));
        b12.setForeground(Color.BLACK);
        b12.setBounds(0, 572, 300, 52);
        b12.addActionListener(this);
        p2.add(b12);

        b13 = new JButton("Calculator");
        b13.setBackground(new Color(152, 105, 96));
        b13.setBorder(new LineBorder(Color.BLACK));;
        b13.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b13.setMargin(new Insets(0, 0, 0, 145));
        b13.setForeground(Color.BLACK);
        b13.setBounds(0, 624, 300, 52);
        b13.addActionListener(this);
        p2.add(b13);

        b14 = new JButton("Notepad");
        b14.setBackground(new Color(152, 105, 96));
        b14.setBorder(new LineBorder(Color.BLACK));;
        b14.setFont(new Font("Tahoma", Font.PLAIN, 20));
        b14.setMargin(new Insets(0, 0, 0, 150));
        b14.setForeground(Color.BLACK);
        b14.setBounds(0, 676, 300, 52);
        b14.addActionListener(this);
        p2.add(b14);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0, 0, 1950, 1000);
        add(l1);

        JLabel l4 = new JLabel("Travel And Tourism Management System");
        l4.setBounds(20, 3, 600, 60);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 30));
        l4.setForeground(Color.WHITE);
        p3.add(l4);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b13){
            try{
                Runtime.getRuntime().exec("calc.exe");

            }catch(Exception e){

            }

        }else if(ae.getSource() == b14){
            try{
                Runtime.getRuntime().exec("notepad.exe");

            }catch(Exception e){

            }

        }else if(ae.getSource() == b1){
            conn c = new conn();
            int x = 0;
            try {
                ResultSet rs = c.s.executeQuery("Select count(*) from customer where username = '"+username+"'");
                while(rs.next()){
                    x = rs.getInt("count(*)");
                }
                if(x==1){
                    JOptionPane.showMessageDialog(null, "Customer Details already added");
                }
                else{

                    new AddCustomer(username).setVisible(true);

                }
            } catch (SQLException e) {}
        }else if(ae.getSource() == b2){

            new UpdateCustomer(username).setVisible(true);

        }else if(ae.getSource() == b3){

            new ViewCustomer(username).setVisible(true);

        }else if(ae.getSource() == b4){

            new CheckPackage().setVisible(true);

        }else if(ae.getSource() == b5){
            conn c = new conn();
            int x = 0;
            try {
                ResultSet rs = c.s.executeQuery("Select count(*) from book where username = '"+username+"'");
                while(rs.next()){
                    x = rs.getInt("count(*)");
                }
                if(x==1){
                    JOptionPane.showMessageDialog(null, "One Package already booked.\nComplete current package\npayment for further bookings");
                }
                else{

                    new BookPackage(username).setVisible(true);

                }
            } catch (SQLException e) {}
        }else if(ae.getSource() == b6){

            new ViewPackage(username).setVisible(true);

        }else if(ae.getSource() == b7){

            new CheckHotels().setVisible(true);

        }else if(ae.getSource() == b10){

            new Destinations().setVisible(true);

        }else if(ae.getSource() == b8){
            conn c = new conn();
            int x = 0;
            try {
                ResultSet rs = c.s.executeQuery("Select count(*) from bookedhotel where username = '"+username+"'");
                while(rs.next()){
                    x = rs.getInt("count(*)");
                }
                if(x==1){
                    JOptionPane.showMessageDialog(null, "One Hotel already booked.\nComplete current package\npayment for further bookings");
                }
                else{

                    new BookHotel(username).setVisible(true);

                }
            } catch (SQLException e) {}
        }else if(ae.getSource() == b9){

            new ViewBookedHotel(username).setVisible(true);

        }else if(ae.getSource() == b11){

            new Pay(username).setVisible(true);

        }else if(ae.getSource() == b12){

            new PaymentHistory(username).setVisible(true);

        }
    }
    public static void main(String[] args) throws IOException {
        new Dashboard("").setVisible(true);
    }
}
