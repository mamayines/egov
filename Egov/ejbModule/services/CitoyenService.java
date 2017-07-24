package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import persistence.Citoyen;
import services.interfaces.CitoyenServiceRemote;

@Stateless
@LocalBean
public class CitoyenService implements CitoyenServiceRemote {

	@PersistenceContext
	private EntityManager em;

	public CitoyenService() {

	}

	@Override
	public void addCitizen(Citoyen citoyen) {
		em.persist(citoyen);
	}

	@Override
	public void deleteCitizen(Integer id) {
		em.remove(em.find(Citoyen.class, id));

	}

	@Override
	public void saveCitizen(Citoyen citoyen) {
		em.merge(citoyen);

	}

	@Override
	public List<Citoyen> getAll() {

		return em.createQuery("SELECT c FROM Citoyen c", Citoyen.class)
				.getResultList();
	}

	@Override
	public Citoyen getCitizenById(Integer id) {

		return em
				.createQuery("SELECT c FROM Citoyen c WHERE c.id = :param",
						Citoyen.class).setParameter("param", id)
				.getSingleResult();
	}

}
