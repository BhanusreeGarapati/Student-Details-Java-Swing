package jdbcprj;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class StudentFrame extends JFrame {
private JPanel contentPane;
private JTextField textrno;
private JTextField textname;
private JTextField textbranch;
private JTextField textdoj;
private JButton btnreset;
private JLabel lblstatus;
/**
* Launch the application.
*/
public static void main(String[] args) throws ClassNotFoundException, SQLException{
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
StudentFrame frame = new StudentFrame();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
/**
* Create the frame.
*/
public StudentFrame() {
setTitle("Student Details");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 825, 587);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);
JLabel lblNewLabel = new JLabel("STUDENT FORM");
lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
lblNewLabel.setBounds(256, 10, 192, 42);
contentPane.add(lblNewLabel);
JLabel lblNewLabel_1 = new JLabel("Enter Roll Number");
lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
lblNewLabel_1.setBounds(47, 61, 167, 42);
contentPane.add(lblNewLabel_1);
JLabel lblNewLabel_2 = new JLabel("Enter Name");
lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
lblNewLabel_2.setBounds(47, 149, 130, 49);
contentPane.add(lblNewLabel_2);
JLabel lblNewLabel_3 = new JLabel("Enter Branch");
lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
lblNewLabel_3.setBounds(47, 208, 118, 42);
contentPane.add(lblNewLabel_3);
JLabel lblNewLabel_4 = new JLabel("DOJ [dd-mon-yyyy]");
lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
lblNewLabel_4.setBounds(47, 276, 167, 49);
contentPane.add(lblNewLabel_4);
textrno = new JTextField();
textrno.setFont(new Font("Tahoma", Font.BOLD, 15));
textrno.setBounds(266, 62, 201, 42);
contentPane.add(textrno);
textrno.setColumns(10);
textname = new JTextField();
textname.setFont(new Font("Tahoma", Font.BOLD, 15));
textname.setBounds(266, 149, 201, 42);
contentPane.add(textname);
textname.setColumns(10);
textbranch = new JTextField();
textbranch.setFont(new Font("Tahoma", Font.BOLD, 15));
textbranch.setBounds(266, 209, 201, 42);
contentPane.add(textbranch);
textbranch.setColumns(10);
textdoj = new JTextField();
textdoj.setFont(new Font("Tahoma", Font.BOLD, 15));
textdoj.setBounds(266, 280, 208, 42);
contentPane.add(textdoj);
textdoj.setColumns(10);
JButton btnOk = new JButton("OK");
btnOk.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
int n=Integer.parseInt(textrno.getText());
String name=textname.getText();
String branch=textbranch.getText();
String doj=textdoj.getText();
lblstatus.setText(n+ " "+name+" "+branch+" "+doj);
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521: 
XE", "system", "password");
 PreparedStatement stmt=conn.prepareStatement("insert into student 
values(?,?,?,?)");
 stmt.setInt(1, n);
 stmt.setString(2, name);
 stmt.setString(3,branch);
 stmt.setString(4, doj);
int r=stmt.executeUpdate();
if(r>0)
lblstatus.setText("Record inserted");
else
lblstatus.setText("Cannot insert record");
conn.close();
 }
catch(ClassNotFoundException | SQLException ex)
{
System.out.println("Error msg: "+ex);
}
}
});
btnOk.setFont(new Font("Tahoma", Font.BOLD, 15));
btnOk.setBounds(94, 369, 192, 49);
contentPane.add(btnOk);
btnreset = new JButton("RESET");
btnreset.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
textrno.setText("");
textname.setText("");
textbranch.setText("");
textdoj.setText("");
lblstatus.setText("");
}
});
btnreset.setFont(new Font("Tahoma", Font.BOLD, 15));
btnreset.setBounds(364, 365, 192, 53);
contentPane.add(btnreset);
lblstatus = new JLabel("");
lblstatus.setFont(new Font("Tahoma", Font.BOLD, 15));
lblstatus.setBounds(238, 459, 265, 49);
contentPane.add(lblstatus);
}
}