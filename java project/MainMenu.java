import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class MainMenu extends JFrame implements ActionListener
{
JButton but1,but2,but3,but4,but5,but6,but7;
JLabel label1,label2,label3,label4,label5;
JTextArea textarea;
JPasswordField pwordfield;
int pw,intt;
String strt;
Container c;
public MainMenu()
{
super("ATM");
}
public void Main()
{
c=getContentPane();
c.setLayout(null);
but1=new JButton(">>>");
but1.setBounds(50,50,100,30);
c.add(but1);
but2=new JButton(">>>");
but2.setBounds(50,100,100,30);
c.add(but2);
but3=new JButton("<<<");
but3.setBounds(375,50,100,30);
c.add(but3);
but4=new JButton("<<<");
but4.setBounds(375,100,100,30);
c.add(but4);
but5=new JButton("CANCEL");
but5.setBounds(200,212,100,30);
c.add(but5);
but1.addActionListener(this);
but2.addActionListener(this);
but3.addActionListener(this);
but4.addActionListener(this);
but5.addActionListener(this);
label1=new JLabel("CASH");
label1.setBounds(160,40,75,50);
c.add(label1);
label2=new JLabel("INFORMATION");
label2.setBounds(280,40,85,50);
c.add(label2);
label3=new JLabel("TRANSFER");
label3.setBounds(160,90,85,50);
c.add(label3);
label4=new JLabel("Change");
label4.setBounds(280,90,85,50);
c.add(label4);
label5=new JLabel("pin");
label5.setBounds(280,108,100,50);
c.add(label5);
setSize(500,410);
setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==but5)
System.exit(0);
else if(ae.getSource()==but1)
{
new Cash();
this.hide();
}
else if(ae.getSource()==but3)
{
new Information();
this.hide();
}
else if(ae.getSource()==but4)
{
new CardTransactions();
this.hide();
}
else if(ae.getSource()==but7)
System.exit(0);
else if(ae.getSource()==but6)
{
try
{
Class.forName("com.mysql.jdbc.Driver");
}
catch(ClassNotFoundException a)
{
System.out.println(a);
}
try
{
String string1=new String(pwordfield.getPassword());
intt=Integer.parseInt(string1);
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/run" ,"root" ,"root");
Statement stmt=con.createStatement();
String run=("SELECT * FROM abc WHERE password="+intt);
System.out.println(run);
ResultSet result=stmt.executeQuery(run);
while(result.next())
{
String name=result.getString(1);
String surname=result.getString(2);
int amount=result.getInt(3);
int password=result.getInt(4);
pw=password;
}
}
catch(SQLException a)
{
System.out.println(a);
}
this.hide();
if(pw==intt)
{
MainMenu s=new MainMenu();
s.Main();
}
else if(pw!=intt)
{
JOptionPane.showMessageDialog(this,"Invalid Password Please Try Again");
MainMenu s=new MainMenu();
s.Password();
}
}
}
public static void main(String arg[])
{
MainMenu s=new MainMenu();
s.Password();
}
public void Password()
{
c=getContentPane();
c.setLayout(new FlowLayout());
pwordfield=new JPasswordField(17);
c.add(pwordfield);
but6=new JButton("OK");
but6.setPreferredSize(new Dimension(90,25));
but6.setSize(but6.getPreferredSize());
but6.addActionListener(this);
c.add(but6);
but7=new JButton("CANCEL");
but7.setPreferredSize(new Dimension(90,25));
but7.setSize(but7.getPreferredSize());
but7.addActionListener(this);
c.add(but7);
String sttr=" W E L C O M E!\n"+
"Please enter your password\n";
textarea = new JTextArea(sttr,10,17);
c.add(textarea);
setVisible(true);
setSize(220,300);
show();
}
}





																																																																										