import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Cash extends JFrame implements ActionListener
{
JButton button1,button2,button3,button4,button5,button6,button7,buttoncancel;
JLabel label1,label2,label3,label4,label5,label6;
JTextField textfield;
Container container;
public Cash()
{
super("Cash");
container=getContentPane();
container.setLayout(null);
textfield=new JTextField(10);
button1=new JButton(">>>");
button1.setBounds(50,50,100,30);
button1.addActionListener(this);
container.add(button1);
button2=new JButton(">>>");
button2.setBounds(50,100,100,30);
button2.addActionListener(this);
container.add(button2);
button3=new JButton(">>>");
button3.setBounds(50,150,100,30);
button3.addActionListener(this);
container.add(button3);
button4=new JButton("<<<");
button4.setBounds(375,50,100,30);
button4.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==button4)
{
try
{
Class.forName("com.mysql.jdbc.Driver");
}
catch(ClassNotFoundException a)
{
System.err.println(a);
}
DB s=new DB();
s.CashScreen();
}
}
});
container.add(button4);
button5=new JButton("<<<");
button5.setBounds(375,100,100,30);
button5.addActionListener(this);
container.add(button5);
button6=new JButton("<<<");
button6.setBounds(375,150,100,30);
button6.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==button6)
{
try
{
Class.forName("com.mysql.jdbc.Driver");
}
catch(ClassNotFoundException a)
{
System.out.println(a);
}
DB s=new DB();
s.ExecutionForAnother();
}
}
});
container.add(button6);
buttoncancel=new JButton("CANCEL");
buttoncancel.setBounds(375,200,100,30);
buttoncancel.addActionListener(this);
container.add(buttoncancel);
label1=new JLabel("10Rs");
label1.setBounds(150,50,75,30);
container.add(label1);
label2=new JLabel("OK");
label2.setBounds(300,50,75,30);
container.add(label2);
label3=new JLabel("50Rs");
label3.setBounds(150,100,75,30);
container.add(label3);
label4=new JLabel("100Rs");
label4.setBounds(300,100,75,30);
container.add(label4);
label5=new JLabel("1000Rs");
label5.setBounds(150,150,75,30);
container.add(label5);
label6=new JLabel("Another");
label6.setBounds(300,150,85,30);
container.add(label6);
setSize(500,400);
setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==buttoncancel)
{
this.hide();
MainMenu s=new MainMenu();
s.Main();
}
}
}








