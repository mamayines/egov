package persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: ContratMariage
 *
 */
@Entity
@Table(name = "egov_contra_mariage")
public class ContratMariage implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private Citoyen mari;
	@ManyToOne
	private Citoyen femme;
	private String description;
	private static final long serialVersionUID = 1L;

	public ContratMariage() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Citoyen getMari() {
		return this.mari;
	}

	public void setMari(Citoyen mari) {
		this.mari = mari;
	}   
	public Citoyen getFemme() {
		return this.femme;
	}

	public void setFemme(Citoyen femme) {
		this.femme = femme;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
   
}
