package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import persistence.Bulletin;
import persistence.ExtraitNaissance;
import services.interfaces.ExtraitNaissanceServiceRemote;

/**
 * Session Bean implementation class ExtraitNaissanceService
 */
@Stateless
@LocalBean
public class ExtraitNaissanceService implements ExtraitNaissanceServiceRemote {

	@PersistenceContext
	private EntityManager em;

	public ExtraitNaissanceService() {

	}

	@Override
	public List<ExtraitNaissance> getAll() {

		return em.createQuery("SELECT en FROM ExtraitNaissance en",
				ExtraitNaissance.class).getResultList();
	}

	@Override
	public void addExtraitNaissance(ExtraitNaissance extraitNaissance) {
		em.persist(extraitNaissance);

	}

	@Override
	public void deleteExtraitNaissance(Integer id) {
		em.remove(em.merge(em.find(ExtraitNaissance.class, id)));

	}

	@Override
	public void saveExtraitNaissance(ExtraitNaissance extraitNaissance) {
		em.merge(extraitNaissance);

	}

	@Override
	public void delete(Integer id) {
		em.remove(em.find(ExtraitNaissance.class, id));
		
	}

	@Override
	public ExtraitNaissance getById(Integer id) {
		return em.find(ExtraitNaissance.class, id);
	}

	@Override
	public void update(ExtraitNaissance ex) {
		em.merge(ex);
	}

}
