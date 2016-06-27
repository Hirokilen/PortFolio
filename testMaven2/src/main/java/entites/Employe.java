package entites;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
@Entity
@Table(name="View_notificationDEJ250")
public class Employe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@Column
	private String numIdent;
	
	@Column
	private String typeDestinataire;
	
	@Column
	private String dateNaissance;
	
	@Column
	private String rang;
	
	@Column
	private String civilite;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
	public String getNumIdent() {
		return numIdent;
	}

	public void setNumIdent(String numIdent) {
		this.numIdent = numIdent;
	}

	public String getTypeDestinataire() {
		return typeDestinataire;
	}

	public void setTypeDestinataire(String typeDestinataire) {
		this.typeDestinataire = typeDestinataire;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getRang() {
		return rang;
	}

	public void setRang(String rang) {
		this.rang = rang;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Notif> getNotifs() {
		return notifs;
	}

	public void setNotifs(List<Notif> notifs) {
		this.notifs = notifs;
	}

	@OneToMany(mappedBy="numIdentFk")
	  private List<Notif> notifs = new ArrayList<Notif>();
}