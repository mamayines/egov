package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import persistence.User;
import services.interfaces.UserServiceRemote;

/**
 * Session Bean implementation class UserService
 */
@Stateless
@LocalBean
public class UserService implements UserServiceRemote {

	@PersistenceContext
	private EntityManager em;

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<User> getAll() {

		return em.createQuery("SELECT u FROM User u", User.class)
				.getResultList();
	}

	@Override
	public void addUSer(User user) {
		em.persist(user);

	}

	@Override
	public void delete(String usernameSelected) {
		User userFound = em
				.createQuery("SELECT u FROM User u WHERE u.username = :param",
						User.class).setParameter("param", usernameSelected)
				.getSingleResult();
		em.remove(em.find(User.class, userFound.getId()));

	}

	@Override
	public User getUserById(Integer id) {
		return em.find(User.class, id);
	}

	@Override
	public void updateUser(User userSelected) {
		em.merge(userSelected);

	}

	@Override
	public void delete(Integer id) {
		User user= em.find(User.class, id);
		em.remove(user);
		
	}
}
