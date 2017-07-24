package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import persistence.Bulletin;
import services.interfaces.B3ServiceRemote;

/**
 * Session Bean implementation class B3Service
 */
@Stateless
@LocalBean
public class B3Service implements B3ServiceRemote {

	@PersistenceContext
	private EntityManager em;

	public B3Service() {

	}

	@Override
	public List<Bulletin> getAll() {

		return em.createQuery("SELECT b FROM Bulletin b", Bulletin.class)
				.getResultList();
	}

	@Override
	public void addB3(Bulletin bulletin) {
		em.persist(bulletin);

	}

	@Override
	public Bulletin getById(Integer id) {

		return em
				.createQuery("SELECT b FROM Bulletin b WHERE b.id = :param",
						Bulletin.class).setParameter("param", id)
				.getSingleResult();
	}

	@Override
	public void update(Bulletin bulletin) {
		em.merge(bulletin);

	}

	@Override
	public void delete(Integer id) {
		em.remove(em.find(Bulletin.class, id));

	}

}
