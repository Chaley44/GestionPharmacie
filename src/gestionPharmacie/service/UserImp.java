package gestionPharmacie.service;

import java.util.List;

import gestionPharmacie.dao.DaoUser;
import gestionPharmacie.domaine.User;

public class UserImp implements IMetier<User, Integer> {

	private DaoUser daoUser = new DaoUser();
	
	@Override
	public List<User> liste() {
		// TODO Auto-generated method stub
		return daoUser.listerUser();
	}

	@Override
	public void creer(User o) {
		daoUser.creerUser(o);
		
	}

	@Override
	public void supprimer(User o) {
		daoUser.supprimerUser(o);
		
	}

	@Override
	public void modifier(User o) {
		daoUser.modifierUser(o);
		
	}

	@Override
	public User getById(Integer id) {
		for(User o : daoUser.listerUser()) {
			if(o.getId().equals(id)) {
				return o;
			}
		}
		return null;
	}
	
	public boolean seConnecter(String login, String password) {
		
		return daoUser.authentificationUser(login, password);
	}

}
