package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import persistence.Citoyen;
import persistence.EtatFacture;
import persistence.Facture;
import persistence.FactureSonede;
import persistence.FactureSteg;
import services.interfaces.FactureServiceRemote;

/**
 * Session Bean implementation class FactureService
 */
@Stateless
@LocalBean
public class FactureService implements FactureServiceRemote {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public FactureService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addFacture(Facture facture) {
		em.persist(facture);
		
	}

	@Override
	public void addFacture(Facture facture,Integer idCitoyen) {
		Citoyen citoyen=em.find(Citoyen.class, idCitoyen);
		facture.setCitoyen(citoyen);
		em.persist(facture);
		
	}

	@Override
	public void updateFacture(Facture facture) {
		em.merge(facture);
		
	}

	@Override
	public List<FactureSonede> getFactureSonede() {
		return em.createQuery("SELECT c FROM FactureSonede c", FactureSonede.class)
				.getResultList();
	}

	@Override
	public List<FactureSteg> getFactureSteg() {
		return em.createQuery("SELECT c FROM FactureSteg c", FactureSteg.class)
				.getResultList();
	}

	@Override
	public void removeFacture(Facture facture) {
		em.remove(em.merge(facture));
		
	}

	@Override
	public Facture findById(Integer id) {
		return em.find(Facture.class, id);
	}

	@Override
	public void removeFacture(Integer id) {
		Facture facture = em.find(Facture.class, id);
		em.remove(facture);
		
	}

	@Override
	public void payerFacture(Integer id) {
		Facture facture = em.find(Facture.class, id);
		facture.setEtat(EtatFacture.PAYER);
		em.merge(facture);
	}

}
