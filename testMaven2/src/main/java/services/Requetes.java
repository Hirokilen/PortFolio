package services;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entites.Employe;
import entites.Notif;

@Stateless
@LocalBean
public class Requetes {

	@PersistenceContext
    private EntityManager em;
	
	/** 
	 *  @param numIdent : Id de la personne recherché
	 *  @return  null si la liste est vide ou une liste d'une personne si elle est dans la base
	 *  
	**/
	public List<Employe> getUnePersonne(String numIdent){
    	Query query = em.createQuery("SELECT c FROM Employe c WHERE c.numIdent = \""+numIdent+"\"");
    	if(query.getResultList().isEmpty()){
    		return null;
    	}
    	return query.getResultList();
    }
	
	/** 
	 *  @param numIndu : Id de la notif recherché
	 *  @return  null si la liste est vide ou une liste d'une notif si elle est dans la base
	**/
	public List<Notif> getUneNotification(String numIndu){
    	Query query = em.createQuery("SELECT c FROM Notif c WHERE c.numIndu = \""+numIndu+"\"");
    	if(query.getResultList().isEmpty()){
    		return null;
    	}
    	return query.getResultList();
    }
	
	/** Retourne une liste d'employes avec les noms resemblant au nom envoyé dans l'input text
	 *  Retourne null si la liste est vide
	**/
	public List<Employe> getAllNom(String nom){
    	Query query = em.createQuery("SELECT DISTINCT c FROM Employe c WHERE c.nom LIKE \""+nom+"%\" ORDER BY c.nom");
    	if(query.getResultList().isEmpty()){
    		return null;
    	}
    	return query.getResultList();
    }
	/** Retourne une liste de tous les employers
	 *  Retourne null si la liste est vide
	**/
	public List<Employe> getListAll(){
		Query query = em.createQuery("SELECT DISTINCT c FROM Employe c ORDER BY c.nom");
    	query.setMaxResults(100);
    	if(query.getResultList().isEmpty()){
    		return null;
    	}
    	return query.getResultList();
    }
	
	public List<Notif> getNotifs(String numIdent){
		Query query = em.createQuery("SELECT c FROM Notif c WHERE c.numIdentFk.numIdent = \""+numIdent+"\"");
    	if(query.getResultList().isEmpty()){
    		return null;
    	}
    	return query.getResultList();
	}
	
	public List<Employe> getPersonneFromNotif(String numIndu){
		Query query = em.createQuery("SELECT c FROM Employe c WHERE c.numIdentFk.numIndu = \""+numIndu+"\"");
    	if(query.getResultList().isEmpty()){
    		return null;
    	}
    	return query.getResultList();
	}
}
