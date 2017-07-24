package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import persistence.User;
import services.interfaces.LoginServiceRemote;

@Stateless
@LocalBean
public class LoginService implements LoginServiceRemote {

	@PersistenceContext
	private EntityManager em;

	public LoginService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User authenticate(String login, String pwd) {
		try{
			return em
					.createQuery(
							"SELECT u FROM User u where u.username = :param1 and u.password = :param2",
							User.class).setParameter("param1", login)
					.setParameter("param2", pwd).getSingleResult();
		} catch (Exception ex) {
			return null;
		}
	}

}
