package DAO;

// Generated 27 mai 2014 15:32:27 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Agenda generated by hbm2java
 */
public class Agenda implements java.io.Serializable {

	private Integer id;
	private Intervenant intervenant;
	private Natureevenement natureevenement;
	private Statut statut;
	private Prospect prospect;
	private Date dateHeuredebut;
	private String lieu;
	private Date dateHeureFin;
	private Set piecejoins = new HashSet(0);

	public Agenda() {
	}

	public Agenda(Statut statut, Date dateHeuredebut, String lieu,
			Date dateHeureFin) {
		this.statut = statut;
		this.dateHeuredebut = dateHeuredebut;
		this.lieu = lieu;
		this.dateHeureFin = dateHeureFin;
	}

	public Agenda(Intervenant intervenant, Natureevenement natureevenement,
			Statut statut, Prospect prospect, Date dateHeuredebut, String lieu,
			Date dateHeureFin, Set piecejoins) {
		this.intervenant = intervenant;
		this.natureevenement = natureevenement;
		this.statut = statut;
		this.prospect = prospect;
		this.dateHeuredebut = dateHeuredebut;
		this.lieu = lieu;
		this.dateHeureFin = dateHeureFin;
		this.piecejoins = piecejoins;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Intervenant getIntervenant() {
		return this.intervenant;
	}

	public void setIntervenant(Intervenant intervenant) {
		this.intervenant = intervenant;
	}

	public Natureevenement getNatureevenement() {
		return this.natureevenement;
	}

	public void setNatureevenement(Natureevenement natureevenement) {
		this.natureevenement = natureevenement;
	}

	public Statut getStatut() {
		return this.statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Prospect getProspect() {
		return this.prospect;
	}

	public void setProspect(Prospect prospect) {
		this.prospect = prospect;
	}

	public Date getDateHeuredebut() {
		return this.dateHeuredebut;
	}

	public void setDateHeuredebut(Date dateHeuredebut) {
		this.dateHeuredebut = dateHeuredebut;
	}

	public String getLieu() {
		return this.lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Date getDateHeureFin() {
		return this.dateHeureFin;
	}

	public void setDateHeureFin(Date dateHeureFin) {
		this.dateHeureFin = dateHeureFin;
	}

	public Set getPiecejoins() {
		return this.piecejoins;
	}

	public void setPiecejoins(Set piecejoins) {
		this.piecejoins = piecejoins;
	}

}
