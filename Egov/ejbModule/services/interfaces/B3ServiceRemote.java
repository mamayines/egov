package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import persistence.Bulletin;

@Remote
public interface B3ServiceRemote {
	public Bulletin getById(Integer id);

	public List<Bulletin> getAll();

	public void addB3(Bulletin bulletin);

	public void update(Bulletin bulletin);

	public void delete(Integer id);
}
