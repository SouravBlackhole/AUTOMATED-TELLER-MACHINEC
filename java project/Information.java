import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Information extends JFrame implements ActionListener
{
JButton button1,button2;
JLabel label1,label2;
Container container;
public Information()
{
super("Information");
container=getContentPane();
container.setLayout(null);
button1=new JButton(">>>");
button1.setBounds(30,50,100,30);
button1.addActionListener(this);
container.add(button1);
button2=new JButton("CANCEL");
button2.setBounds(30,100,100,30);
button2.addActionListener(this);
container.add(button2);
label1=new JLabel("Balance");
label1.setBounds(150,43,120,30);
container.add(label1);
label2=new JLabel("enquiry");
label2.setBounds(150,56,120,30);
container.add(label2);
setSize(400,300);
setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==button1)
{
DB2 s=new DB2();
s.Demonstration();
}
else if(ae.getSource()==button2)
{
this.hide();
DB2 s=new DB2();
s.Back();
}
}
}
