package gestionPharmacie.vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import gestionPharmacie.domaine.Emplacement;
import gestionPharmacie.domaine.Medicament;
import gestionPharmacie.service.EmplacementImp;
import gestionPharmacie.service.IMetier;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VueEmplacement {

	
	private JFrame frame;
	private JTextField abscisseField;
	private JTextField ordonneField;
	private JTextField nombreLotField;
	private JTable table;

	public IMetier<Emplacement, Integer> imp = new EmplacementImp();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueEmplacement window = new VueEmplacement();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VueEmplacement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 664, 60);
		frame.getContentPane().add(panel);
		
		JLabel titreLabel = new JLabel("GESTION PHARMACIE");
		titreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titreLabel.setForeground(Color.BLUE);
		titreLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		titreLabel.setBounds(10, 11, 628, 38);
		panel.add(titreLabel);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(10, 68, 664, 16);
		frame.getContentPane().add(toolBar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 94, 509, 156);
		frame.getContentPane().add(panel_1);
		
		JLabel abscisseLabel = new JLabel("abscisse:");
		abscisseLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		abscisseLabel.setBounds(10, 11, 73, 27);
		panel_1.add(abscisseLabel);
		
		abscisseField = new JTextField();
		abscisseField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		abscisseField.setColumns(10);
		abscisseField.setBounds(77, 15, 140, 22);
		panel_1.add(abscisseField);
		
		ordonneField = new JTextField();
		ordonneField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ordonneField.setColumns(10);
		ordonneField.setBounds(77, 69, 140, 22);
		panel_1.add(ordonneField);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Emplacement emplacement = new Emplacement();
					emplacement.setAbscisse(Integer.parseInt(abscisseField.getText()));
					emplacement.setOrdonne(ordonneField.getText());
					emplacement.setNombreLot(imp.liste().size());
					
					imp.creer(emplacement);
				} catch (Exception e2) {
					e2.getMessage();
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(10, 124, 89, 23);
		panel_1.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(122, 124, 89, 23);
		panel_1.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(231, 124, 89, 23);
		panel_1.add(btnDelete);
		
		JLabel ordonneLabel = new JLabel("ordonne:");
		ordonneLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ordonneLabel.setBounds(10, 65, 57, 27);
		panel_1.add(ordonneLabel);
		
		JLabel nombreLotLabel = new JLabel("nombre Lot:");
		nombreLotLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nombreLotLabel.setBounds(248, 11, 83, 27);
		panel_1.add(nombreLotLabel);
		
		nombreLotField = new JTextField();
		nombreLotField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nombreLotField.setColumns(10);
		nombreLotField.setBounds(341, 15, 140, 22);
		panel_1.add(nombreLotField);
		
		table = new JTable();
		table.setBackground(Color.GRAY);
		table.setBounds(10, 261, 664, 147);
		frame.getContentPane().add(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(new Color(128, 255, 255));
		panel_2.setBounds(0, 419, 684, 41);
		frame.getContentPane().add(panel_2);
		
		JLabel BottomEmplacementLabel = new JLabel("Gestion Emplacement");
		BottomEmplacementLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		BottomEmplacementLabel.setBounds(288, 11, 144, 30);
		panel_2.add(BottomEmplacementLabel);
		

	}
	
	public void addTable() {
		try {
			
			String [] tableEmplacement = {"id", "abscisse", "ordonne", "nombreLot"};
			String [] ligne = new String[5];
			
			DefaultTableModel model = new DefaultTableModel(null, tableEmplacement);
			for(Emplacement emplacement : imp.liste()) {
			ligne[0] = String.valueOf(emplacement.getId()) ;
			ligne[1] = String.valueOf(emplacement.getAbscisse());
			ligne[2] = emplacement.getOrdonne();
			ligne[3] = String.valueOf(emplacement.getNombreLot());
			model.addRow(ligne);
			}
			table.setModel(model);
		}catch (Exception e) {
			e.getMessage(); 
		}
	}
}
