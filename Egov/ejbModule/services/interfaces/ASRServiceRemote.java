package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import persistence.AttestationStatusResidence;

@Remote
public interface ASRServiceRemote {
	public List<AttestationStatusResidence> getAll();

	public AttestationStatusResidence getById(Integer id);

	public void update(AttestationStatusResidence asr);

	public void add(AttestationStatusResidence asr);

	public void delete(Integer id);
}
