package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import persistence.AttestationStatusResidence;
import services.interfaces.ASRServiceRemote;

/**
 * Session Bean implementation class ASRService
 */
@Stateless
@LocalBean
public class ASRService implements ASRServiceRemote {
	@PersistenceContext
	private EntityManager em;

	public ASRService() {

	}

	@Override
	public List<AttestationStatusResidence> getAll() {

		return em.createQuery("SELECT asr FROM AttestationStatusResidence asr",
				AttestationStatusResidence.class).getResultList();
	}

	@Override
	public AttestationStatusResidence getById(Integer id) {
		return em
				.createQuery(
						"SELECT asr FROM AttestationStatusResidence asr WHERE asr.id = :param",
						AttestationStatusResidence.class)
				.setParameter("param", id).getSingleResult();
	}

	@Override
	public void update(AttestationStatusResidence asr) {
		em.merge(asr);

	}

	@Override
	public void add(AttestationStatusResidence asr) {
		em.persist(asr);

	}

	@Override
	public void delete(Integer id) {
		em.remove(em.find(AttestationStatusResidence.class, id));

	}

}
