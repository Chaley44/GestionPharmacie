package gestionPharmacie.vue;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Appli{


	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		VueConnection connexion = new VueConnection();
		connexion.setVisible(true);

	}

}
