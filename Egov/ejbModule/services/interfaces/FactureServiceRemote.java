package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import persistence.Facture;
import persistence.FactureSonede;
import persistence.FactureSteg;

@Remote
public interface FactureServiceRemote {

	void addFacture(Facture facture);
	void addFacture(Facture facture,Integer idCitoyen);
	void updateFacture(Facture facture);
	List<FactureSonede> getFactureSonede();
	List<FactureSteg> getFactureSteg();
	void removeFacture(Facture facture);
	void removeFacture(Integer id);
	void payerFacture(Integer id);
	Facture findById(Integer id);
	
	
}
