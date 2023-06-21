package gestionPharmacie.service;

import java.util.List;

public interface IMetier<T, U> {

	List<T> liste();
	void creer(T o);
	void supprimer(T o);
	void modifier(T o);
	T getById(U id);

}