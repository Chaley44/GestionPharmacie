package gestionPharmacie.vue;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.DefaultCaret;

import gestionPharmacie.dao.CreerConnexion;
import gestionPharmacie.domaine.Lot;
import gestionPharmacie.domaine.Medicament;
import gestionPharmacie.service.IMetier;
import gestionPharmacie.service.MedicamentImp;

public class VueMedicament2 {

	private JFrame frame;
	private JTextField nomMedicamentField;
	private JTextField stockAlerteField;
	private JTable tableMedicament;
	private JButton btnDelete;
	JButton btnUpdate;
	
	public IMetier<Medicament, Integer> imp = new MedicamentImp();
	public MedicamentImp impl = new MedicamentImp();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueMedicament2 window = new VueMedicament2();
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
	public VueMedicament2() {
		initialize();
		ajouterTable();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Gestion pharmacie");
		frame.setBounds(100, 100, 684, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 648, 60);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel titreLabel = new JLabel("GESTION PHARMACIE");
		titreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titreLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		titreLabel.setForeground(new Color(0, 0, 255));
		titreLabel.setBounds(10, 11, 628, 38);
		panel.add(titreLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 98, 413, 156);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel nomMedicamentLabel = new JLabel("Nom:");
		nomMedicamentLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nomMedicamentLabel.setBounds(10, 11, 57, 27);
		panel_1.add(nomMedicamentLabel);
		
		JLabel stockAlerteLabel = new JLabel("Stock Alerte:");
		stockAlerteLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		stockAlerteLabel.setBounds(10, 66, 95, 27);
		panel_1.add(stockAlerteLabel);
		
		nomMedicamentField = new JTextField();
		nomMedicamentField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nomMedicamentField.setBounds(98, 15, 140, 22);
		panel_1.add(nomMedicamentField);
		nomMedicamentField.setColumns(10);
		
		stockAlerteField = new JTextField();
		stockAlerteField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		stockAlerteField.setColumns(10);
		stockAlerteField.setBounds(98, 70, 140, 22);
		panel_1.add(stockAlerteField);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Medicament medicament = new Medicament();
					
					medicament.setNomMedicament(nomMedicamentField.getText());
					medicament.setQuantiteStock(imp.liste().size());
					medicament.setStockAlerte(Integer.parseInt(stockAlerteField.getText()));
					imp.creer(medicament);
					
				} catch (Exception e2) {
					e2.getMessage();
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(10, 124, 89, 23);
		panel_1.add(btnSave);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 btnUpdateActionPerformed(e);
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(122, 124, 89, 23);
		panel_1.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeleteActionPerformed(e);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(231, 124, 89, 23);
		panel_1.add(btnDelete);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(10, 71, 648, 16);
		frame.getContentPane().add(toolBar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 446, 463, -145);
		frame.getContentPane().add(scrollPane);
		
//		tableMedicament = addTable();
//		tableMedicament.setBounds(10, 256, 484, 147);
//		frame.getContentPane().add(tableMedicament);
//		tableMedicament.setBackground(Color.GRAY);
		
		tableMedicament = new JTable();
		tableMedicament.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableClickMouse(e);
			}
		});
		tableMedicament.setBounds(10, 256, 484, 147);
		tableMedicament.setModel(new DefaultTableModel(
				new Object [][] {

	            },
	            new String [] {
	            		"nomMedicament", "quantiteStock", "stockAlerte"
	            }
	        ) {
	            boolean[] canEdit = new boolean [] {
	                false, false, false
	            };

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        }
				);
		tableMedicament.setCellSelectionEnabled(true);
		
		frame.getContentPane().add(tableMedicament);
		tableMedicament.setBackground(Color.GRAY);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(new Color(128, 255, 255));
		panel_2.setBounds(0, 420, 668, 41);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel bottomLabel = new JLabel("Gestion Medicament");
		bottomLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bottomLabel.setBounds(243, 11, 144, 30);
		panel_2.add(bottomLabel);
	}
	
	public void btnDeleteActionPerformed(ActionEvent evt) {
		int i = tableMedicament.getSelectedRow();
		if(i >= 0) {
			TableModel model1 = tableMedicament.getModel();
			
			 String nomMedicament = model1.getValueAt(i, 0).toString();
			 if (tableMedicament.getSelectedRows().length == 1) {
				 try {
						Medicament medicament = impl.getByNom(nomMedicament);
						//model1.set
						imp.supprimer(medicament);
					} catch (Exception e) {
						e.getMessage();
					} 
			 }
			
		}else {
			JOptionPane.showMessageDialog(null, "Erreur");
		}
	}
	public void btnUpdateActionPerformed(ActionEvent evt) {
		int i = tableMedicament.getSelectedRow();
		if(i >= 0) {
			TableModel model1 = tableMedicament.getModel();
			
			 String nomMedicament = model1.getValueAt(i, 0).toString();
			 if (tableMedicament.getSelectedRows().length == 1) {
				 try {
						Medicament medicament = impl.getByNom(nomMedicament);
						
						medicament.setNomMedicament(nomMedicamentField.getText());
						model1.setValueAt(nomMedicamentField.getText(), i, 0);
						medicament.setQuantiteStock(imp.liste().size());
						medicament.setStockAlerte(Integer.parseInt(stockAlerteField.getText()));
						model1.setValueAt(stockAlerteField.getText(), i, 2);
						imp.modifier(medicament);
					} catch (Exception e) {
						e.getMessage();
					} 
			 }
			
		}else {
			JOptionPane.showMessageDialog(btnUpdate, "Erreur");
		}
	}
	
	public JTable addTable() {
		JTable table = new JTable();
		try {
			
			String [] colonnes = {"nomMedicament", "quantiteStock", "stockAlerte"};
			Object [][] listeMedicament = {};
			Object [] ligne = {};
			System.out.println(imp.liste());
			
//			DefaultTableModel model = new DefaultTableModel(null, colonnes);
//			for(Medicament medicament : imp.liste()) {
//				ligne[0] = medicament.getNomMedicament(), medicament.getQuantiteStock(),
//						medicament.getStockAlerte() ;
//			}
			//tableMedicament.setModel(model);
			table = new JTable(listeMedicament, colonnes);
		}catch (Exception e) {
			e.getMessage(); 
		}
		return table;
	}
	
	public void ajouterTable() {

		try {
			CreerConnexion connect = new CreerConnexion();
			String [] colonnes = {"nomMedicament", "quantiteStock", "stockAlerte"};
			String [] ligne = new String[4];
			
			DefaultTableModel model = new DefaultTableModel(null, colonnes);
			
			//Creation de requete
			PreparedStatement ts = connect.getCon().prepareStatement(
					" select * from medicament");
			
			//Execute la requete
			ResultSet rs = ts.executeQuery();
			while(rs.next()) {
			ligne[0] = rs.getString("nomMedicament") ;
			ligne[1] = rs.getString("quantiteStock") ;
			ligne[2] = rs.getString("stockAlerte");
			
			model.addRow(ligne);
			}
			tableMedicament.setModel(model);
		}catch (Exception e) {
			e.getMessage(); 
		}
		
	}
	
	public void tableClickMouse(MouseEvent evt) {
		
		 int i = tableMedicament.getSelectedRow();
	        TableModel model = tableMedicament.getModel();
	        nomMedicamentField.setText(model.getValueAt(i, 0).toString());
	        stockAlerteField.setText(model.getValueAt(i, 2).toString());
	}
}
