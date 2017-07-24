package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import persistence.ContratMariage;
import persistence.Facture;

@Remote
public interface ContratMariageServiceRemote {
	public List<ContratMariage> getALl();

	public void addContratMariage(ContratMariage contratMariage);

	public void deleteContratMariage(Integer id);

	public void saveContratMariage(ContratMariage contratMariage);
	
	void addContrat(ContratMariage contrat,Integer idCitoyen);

	public List<ContratMariage> getAll();

	public void delete(Integer id);


}
