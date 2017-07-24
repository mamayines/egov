package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import persistence.Bulletin;
import persistence.ExtraitNaissance;

@Remote
public interface ExtraitNaissanceServiceRemote {
	public List<ExtraitNaissance> getAll();
	public void addExtraitNaissance(ExtraitNaissance extraitNaissance);
	public void deleteExtraitNaissance(Integer id);
	public void saveExtraitNaissance(ExtraitNaissance extraitNaissance);
	public void delete(Integer id);
	public ExtraitNaissance getById(Integer id);
	public void update(ExtraitNaissance ex);

}
