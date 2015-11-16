package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the information_types database table.
 * 
 */
@Entity
@Table(name="information_types")
@NamedQuery(name="InformationType.findAll", query="SELECT i FROM InformationType i")
public class InformationType implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String description;
	private List<ContactInformation> contactInformations;

	public InformationType() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	//bi-directional many-to-one association to ContactInformation
	@OneToMany(mappedBy="informationType")
	public List<ContactInformation> getContactInformations() {
		return this.contactInformations;
	}

	public void setContactInformations(List<ContactInformation> contactInformations) {
		this.contactInformations = contactInformations;
	}

	public ContactInformation addContactInformation(ContactInformation contactInformation) {
		getContactInformations().add(contactInformation);
		contactInformation.setInformationType(this);

		return contactInformation;
	}

	public ContactInformation removeContactInformation(ContactInformation contactInformation) {
		getContactInformations().remove(contactInformation);
		contactInformation.setInformationType(null);

		return contactInformation;
	}

}