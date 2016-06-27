package entites;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="View_notificationDEJ250")
public class Notif implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private String numIndu;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column
	private String centre;
	
	@Column
	private String indicationLigne;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateNotif;
	
	@Column
	private float montantInitial;
	
	public String getNumIndu() {
		return numIndu;
	}

	public void setNumIndu(String numIndu) {
		this.numIndu = numIndu;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCentre() {
		return centre;
	}

	public void setCentre(String centre) {
		this.centre = centre;
	}

	public String getIndicationLigne() {
		return indicationLigne;
	}

	public void setIndicationLigne(String indicationLigne) {
		this.indicationLigne = indicationLigne;
	}

	public Date getDateNotif() {
		return dateNotif;
	}

	public void setDateNotif(Date dateNotif) {
		this.dateNotif = dateNotif;
	}

	public float getMontantInitial() {
		return montantInitial;
	}

	public void setMontantInitial(float montantInitial) {
		this.montantInitial = montantInitial;
	}

	public float getMontantSolde() {
		return montantSolde;
	}

	public void setMontantSolde(float montantSolde) {
		this.montantSolde = montantSolde;
	}

	public String getNumArchive() {
		return numArchive;
	}

	public void setNumArchive(String numArchive) {
		this.numArchive = numArchive;
	}

	public Employe getNumIdentFk() {
		return numIdentFk;
	}

	public void setNumIdentFk(Employe numIdentFk) {
		this.numIdentFk = numIdentFk;
	}

	@Column
	private float montantSolde;
	
	@Column
	private String numArchive;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="numIdent")
	private Employe numIdentFk ;
}