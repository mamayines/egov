package persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Citoyen
 *
 */
@Entity
@Table(name = "egov_citoyens")
public class Citoyen implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cin;
	private String nom;
	private String prenom;
	private String etatCivile;
	private Character sex;
	private String profession;
	@OneToMany(mappedBy = "citoyen")
	private List<Facture> factures;
	@OneToMany(mappedBy = "citoyen")
	private List<CompteCourrant> compte;
	@OneToOne
	private Bulletin bulletin;
	@OneToOne
	private ExtraitNaissance extraitNaissance;
	@OneToOne
	private AttestationStatusResidence attestationStatusResidence;
	private static final long serialVersionUID = 1L;

	public Citoyen() {
		super();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEtatCivile() {
		return this.etatCivile;
	}

	public void setEtatCivile(String etatCivile) {
		this.etatCivile = etatCivile;
	}

	public Character getSex() {
		return this.sex;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public List<Facture> getFactures() {
		return factures;
	}

	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

	public List<CompteCourrant> getCompte() {
		return compte;
	}

	public void setCompte(List<CompteCourrant> compte) {
		this.compte = compte;
	}

	public Bulletin getBulletin() {
		return bulletin;
	}

	public void setBulletin(Bulletin bulletin) {
		this.bulletin = bulletin;
	}

	public ExtraitNaissance getExtraitNaissance() {
		return extraitNaissance;
	}

	public void setExtraitNaissance(ExtraitNaissance extraitNaissance) {
		this.extraitNaissance = extraitNaissance;
	}

	public AttestationStatusResidence getAttestationStatusResidence() {
		return attestationStatusResidence;
	}

	public void setAttestationStatusResidence(
			AttestationStatusResidence attestationStatusResidence) {
		this.attestationStatusResidence = attestationStatusResidence;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	@Override
	public String toString() {
		return nom+" "+prenom;
	}
	
	

}
