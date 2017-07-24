package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import persistence.Citoyen;

@Remote
public interface CitoyenServiceRemote {

	public void addCitizen(Citoyen citoyen);

	public void deleteCitizen(Integer id);

	public void saveCitizen(Citoyen citoyen);

	public List<Citoyen> getAll();

	public Citoyen getCitizenById(Integer id);

}
