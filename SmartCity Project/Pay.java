import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.sql.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pay extends JFrame implements ActionListener{

    JButton b1;
    String Current_Package, Current_Package_Price, Current_Hotel, Current_Hotel_Price;
    String username;


    Pay(String username){
        this.username = username;
        setBounds(400, 200, 900, 450);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l8 = new JLabel(i3);
        l8.setBounds(450, 20, 500, 400);
        add(l8);

        JLabel heading = new JLabel("PAYMENT WINDOW");
        heading.setBounds(60, 10, 300, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(heading);

        JLabel l1 = new JLabel("Username: ");
        l1.setBounds(30, 70, 100, 30);
        add(l1);

        JLabel l11 = new JLabel();
        l11.setBounds(250, 70, 200, 30);
        add(l11);

        JLabel l2 = new JLabel("Package: ");
        l2.setBounds(30, 110, 100, 30);
        add(l2);

        JLabel l12 = new JLabel();
        l12.setBounds(250, 110, 200, 30);
        add(l12);

        JLabel l3 = new JLabel("Package price: ");
        l3.setBounds(30, 150, 100, 30);
        add(l3);

        JLabel l13 = new JLabel();
        l13.setBounds(250, 150, 200, 30);
        add(l13);

        JLabel l4 = new JLabel("Hotel: ");
        l4.setBounds(30, 190, 100, 30);
        add(l4);

        JLabel l14 = new JLabel();
        l14.setBounds(250, 190, 200, 30);
        add(l14);

        JLabel l5 = new JLabel("Hotel price: ");
        l5.setBounds(30, 230, 100, 30);
        add(l5);

        JLabel l15 = new JLabel();
        l15.setBounds(250, 230, 200, 30);
        add(l15);

        JLabel l6 = new JLabel("Total price: ");
        l6.setBounds(30, 270, 100, 30);
        add(l6);

        JLabel l16 = new JLabel();
        l16.setBounds(250, 270, 200, 30);
        add(l16);

        try{

            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from book where username = '"+username+"'");
            while(rs.next()){
                l11.setText(rs.getString(1));
                l12.setText(rs.getString(2));
                Current_Package = rs.getString(2);
                Current_Package_Price = rs.getString(7);
                l13.setText("Rs " + rs.getString(7));
                l16.setText(rs.getString(7));
            }

            ResultSet rs1= c.s.executeQuery("select * from bookedhotel where username = '"+username+"' order by time DESC LIMIT 1");
            while(rs1.next()){
                l14.setText(rs1.getString(2));
                Current_Hotel = rs1.getString(2);
                l15.setText("Rs " + rs1.getString(10));
                Current_Hotel_Price = rs1.getString(10);
                l16.setText("Rs " + Integer.toString(Integer.parseInt(l16.getText()) + Integer.parseInt(rs1.getString(10))));
            }



        }catch(Exception e){

        }

        b1 = new JButton("Pay");
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.setBounds(150, 360, 100, 25);
        b1.addActionListener(this);
        add(b1);


    }

    public void actionPerformed(ActionEvent ae){
        String pack, packprice, hotel, hotelprice, total;
        pack = Current_Package;
        packprice = Current_Package_Price;
        hotel = Current_Hotel;
        hotelprice = Current_Hotel_Price;
        total = Integer.toString(Integer.parseInt(packprice) + Integer.parseInt(hotelprice));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String time = dtf.format(now);


        String query = "insert into payment values('"+username+"', '"+pack+"', '"+packprice+"', '"+hotel+"', '"+hotelprice+"', '"+total+"', '"+time+"')";

        try{
            conn c = new conn();
            c.s.executeUpdate(query);
            java.awt.Desktop.getDesktop().browse(URI.create("https://razorpay.com/"));
            JOptionPane.showMessageDialog(null, "Payment Successful");
            this.setVisible(false);
            c.s.executeUpdate("delete from book where username = '"+username+"'");
            c.s.executeUpdate("delete from bookedhotel where username = '"+username+"'");
        }catch(Exception e){

        }

    }


    public static void main(String[] args){
        new Pay("").setVisible(true);
    }

}