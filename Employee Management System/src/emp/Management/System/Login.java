package emp.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{
	
	JTextField tfUname , tfPass;
	
	Login(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(40, 20, 100, 30);
		add(lblUsername);
		
		tfUname = new JTextField();
		tfUname.setBounds(150, 20, 150, 30);
		add(tfUname);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(40, 70, 100, 30);
		add(lblPassword);
		
		tfPass = new JTextField();
		tfPass.setBounds(150, 70, 150, 30);
		add(tfPass);
		

		JButton login = new JButton("LOGIN");
		login.setBounds(150, 140, 150, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 0, 200, 200);
		add(image);
		
		
		
		setSize(600, 300);
		setLocation(450, 200);
		setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		try {
			String username = tfUname.getText();
			String password = tfPass.getText();
			
			Conn c = new Conn();
			String query  = "select * from login where username = '"+username+"' and password = '"+password+"'";
			
			ResultSet rs = c.s.executeQuery(query);
			new Home();
			
			if(rs.next()) {
				
				setVisible(false);
				
				
			}
			else {
				JOptionPane.showMessageDialog(null ,"Invalid Username or Password" );
				setVisible(false);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		
		new Login();

	}

}
