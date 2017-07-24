package persistence;

import persistence.Citoyen;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CompteCourrant
 *
 */
@Entity
@Table(name = "egov_compte_courrant")
public class CompteCourrant implements Serializable {


	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer id;
	private Integer rib;
	private Float montant;
	private String codePostale;
	private String ville;
	private String pays;
	private Integer gsm;
	private String email;
	@ManyToOne
	private Citoyen citoyen;
	private static final long serialVersionUID = 1L;

	public CompteCourrant() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Integer getRib() {
		return this.rib;
	}

	public void setRib(Integer rib) {
		this.rib = rib;
	}   
	public Float getMontant() {
		return this.montant;
	}

	public void setMontant(Float montant) {
		this.montant = montant;
	}   
	public Citoyen getCitoyen() {
		return this.citoyen;
	}

	public void setCitoyen(Citoyen citoyen) {
		this.citoyen = citoyen;
	}
	public String getCodePostale() {
		return codePostale;
	}
	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public Integer getGsm() {
		return gsm;
	}
	public void setGsm(Integer gsm) {
		this.gsm = gsm;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
   
}
