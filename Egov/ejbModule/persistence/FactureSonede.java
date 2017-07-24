package persistence;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: FactureSonede
 *
 */
@Entity

public class FactureSonede extends Facture implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public FactureSonede() {
		super();
	}
   
}
