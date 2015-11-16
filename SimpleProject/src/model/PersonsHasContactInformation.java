package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the persons_has_contact_informations database table.
 * 
 */
@Entity
@Table(name="persons_has_contact_informations")
@NamedQuery(name="PersonsHasContactInformation.findAll", query="SELECT p FROM PersonsHasContactInformation p")
public class PersonsHasContactInformation implements Serializable {
	private static final long serialVersionUID = 1L;
	private PersonsHasContactInformationPK id;

	public PersonsHasContactInformation() {
	}


	@EmbeddedId
	public PersonsHasContactInformationPK getId() {
		return this.id;
	}

	public void setId(PersonsHasContactInformationPK id) {
		this.id = id;
	}

}