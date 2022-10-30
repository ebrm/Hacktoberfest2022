import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

 class Swng1 implements ActionListener{
JButton b1;
JLabel l1;
JButton b2;

 Swng1(){
  JFrame frame=new JFrame("welcome");
     b1=new JButton("yes");
    b2=new JButton("no");
     JLabel l1=new JLabel("heyy willing to die..?");
     JTextField t1=new JTextField("anything else...");

    b1.setBounds(50,100,60,30);
    b2.setBounds(120,100,60,30); //(lenth (from left top corner) , breadth from frame(buttom) , button's lenth(ftrom left top corner) , button's width(down))
    l1.setBounds(10,50,130,30);
    t1.setBounds(90,150,50,50);

  frame.add(l1);
  frame.add(b1);
  frame.add(b2);
  frame.add(t1);

  frame.setLayout(null);
  frame.setSize(300,350);
  frame.setVisible(true);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    b1.addActionListener(this);
    b2.addActionListener(this);
}

public void actionPerformed(ActionEvent e){
  //  Object source=e.getSource();
  JFrame frame1=new JFrame();
      if (e.getSource()==b1){
        System.out.println("hhhhhhhhhhhhhhhhhhh");

  JLabel  l2=new JLabel("welcome..");
  l2.setBounds(0,0,10,30);
        frame1.add(l2);
      }
        else if(e.getSource()==b2){
          System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa");

      JLabel  l3=new JLabel("get lost..");
      l3.setBounds(0,0,10,30);
        frame1.add(l3);
        }
        frame1.setSize(100,150);
        frame1.setVisible(true);
      }

}
    public class Swng{
public static void main(String[] args) {
  Swng1 a=new Swng1();
}
}
