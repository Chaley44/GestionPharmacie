package gestionPharmacie.vue;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gestionPharmacie.service.UserImp;

//la classe qui permet de d'afficher la page de connection
public class VueConnection extends JFrame {
	
	private static final long serialVersionUID = 1L;

	JTextField loginField;
	JPasswordField passwordField;
	JLabel loginLabel;
	JLabel passwordLabel;
	JLabel titre;
	JLabel messageErreur;
	
	
	public VueConnection() {
		this.setTitle("Gestion stock");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		
		
		JLabel background = new JLabel(new ImageIcon("C:/Users/hp/Pictures/ImagePharmacy/pharmacy3.jpg"));
		
		this.add(background);
		background.setLayout(new GridBagLayout());
		
		GridBagConstraints g = new GridBagConstraints();
		
		
		g.insets = new Insets(5, 5, 5, 5);
		
		g.gridx = 0;
		g.gridy = 0;
		messageErreur = new JLabel("Le nom d'utilisateur ou le mot de passe incorecte");
		messageErreur.setForeground(Color.RED);
		messageErreur.setVisible(false);
		background.add(messageErreur,g);
		
		g.gridx = 0;
		g.gridy = 1;
		loginLabel = new JLabel("Login");
		loginLabel.setFont(new Font("verdana", Font.BOLD, 14));
		loginLabel.setPreferredSize(new Dimension(90, 25));
		background.add(loginLabel,g);
		
		g.gridx = 1;
		g.gridy = 1;
		loginField = new JTextField();
		loginField.setPreferredSize(new Dimension(200, 25));
		background.add(loginField, g);
		
		g.gridx = 0;
		g.gridy = 2;
		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("verdana", Font.BOLD, 14));
		passwordLabel.setPreferredSize(new Dimension(90, 25));
		background.add(passwordLabel, g);
		
		g.gridx = 1;
		g.gridy = 2;
		passwordField = new JPasswordField();
		passwordField.setPreferredSize(new Dimension(200, 25));
		background.add(passwordField, g);
		
		g.gridx = 1;
		g.gridy = 3;
		JButton envoyer = new JButton("Envoyer");
		envoyer.setFont(new Font("verdana", Font.PLAIN, 14));
		envoyer.setPreferredSize(new Dimension(100, 25));
		envoyer.addActionListener(event -> eventBtnEnvoyer());
		background.add(envoyer, g);
	}
	
	public void eventBtnEnvoyer() {
		
		UserImp connection = new UserImp();
		connection.seConnecter(getWarningString(), getName());
		
		Dialog dialog = new JDialog();

		String login, password;
		login = loginField.getText();
		password = String.valueOf(passwordField.getPassword()) ;
		
		if(connection.seConnecter(login, password)) {
			dialog.setLocationRelativeTo(null);
			dialog.setSize(200, 200);
			dialog.setVisible(true);
			
		}else {
			System.out.println(login);
			System.out.println(password);
			messageErreur.setVisible(true);
			
		}
		
	}
	

}
