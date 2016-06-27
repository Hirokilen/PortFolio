package bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entites.Employe;
import entites.Notif;
import services.Requetes;

/**
 * Session Bean implementation class AffichageBean
 */
@ManagedBean(name = "AffichageBean")
@SessionScoped
public class AffichageBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5315292112460337709L;

	@EJB
	Requetes requete;
	// Variables
	private String selected;
	private String result;
	private String erreur;
	private String exemple;
	private String numIdent;
	private String numIndu;
	private String nom;
	private List<Employe> allNom;
	private List<Employe> unePersonne;
	private List<Employe> allEmploye;
	private List<Employe> unePersonneSelected;
	private List<Notif> listeNotif;
	private List<Notif> uneNotif;
	private boolean ok_notifs = false;
	private boolean ok_infos = false;
	private boolean ok_nir = true;
	private int verifNir;
	private int recuNIR;
	private int recuClePS;
	private int maxLength=13;
	// Variables Pages
	private String pAffOne = "/pages/Affichage/AffichageUneSeulePersonne";
	private String pAffOneNotif = "/pages/Affichage/AffichageUneSeuleNotif";
	private String pAffNoms = "/pages/Affichage/AffichagePersonne";

	public AffichageBean() {

		// TODO Auto-generated constructor stub
		// Variable test :
		// 1504428537 <- ABBES SOPHIE numIndu
		// 0000064023732 <- ABBES SOPHIE numIdent
	}

	public void submit() {
		System.out.println("submit");
	}

	public void listener(AjaxBehaviorEvent event) {
		System.out.println("listener");
		setResult("called by" + event.getComponent().getClass().getName());
	}

	// DECLARATION DU RESULTAT EN FONCTION DE L'OBJET SELECTIONNE

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	// DECLARATION DE L'OBJET SELECTIONNER DANS LE SELECT

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	// DECLARATION DES MESSAGES D'ERREURS

	public String getErreur() {
		return erreur;
	}

	public void setErreur(String erreur) {
		this.erreur = erreur;
	}

	public String getExemple() {
		return exemple;
	}

	public void setExemple(String exemple) {
		this.exemple = exemple;
	}

	// DECLARATION NUMINDU

	public String getNumIndu() {
		return numIndu;
	}

	public void setNumIndu(String numIndu) {
		this.numIndu = numIndu;
	}

	// DECLARATION NUMIDENT

	public String getNumIdent() {
		return numIdent;
	}

	public void setNumIdent(String numIdent) {
		this.numIdent = numIdent.trim();
	}

	// DECLARATION DU NOM

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	// DECLARATION POUR LA LISTE PAR NOM

	public List<Employe> getAllNom() {
		return allNom;
	}

	public void setAllNom(List<Employe> allNom) {
		this.allNom = allNom;
	}

	public String listNoms() {
		try {
			if (requete.getAllNom(nom) != null) {
				setAllNom(requete.getAllNom(nom));
				return pAffNoms;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
	// DECLARATION INFORMATION DE LA PERSONNE QUI CORRESPOND AU NUMIDENT

	public List<Employe> getUnePersonne() {
		return unePersonne;
	}

	public void setUnePersonne(List<Employe> unePersonne) {
		this.unePersonne = unePersonne;
	}

	public String UnePersonne() {
		try {
			if (requete.getUnePersonne(numIdent) != null) {
				setUnePersonne(requete.getUnePersonne(numIdent));
				return pAffOne;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
	// DECLARATION INFORMATION SUR LES NOTIFS PAR RAPPORT A UN NUMIDENT

	public String UneListeNotifs() {
		try {
			if (requete.getUnePersonne(numIdent) != null) {
				setUnePersonne(requete.getUnePersonne(numIdent));
				return pAffOne;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	// DECLARATION INFORMATION DE LA PERSONNE SELECTIONNE

	public List<Employe> getUnePersonneSelected() {
		return unePersonneSelected;
	}

	public void setUnePersonneSelected(List<Employe> unePersonneSelected) {
		this.unePersonneSelected = unePersonneSelected;
	}

	public void UnePersonneSelected() {
		try {
			if (requete.getUnePersonne(selected) != null) {
				setUnePersonneSelected(requete.getUnePersonne(selected));
				setErreur("");
			} else {
			}
		} catch (Exception e) {
		}
	}
	// DECLARATION UNE NOTIF

	public List<Notif> getUneNotif() {
		return uneNotif;
	}

	public void setUneNotif(List<Notif> uneNotif) {
		this.uneNotif = uneNotif;
	}

	public String UneNotification() {
		try {
			if (requete.getUneNotification(numIndu) != null) {
				setUneNotif(requete.getUneNotification(numIndu));
				return pAffOneNotif;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
	// DECLARATION LISTE NOTIFS

	public List<Notif> getListeNotif() {
		return listeNotif;
	}

	public void setListeNotif(List<Notif> listeNotif) {
		this.listeNotif = listeNotif;
	}

	public void PersonneSelect() {
		try {
			if (requete.getUnePersonne(selected) != null) {
				setListeNotif(requete.getNotifs(selected));
			} else {
			}
		} catch (Exception e) {
		}
	}

	public void OnePersonne() {
		try {
			if (requete.getNotifs(numIdent) != null) {
				setListeNotif(requete.getNotifs(numIdent));
			} else {
			}
		} catch (Exception e) {
		}
	}
	// DECLARATION POUR LA LISTE COMPLETE

	public List<Employe> getAllEmploye() {
		return allEmploye;
	}

	public void setAllEmploye(List<Employe> allEmploye) {
		this.allEmploye = allEmploye;
	}

	public void OneNotif() {
		try {
			if (requete.getPersonneFromNotif(numIndu) != null) {
				setAllEmploye(requete.getPersonneFromNotif(numIndu));
			} else {
			}
		} catch (Exception e) {
		}
	}

	// DECLARATION POUR L'APPARITION DU COMPOSANT DE LA LISTE DE NOTIF

	public boolean isOk_notifs() {
		return ok_notifs;
	}

	public void setOk_notifs(boolean ok_notifs) {
		this.ok_notifs = ok_notifs;
	}

	public boolean isOk_infos() {
		return ok_infos;
	}

	public void setOk_infos(boolean ok_infos) {
		this.ok_infos = ok_infos;
	}

	public String hide() {
		ok_notifs = false;
		ok_infos = false;
		return ("");
	}

	public String nohide() {
		if (ok_notifs) {
			ok_notifs = false;
		} else {
			ok_notifs = true;
		}
		ok_infos = false;
		return ("");
	}

	public String nohide2() {
		if (ok_infos) {
			ok_infos = false;
		} else {
			ok_infos = true;
		}
		ok_notifs = false;
		return ("");
	}

	public void Active_nir() {
		if (ok_nir) {
			ok_nir = false;
			setNumIdent("");
			setMaxLength(15);
		} else {
			ok_nir = true;
			setNumIdent("");
			setMaxLength(13);
		}
		setErreur("");
		setRecuNIR(0);
	}
	
	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	// Affichage bouton valider si NIR correct
	public boolean isOk_nir() {
		return ok_nir;
	}

	public void setOk_nir(boolean ok_nir) {
		this.ok_nir = ok_nir;
	}

	// VERIFICATION DU NIR

	public int getVerifNir() {
		return verifNir;
	}

	public void setVerifNir(int verifNir) {
		this.verifNir = verifNir;
	}

	// CLE NIR INPUT

	public int getRecuNIR() {
		return recuNIR;
	}

	public void setRecuNIR(int recuNIR) {
		this.recuNIR = recuNIR;
	}

	// CLE PS INPUT
	public int getRecuClePS() {
		return recuClePS;
	}

	public void setRecuClePS(int recuClePS) {
		this.recuClePS = recuClePS;
	}

	public String Exemple() {
		setExemple(
				"abbes Mohamed : numIdent=1760999351320(TEST ASS) ||   Abbes Sophie : numIdent=000000064023732 (TEST PS)");
		return "";
	}

	// calcul et verification de la clé ps
	public String calculClePS() {
		String recupNumIdent = numIdent;
		long ps = Long.parseLong(recupNumIdent);
		int calculCle, chif1, chif2, chif3, chif4, chif5, chif6, chif7, chif8, sImpairs, Dchif2, Dchif4, Dchif6, Dchif8,
				DDchif2, DDchif4, DDchif6, DDchif8, sPairs, sTous, ssTous;
		chif1 = (int) (ps / Math.pow(10, 7));
		chif2 = (int) (ps / Math.pow(10, 6)) - 10 * (int) (ps / Math.pow(10, 7));
		chif3 = (int) (ps / Math.pow(10, 5)) - 10 * (int) (ps / Math.pow(10, 6));
		chif4 = (int) (ps / Math.pow(10, 4)) - 10 * (int) (ps / Math.pow(10, 5));
		chif5 = (int) (ps / Math.pow(10, 3)) - 10 * (int) (ps / Math.pow(10, 4));
		chif6 = (int) (ps / Math.pow(10, 2)) - 10 * (int) (ps / Math.pow(10, 3));
		chif7 = (int) (ps / 10) - 10 * (int) (ps / Math.pow(10, 2));
		chif8 = (int) (ps - 10 * (int) (ps / 10));
		sImpairs = chif1 + chif3 + chif5 + chif7;
		Dchif2 = chif2 * 2;
		Dchif4 = chif4 * 2;
		Dchif6 = chif6 * 2;
		Dchif8 = chif8 * 2;
		DDchif2 = (int) (Dchif2 / 10) + (Dchif2 - 10 * (int) (Dchif2 / 10));
		DDchif4 = (int) (Dchif4 / 10) + (Dchif4 - 10 * (int) (Dchif4 / 10));
		DDchif6 = (int) (Dchif6 / 10) + (Dchif6 - 10 * (int) (Dchif6 / 10));
		DDchif8 = (int) (Dchif8 / 10) + (Dchif8 - 10 * (int) (Dchif8 / 10));
		sPairs = DDchif2 + DDchif4 + DDchif6 + DDchif8;
		sTous = sPairs + sImpairs;
		ssTous = 10 - (sTous - 10 * (int) (sTous / 10));
		calculCle = ssTous - 10 * (int) (ssTous / 10);
		if (calculCle == recuClePS) {
			setErreur("clé Correct");
			return "";
		} else {
			System.out.println(calculCle);
			setErreur("clé Incorrect");
			return "";
		}
	}

	// Calcul et verification de la clé nir
	public String ValiderNIR() {
		try {
			String recupNumIdent = numIdent;
			if (recupNumIdent.substring(6, 7).equals("A")) {
				recupNumIdent = recupNumIdent.substring(0, 5) + "19" + recupNumIdent.substring(7);
			} else if (recupNumIdent.substring(6, 7).equals("B")) {
				recupNumIdent = recupNumIdent.substring(0, 5) + "18" + recupNumIdent.substring(7);
			}
			long nir = Long.parseLong(recupNumIdent);
			long result = nir % 97;
			result = 97 - result;
			if (result == recuNIR) {
				setErreur("clé Correct");
				return "";
			} else {
				System.out.println(result);
				setErreur("clé Incorrect");
				return "";
			}
		} catch (Exception e) {
			setErreur("Exception " + e);
			return "";
		}

	}
	
	public void blur(){
		
	}

}
