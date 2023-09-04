import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BookHotel extends JFrame implements ActionListener{
    Choice c1,c2,c3;
    JTextField t1;
    JLabel l1,t2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l21,l22,l23,l24,l25;
    JButton b1,b2;

    BookHotel(String username){
        setBounds(300, 200, 1100, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        l1 = new JLabel("BOOK HOTEL");
        l1.setFont(new Font("Tahoma",Font.PLAIN, 24));
        l1.setBounds(100, 0, 300, 30);
        add(l1);

        JLabel l2 = new JLabel("Username");
        l2.setBounds(20, 70, 100, 30);
        add(l2);

        l21 = new JLabel();
        l21.setBounds(250, 70, 150, 30);
        add(l21);

        l3 = new JLabel("Select Hotel");
        l3.setBounds(20, 110, 100, 30);
        add(l3);

        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()){
                c1.add(rs.getString("name"));
            }
            
        }catch(Exception e){}
        c1.setBounds(250, 110, 150, 30);
        add(c1);

        l4 = new JLabel("Total Persons:");
        l4.setBounds(20, 150, 100, 30);
        add(l4);

        t2 = new JLabel();
        t2.setBounds(250, 150, 150, 25);
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from book where username = '"+username+"' order by time desc limit 1");
            while(rs.next()){
                t2.setText(rs.getString(3));
            }


        }catch(Exception e){}
        add(t2);

        l5 = new JLabel("Number of Days");
        l5.setBounds(20, 190, 100, 30);
        add(l5);

        t1 = new JTextField("1");
        t1.setBounds(250, 190, 150, 25);
        add(t1);



        l6 = new JLabel("AC / Non AC");
        l6.setBounds(20, 230, 100, 30);
        add(l6);

        c2 = new Choice();
        c2.add("YES");
        c2.add("NO");
        c2.setBounds(250, 230, 150, 30);
        add(c2);

        l7 = new JLabel("Food Included");
        l7.setBounds(20, 270, 100, 30);
        add(l7);

        c3 = new Choice();
        c3.add("YES");
        c3.add("NO");
        c3.setBounds(250, 270, 150, 30);
        add(c3);

        l8 = new JLabel("ID: ");
        l8.setBounds(20, 310, 100, 30);
        add(l8);

        l22 = new JLabel();
        l22.setBounds(250, 310, 150, 30);
        add(l22);

        l9 = new JLabel("Number: ");
        l9.setBounds(20, 350, 100, 30);
        add(l9);

        l23 = new JLabel();
        l23.setBounds(250, 350, 150, 30);
        add(l23);

        l10 = new JLabel("Phone: ");
        l10.setBounds(20, 390, 100, 30);
        add(l10);

        l24 = new JLabel();
        l24.setBounds(250, 390, 150, 30);
        add(l24);

        l11 = new JLabel("Total Price: ");
        l11.setBounds(20, 430, 100, 30);
        add(l11);

        l25 = new JLabel();
        l25.setForeground(Color.RED);
        l25.setBounds(250, 430, 200, 30);
        add(l25);

        try{

            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(rs.next()){
                l21.setText(rs.getString("username"));
                l22.setText(rs.getString("id"));
                l23.setText(rs.getString("number"));
                l24.setText(rs.getString("phone"));
            }

        }catch(Exception e){

        }
        b1 = new JButton("Check Price");
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.setBounds(50, 490, 120, 30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Book");
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        b2.setBounds(200, 490, 120, 30);
        b2.addActionListener(this);
        add(b2);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(500, 50, 600, 400);
        add(l12);



    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            calculatePrice();
            
        }else{
            String username = l21.getText();
            String hotel = c1.getSelectedItem();
            String person = t1.getText();
            String days = t2.getText();
            String ac = c2.getSelectedItem();
            String food = c3.getSelectedItem();
            String id = l22.getText();
            String number = l23.getText();
            String phone = l24.getText();
            int check = calculatePrice();
            if(check != -1){
                String price = Integer.toString(check);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String time = dtf.format(now);
                try{
                    String q = "insert into bookedhotel values('"+username+"', '"+hotel+"', '"+person+"', '"+days+"', '"+ac+"', '"+food+"', '"+id+"', '"+number+"', '"+phone+"', '"+price+"', '"+time+"')";
                    conn c = new conn();
                    c.s.executeUpdate(q);


                    JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                    this.setVisible(false);


                }catch(Exception e){}

            }


        }
    }



    public static void main(String[] args){
        new BookHotel("").setVisible(true);
    }

    public int calculatePrice(){
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from hotel where name ='"+c1.getSelectedItem()+"'");
            while(rs.next()){
                int cost = Integer.parseInt(rs.getString("cost"));
                int food = Integer.parseInt(rs.getString("food"));
                int ac = Integer.parseInt(rs.getString("ac"));

                int persons = Integer.parseInt(t1.getText());
                int days = Integer.parseInt(t2.getText());

                String acprice = c2.getSelectedItem();
                String foodprice = c3.getSelectedItem();

                if(persons*days > 0){
                    int total = 0;
                    total += acprice.equals("YES") ? ac : 0;
                    total += foodprice.equals("YES") ? food : 0;
                    total += cost;
                    total = total*persons*days;
                    l25.setText(""+total);
                    return total;
                }else{
                    l25.setText("Please enter a valid number");
                    return -1;
                }


            }
        }catch(Exception e){}
        return -1;
    }
    
}
