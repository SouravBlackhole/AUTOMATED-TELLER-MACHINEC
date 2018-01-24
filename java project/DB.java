import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class DB extends JFrame implements ActionListener
{
JButton but1,but2,but3,but4;
JTextField text1,text2;
JLabel label1,label2;
int Amount,Amount1,pword,int1,int8;
String str1,str2;
String run;
Container c;
public DB()
{
}
public void ExecutionForAnother()
{
c=getContentPane();
c.setLayout(new FlowLayout());
label1=new JLabel("Write the money you want to get and your password:");
c.add(label1);
text1=new JTextField(10);
c.add(text1);
but1=new JButton("OK");
but1.addActionListener(this);
c.add(but1);
but4=new JButton("BACK");
but4.addActionListener(this);
c.add(but4);
setSize(400,250);
setVisible(true);
show();
}
public void CashScreen()
{
c=getContentPane();
c.setLayout(new FlowLayout());
label2=new JLabel("Please Write password and press OK:");
c.add(label2);
text2=new JTextField(10);
c.add(text2);
but2=new JButton("OK");
but2.setPreferredSize(new Dimension(80,25));
but2.setSize(but2.getPreferredSize());
but2.addActionListener(this);
c.add(but2);
but3=new JButton("CANCEL");
but3.setPreferredSize(new Dimension(80,25));
but3.addActionListener(this);
c.add(but3);
setSize(350,200);
show();
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==but2)
{
str2=text2.getText();
 int8=Integer.parseInt(str2);
try
{
String run="SELECT * From abc WHERE password="+int8;
System.out.println(run);
Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/run","root","root");
Statement stmt=connection.createStatement();
ResultSet result=stmt.executeQuery(run);
while(result.next())
{
String name=result.getString(1);
String surname=result.getString(2);
int amount=result.getInt(3);
int password=result.getInt(4);
Amount=amount;
}
}
catch(SQLException a)
{
System.out.println(a);
}
Amount=Amount-20;
String run="UPDATE abc SET amount="+Amount+" WHERE password="+int8;
try
{
Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/run","root","root");
Statement stmt=connection.createStatement();
stmt.executeUpdate(run);
System.out.println("Operation Completed");
}
catch(SQLException a)
{
System.out.println(a);
}
}
else if(ae.getSource()==but4)
{
this.hide();
}
else if(ae.getSource()==but1)
{
str1=text1.getText();
pword=Integer.parseInt(str1);
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
String run="SELECT * From abc"+"WHERE password="+pword;
System.out.println(run);
Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/run","root","root");
Statement stmt=connection.createStatement();
ResultSet result=stmt.executeQuery(run);
while(result.next())
{
String name=result.getString(1);
String surname=result.getString(2);
int amount=result.getInt(3);
int password=result.getInt(4);
Amount1=amount;
}
}
catch(SQLException a)
{
System.out.println(a);
}
str1=text1.getText();
int1=Integer.parseInt(str1);
Amount1=Amount1-int1;
String run2="UPDATE abc SET amount="+Amount1+" WHERE password="+pword;
try
{
Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3006/run","root","root");
Statement stmt=connection.createStatement();
stmt.executeUpdate(run);
System.out.println("Operation Completed");
}
catch(SQLException a)
{
System.out.println(a);
}
}
else if(ae.getSource()==but3)
{
this.hide();
}
}
}







