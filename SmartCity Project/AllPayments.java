import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AllPayments extends JFrame {

    public AllPayments(String username) throws SQLException {

        setBounds(600, 200, 450, 440);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JPanel contentpane = new JPanel();
        contentpane.setBorder(new EmptyBorder(5,5,5,5));
        contentpane.setLayout(new BorderLayout(0,0));
        setContentPane(contentpane);

        JTextArea textArea = new JTextArea(username,15,10);
        contentpane.add(textArea, BorderLayout.CENTER);

        JScrollPane sp = new JScrollPane(textArea);
        contentpane.add(sp);

        conn c = new conn();
        ResultSet rs = c.s.executeQuery("select * from payment where username = '"+username+"'");
        while(rs.next()){
            textArea.append("\nPackage type: " + rs.getString("pack"));
            textArea.append("\nPackage price: " + rs.getString("packprice"));
            textArea.append("\nHotel : " + rs.getString("hotel"));
            textArea.append("\nHotel price: " + rs.getString("hotelprice"));
            textArea.append("\nTotal price: " + rs.getString("total"));
            textArea.append("\nTime of Payment: " + rs.getString("time") + "\n___________________________________\n");
        }
        textArea.setEditable(false);



    }

    public static void main(String[] args) throws SQLException {
        new AllPayments("").setVisible(true);
    }
}
