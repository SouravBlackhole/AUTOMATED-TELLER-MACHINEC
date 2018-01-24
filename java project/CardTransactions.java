import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class CardTransactions extends JFrame 
{
JButton button1,button2;
JLabel label1;
Container container;
public CardTransactions()
{
super("CardTransactions");
container=getContentPane();
container.setLayout(null);
button1=new JButton(">>>");
button1.setBounds(30,50,100,30);
button1.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
try
{
Class.forName("com.mysql.jdbc.Driver");
}
catch(ClassNotFoundException a)
{
System.out.println(a);
}
DB2 s=new DB2();
s.ChangePword();
}
});
container.add(button1);
button2=new JButton("BACK");
button2.setBounds(30,150,100,30);
button2.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
DB2 s=new DB2();
s.Back();
}
});
container.add(button2);
label1=new JLabel("Change Pin");
label1.setBounds(130,45,120,30);
container.add(label1);
setSize(400,350);
setVisible(true);
}
}

