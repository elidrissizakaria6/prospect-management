package DAO;

// Generated 27 mai 2014 15:32:27 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Prospect generated by hbm2java
 */
public class Prospect implements java.io.Serializable {

	private Integer idProspect;
	private Statut statut;
	private String raisonsociale;
	private String raisonsocialeabrg;
	private String telephone;
	private String telephone2;
	private String fax;
	private String siteWeb;
	private String email;
	private String adresse;
	private String ville;
	private String pays;
	private String chiffreaffaire;
	private String activite;
	private String secteur;
	private Integer nombreeff;
	private Set representants = new HashSet(0);
	private Set agendas = new HashSet(0);
	private Set piecejoins = new HashSet(0);

	public Prospect() {
	}

	public Prospect(Statut statut, String raisonsociale,
			String raisonsocialeabrg, String telephone, String adresse,
			String ville, String pays) {
		this.statut = statut;
		this.raisonsociale = raisonsociale;
		this.raisonsocialeabrg = raisonsocialeabrg;
		this.telephone = telephone;
		this.adresse = adresse;
		this.ville = ville;
		this.pays = pays;
	}

	public Prospect(Statut statut, String raisonsociale,
			String raisonsocialeabrg, String telephone, String telephone2,
			String fax, String siteWeb, String email, String adresse,
			String ville, String pays, String chiffreaffaire, String activite,
			String secteur, Integer nombreeff, Set representants, Set agendas,
			Set piecejoins) {
		this.statut = statut;
		this.raisonsociale = raisonsociale;
		this.raisonsocialeabrg = raisonsocialeabrg;
		this.telephone = telephone;
		this.telephone2 = telephone2;
		this.fax = fax;
		this.siteWeb = siteWeb;
		this.email = email;
		this.adresse = adresse;
		this.ville = ville;
		this.pays = pays;
		this.chiffreaffaire = chiffreaffaire;
		this.activite = activite;
		this.secteur = secteur;
		this.nombreeff = nombreeff;
		this.representants = representants;
		this.agendas = agendas;
		this.piecejoins = piecejoins;
	}

	public Integer getIdProspect() {
		return this.idProspect;
	}

	public void setIdProspect(Integer idProspect) {
		this.idProspect = idProspect;
	}

	public Statut getStatut() {
		return this.statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public String getRaisonsociale() {
		return this.raisonsociale;
	}

	public void setRaisonsociale(String raisonsociale) {
		this.raisonsociale = raisonsociale;
	}

	public String getRaisonsocialeabrg() {
		return this.raisonsocialeabrg;
	}

	public void setRaisonsocialeabrg(String raisonsocialeabrg) {
		this.raisonsocialeabrg = raisonsocialeabrg;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelephone2() {
		return this.telephone2;
	}

	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getSiteWeb() {
		return this.siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getChiffreaffaire() {
		return this.chiffreaffaire;
	}

	public void setChiffreaffaire(String chiffreaffaire) {
		this.chiffreaffaire = chiffreaffaire;
	}

	public String getActivite() {
		return this.activite;
	}

	public void setActivite(String activite) {
		this.activite = activite;
	}

	public String getSecteur() {
		return this.secteur;
	}

	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}

	public Integer getNombreeff() {
		return this.nombreeff;
	}

	public void setNombreeff(Integer nombreeff) {
		this.nombreeff = nombreeff;
	}

	public Set getRepresentants() {
		return this.representants;
	}

	public void setRepresentants(Set representants) {
		this.representants = representants;
	}

	public Set getAgendas() {
		return this.agendas;
	}

	public void setAgendas(Set agendas) {
		this.agendas = agendas;
	}

	public Set getPiecejoins() {
		return this.piecejoins;
	}

	public void setPiecejoins(Set piecejoins) {
		this.piecejoins = piecejoins;
	}

}
