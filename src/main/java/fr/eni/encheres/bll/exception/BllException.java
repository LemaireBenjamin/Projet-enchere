package fr.eni.encheres.bll.exception;

import java.util.ArrayList;
import java.util.List;

public class BllException extends Exception{
	
	private List<String> erreurs = new ArrayList<>();
	
	public BllException() {
		super();
	}
	
	public BllException(String message) {
		super(message);
	}
	
	public void ajouterErreur(String erreur) {
		erreurs.add(erreur);
	}
	
	//GETTERS & SETTERS
	@Override
	public String getMessage() {
		return super.getMessage();
	}

	public List<String> getErreurs() {
		return erreurs;
	}

	public void setErreurs(List<String> erreurs) {
		this.erreurs = erreurs;
	}
	
}
