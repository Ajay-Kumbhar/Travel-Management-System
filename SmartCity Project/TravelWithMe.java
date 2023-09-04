import javax.swing.*;
import java.awt.*;
public class TravelWithMe{
     public static void main(String[] args){
        cityFrame f1 = new cityFrame();
        f1.setVisible(true);
        int x = 1;
        for(int i = 1; i<=  400; i+=4,x+=5){
            f1.setLocation(750 -((x+i)/2),550-i);
            f1.setSize(x+i,i);   
            try{
                Thread.sleep(10);

            }catch(Exception e){}
        }

        f1.setVisible(true);

    }
}

class cityFrame extends JFrame implements Runnable{
    Thread t1;
    cityFrame(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        add(l1);
        setUndecorated(true);
        t1 = new Thread(this);
        t1.start();

    }
    public void run(){
        try{
            Thread.sleep(3000);
            this.setVisible(false);

            new Login().setVisible(true);

        }catch(Exception e){}

    }

}