package DAO;

// Generated 27 mai 2014 15:32:27 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Natureevenement generated by hbm2java
 */
public class Natureevenement implements java.io.Serializable {

	private Integer idevenement;
	private String libelle;
	private Set agendas = new HashSet(0);

	public Natureevenement() {
	}

	public Natureevenement(String libelle) {
		this.libelle = libelle;
	}

	public Natureevenement(String libelle, Set agendas) {
		this.libelle = libelle;
		this.agendas = agendas;
	}

	public Integer getIdevenement() {
		return this.idevenement;
	}

	public void setIdevenement(Integer idevenement) {
		this.idevenement = idevenement;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Set getAgendas() {
		return this.agendas;
	}

	public void setAgendas(Set agendas) {
		this.agendas = agendas;
	}

}
