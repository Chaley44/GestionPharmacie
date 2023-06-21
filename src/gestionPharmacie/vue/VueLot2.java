package gestionPharmacie.vue;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import gestionPharmacie.dao.CreerConnexion;
import gestionPharmacie.domaine.Emplacement;
import gestionPharmacie.domaine.Lot;
import gestionPharmacie.domaine.Medicament;
import gestionPharmacie.service.EmplacementImp;
import gestionPharmacie.service.IMetier;
import gestionPharmacie.service.LotImp;
import gestionPharmacie.service.MedicamentImp;
import java.awt.event.MouseAdapter;

public class VueLot2 {

	private JFrame frame;
	private JTextField referenceField;
	private JTextField nombreMedicamentField;
	private JTable table;
	private JTextField datePeremptionField;
	private JTextField idMedicamentField;
	private JTextField idEmplacementField;
	
	public IMetier<Lot, Integer> imp = new LotImp();
	public LotImp impl = new LotImp();
	public IMetier<Medicament, Integer> impMedicament = new MedicamentImp();
	public IMetier<Emplacement, Integer> impEmplacement = new EmplacementImp();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueLot2 window = new VueLot2();
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
	public VueLot2() {
		initialize();
		ajouterTable();
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
		toolBar.setBounds(10, 72, 664, 16);
		frame.getContentPane().add(toolBar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 99, 664, 156);
		frame.getContentPane().add(panel_1);
		
		JLabel referenceLabel = new JLabel("Reference:");
		referenceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		referenceLabel.setBounds(10, 11, 73, 27);
		panel_1.add(referenceLabel);
		
		referenceField = new JTextField();
		referenceField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		referenceField.setColumns(10);
		referenceField.setBounds(133, 15, 140, 22);
		panel_1.add(referenceField);
		
		nombreMedicamentField = new JTextField();
		nombreMedicamentField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nombreMedicamentField.setColumns(10);
		nombreMedicamentField.setBounds(143, 69, 140, 22);
		panel_1.add(nombreMedicamentField);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lot lot = new Lot();
				
				lot.setReference(Integer.parseInt(referenceField.getText()) );
				lot.setNombreMedicament(Integer.parseInt(nombreMedicamentField.getText()));
				String date = datePeremptionField.getText();
				lot.setDatePeremption(LocalDate.parse(date));
				
				lot.setMedicament(impMedicament.getById(Integer.parseInt(idMedicamentField.getText())));
				lot.setEmplacement(impEmplacement.getById(Integer.parseInt(idEmplacementField.getText())));
				
				imp.creer(lot);
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(10, 124, 89, 23);
		panel_1.add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateActionPerformed(e);
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(122, 124, 89, 23);
		panel_1.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteActionPerformed(e);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(231, 124, 89, 23);
		panel_1.add(btnDelete);
		
		JLabel NombreMedicamentLabel = new JLabel("Nombre Medicament:");
		NombreMedicamentLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NombreMedicamentLabel.setBounds(10, 65, 131, 27);
		panel_1.add(NombreMedicamentLabel);
		
		JLabel datePeremptionLabel = new JLabel("Date Peremption:");
		datePeremptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		datePeremptionLabel.setBounds(351, 11, 109, 27);
		panel_1.add(datePeremptionLabel);
		
		datePeremptionField = new JTextField();
		datePeremptionField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		datePeremptionField.setColumns(10);
		datePeremptionField.setBounds(502, 15, 140, 22);
		panel_1.add(datePeremptionField);
		
		JLabel idMedicamentLabel = new JLabel("id Medicament:");
		idMedicamentLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idMedicamentLabel.setBounds(351, 49, 112, 27);
		panel_1.add(idMedicamentLabel);
		
		JLabel idEmplacementLabel = new JLabel("id emplacement:");
		idEmplacementLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idEmplacementLabel.setBounds(351, 86, 112, 27);
		panel_1.add(idEmplacementLabel);
		
		idMedicamentField = new JTextField();
		idMedicamentField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		idMedicamentField.setColumns(10);
		idMedicamentField.setBounds(502, 48, 140, 22);
		panel_1.add(idMedicamentField);
		
		idEmplacementField = new JTextField();
		idEmplacementField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		idEmplacementField.setColumns(10);
		idEmplacementField.setBounds(502, 90, 140, 22);
		panel_1.add(idEmplacementField);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableClickMouse(e);
			}
		});
		table.setBackground(Color.GRAY);
		table.setBounds(10, 256, 664, 147);
		frame.getContentPane().add(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(new Color(128, 255, 255));
		panel_2.setBounds(0, 414, 684, 41);
		frame.getContentPane().add(panel_2);
		
		JLabel bottomLabel = new JLabel("Gestion Lot");
		bottomLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bottomLabel.setBounds(259, 11, 144, 30);
		panel_2.add(bottomLabel);
	}
	
	public void btnUpdateActionPerformed(ActionEvent evt) {
		int i = table.getSelectedRow();
		if(i >= 0) {
			TableModel model1 = table.getModel();
			
			 String reference= model1.getValueAt(i, 0).toString();
			 if (table.getSelectedRows().length == 1) {
				 try {
						Lot lot = impl.getByReference(Integer.parseInt(reference));
						
						lot.setReference(Integer.parseInt(referenceField.getText()) );
						model1.setValueAt(referenceField.getText(), i, 0);
						lot.setNombreMedicament(Integer.parseInt(nombreMedicamentField.getText()));
						model1.setValueAt(nombreMedicamentField.getText(), i, 1);
						lot.setDatePeremption(LocalDate.parse( datePeremptionField.getText()));
						model1.setValueAt(datePeremptionField.getText(), i, 2);
						
						lot.setMedicament(impMedicament.getById(Integer.parseInt(idMedicamentField.getText())));
						model1.setValueAt(idMedicamentField.getText(), i, 3);
						lot.setEmplacement(impEmplacement.getById(Integer.parseInt(idEmplacementField.getText())));
						model1.setValueAt(idEmplacementField.getText(), i, 4);
						imp.modifier(lot);
					} catch (Exception e) {
						e.getMessage();
					} 
			 }
			
		}else {
			JOptionPane.showMessageDialog(null, "Erreur");
		}
	}
	public void btnDeleteActionPerformed(ActionEvent evt) {
		int i = table.getSelectedRow();
		if(i >= 0) {
			TableModel model = table.getModel();
			
			 String reference = model.getValueAt(i, 0).toString();
			 if (table.getSelectedRows().length == 1) {
				 try {
						Lot lot = impl.getByReference(Integer.parseInt(reference));
						
						imp.supprimer(lot);
					} catch (Exception e) {
						e.getMessage();
					} 
			 }
			
		}else {
			JOptionPane.showMessageDialog(null, "Erreur");
		}
	}
	
	public void addTable() {
		try {
			
			String [] tableLot = {"id", "reference", "nombreMedicament", "datePeremption",
					"idMedicament", "idEmplacement"};
			String [] ligne = new String[7];
			
			DefaultTableModel model = new DefaultTableModel(null, tableLot);
			for(Lot lot : imp.liste()) {
			ligne[0] = String.valueOf(lot.getId()) ;
			ligne[1] = String.valueOf(lot.getReference()) ;
			ligne[2] = String.valueOf(lot.getNombreMedicament());
			ligne[3] = lot.getDatePeremption().toString();
			ligne[4] = String.valueOf(lot.getMedicament().getId()) ;
			ligne[5] = String.valueOf(lot.getEmplacement().getId()) ;
			model.addRow(ligne);
			}
			table.setModel(model);
		}catch (Exception e) {
			e.getMessage(); 
		}
	}
	
	public void ajouterTable() {

		try {
			CreerConnexion connect = new CreerConnexion();
			String [] colonnes = {"reference", "nombreMedicament", "datePeremption",
					"idMedicament", "idEmplacement"};
			String [] ligne = new String[6];
			
			DefaultTableModel model = new DefaultTableModel(null, colonnes);
			
			//Creation de requete
			PreparedStatement ts = connect.getCon().prepareStatement(
					" select * from medicament");
			
			//Execute la requete
			ResultSet rs = ts.executeQuery();
			while(rs.next()) {
			ligne[0] = String.valueOf(rs.getInt("reference"));
			ligne[1] = String.valueOf(rs.getInt("nombreMedicament")) ;
			ligne[2] = rs.getDate("datePeremption").toString();
			ligne[3] = String.valueOf(rs.getInt("idMedicament"));
			ligne[4] = String.valueOf(rs.getInt("idEemplacement"));
			
			model.addRow(ligne);
			}
			table.setModel(model);
		}catch (Exception e) {
			e.getMessage(); 
		}
		
	}
	
	public void tableClickMouse(MouseEvent evt) {
		
		 int i = table.getSelectedRow();
	        TableModel model = table.getModel();
	        referenceField.setText(model.getValueAt(i, 0).toString());
	        nombreMedicamentField.setText(model.getValueAt(i, 1).toString());
	        datePeremptionField.setText(model.getValueAt(i, 2).toString());
	        idMedicamentField.setText(model.getValueAt(i, 3).toString());
	        idEmplacementField.setText(model.getValueAt(i, 4).toString());
	}
}
