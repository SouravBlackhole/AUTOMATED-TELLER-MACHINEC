import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class DB2 extends JFrame implements ActionListener
{
JButton but1,but2,but3,but4;
JTextField text1,text2,text3;
JLabel label1,label2,label3;
String str1,str2,str3;
int pword;
JPasswordField pwordfield;
Container c;
public DB2()
{
super("Executions");
}
public void ChangePword()
{
c=getContentPane();
c.setLayout(null);
but1=new JButton("OK");
but1.addActionListener(this);
but1.setBounds(200,180,80,23);
c.add(but1);
but2=new JButton("CANCEL");
but2.addActionListener(this);
but2.setBounds(100,180,80,22);
c.add(but2);
text1=new JTextField(10);
text1.setBounds(200,50,120,80);
str1=text1.getText();
c.add(text1);
text2=new JTextField(10);
text2.setBounds(200,100,120,80);
str2=text2.getText();
c.add(text2);
label1=new JLabel("Enter Your Old Password");
label1.setBounds(33,46,150,30);
c.add(label1);
label2=new JLabel("Enter Your New Password:");
label2.setBounds(33,96,160,30);
c.add(label2);
pwordfield=new JPasswordField(17);
c.add(pwordfield);
setSize(350,300);
setVisible(true);

show();
}
public void Back()
{
this.hide();
MainMenu s=new MainMenu();
s.Main();
}
public void Demonstration()
{
c=getContentPane();
c.setLayout(new FlowLayout());
label3=new JLabel("To see remainder,Write Your Password");
c.add(label3);
text3=new JTextField(10);
c.add(text3);
but3=new JButton("ok");
but3.addActionListener(this);
c.add(but3);
but4=new JButton("BACK");
but4.addActionListener(this);
c.add(but4);
setSize(350,200);
setVisible(true);
show();
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==but1)
{
str1=text1.getText();
str2=text2.getText();
String run="UPDATE abc SET password='"+str2+"' WHERE password="+str1;
try
{
Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/run","root","root");
Statement stmt=connection.createStatement();
stmt.executeUpdate(run);
System.out.println("Operation Completed.....");
}
catch(SQLException a)
{
System.out.println("1 " + a);
}
}
else if(ae.getSource()==but2)
{
this.hide();
}
else if(ae.getSource()==but3)
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
str3=text3.getText();
int pword=Integer.parseInt(str3);
String run="SELECT * FROM abc  WHERE password="+pword;
System.out.println(run);
Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/run","root","root");
Statement stmt=connection.createStatement();
ResultSet result=stmt.executeQuery(run);
while(result.next())
{
String name=result.getString(1);
String surname=result.getString(2);
String amount=result.getString(3);
String password=result.getString(4);
JOptionPane.showMessageDialog(this,"Your Total Money is:"+amount+"Rs");
}
}
catch(SQLException a)
{
System.out.println("2 " + a);
}
}
else if(ae.getSource()==but4)
{
this.hide();
}
}
}


