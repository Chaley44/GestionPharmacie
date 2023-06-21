package gestionPharmacie.vue;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class VueMedicament extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2542438010935523931L;

	
	public VueMedicament() {
		this.setTitle("Gestion des lots");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void initComponent() {
		JTextField nomMedicamentField = new JTextField();
		JTextField quantiteStockField = new JTextField();
		JTextField stockAlerteField = new JTextField();
		
		JLabel nomMedicamentLabel = new JLabel("Nom");
		JLabel quantiteStockLabel = new JLabel("quantite Stock");
		JLabel stockAlerteLabel = new JLabel("StockAlerte");
		
		JLabel label1 = new JLabel();
		
		JTable medicamentTable = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnSave = new JButton("Save");
		JButton btnUpdate = new JButton("Update");
		JButton btnDelete = new JButton("Delete");
		
		nomMedicamentLabel.setFont(new Font("verdana", Font.BOLD, 14));
		nomMedicamentLabel.setPreferredSize(new Dimension(90, 25));
		
		stockAlerteLabel.setFont(new Font("verdana", Font.BOLD, 14));
		stockAlerteLabel.setPreferredSize(new Dimension(90, 25));
		
		
		
	}
}
