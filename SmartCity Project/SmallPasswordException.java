import javax.swing.*;

public class SmallPasswordException extends Exception{
    SmallPasswordException(){
        JOptionPane.showMessageDialog(null, "Password too short. Try another one");
    }
}
