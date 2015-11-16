package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contact_informations database table.
 * 
 */
@Entity
@Table(name="contact_informations")
@NamedQuery(name="ContactInformation.findAll", query="SELECT c FROM ContactInformation c")
public class ContactInformation implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String information;
	private InformationType informationType;

	public ContactInformation() {
	}


	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getInformation() {
		return this.information;
	}

	public void setInformation(String information) {
		this.information = information;
	}


	//bi-directional many-to-one association to InformationType
	@ManyToOne
	@JoinColumn(name="information_types_id")
	public InformationType getInformationType() {
		return this.informationType;
	}

	public void setInformationType(InformationType informationType) {
		this.informationType = informationType;
	}

}