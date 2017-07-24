package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import persistence.Citoyen;
import persistence.ContratMariage;
import persistence.ExtraitNaissance;
import services.interfaces.ContratMariageServiceRemote;

/**
 * Session Bean implementation class ContratMariageService
 */
@Stateless
@LocalBean
public class ContratMariageService implements ContratMariageServiceRemote {

	@PersistenceContext
	private EntityManager em;

	public ContratMariageService() {

	}

	@Override
	public List<ContratMariage> getALl() {

		return em.createQuery("SELECT cm FROM ContratMariage cm",
				ContratMariage.class).getResultList();
	}

	@Override
	public void addContratMariage(ContratMariage contratMariage) {
		em.persist(contratMariage);

	}

	@Override
	public void deleteContratMariage(Integer id) {
		em.remove(em.find(ContratMariage.class, id));

	}

	@Override
	public void saveContratMariage(ContratMariage contratMariage) {
		em.merge(contratMariage);

	}

	@Override
	public void addContrat(ContratMariage contrat, Integer idCitoyen) {
		Citoyen citoyen=em.find(Citoyen.class, idCitoyen);
		contrat.setMari(citoyen);
		contrat.setFemme(citoyen);
		em.persist(contrat);
		
	}

	@Override
	public List<ContratMariage> getAll() {
		return em.createQuery("SELECT en FROM ContratMariage en",
				ContratMariage.class).getResultList();	}

	@Override
	public void delete(Integer id) {
		em.remove(em.merge(em.find(ContratMariage.class, id)));
		
	}

}
