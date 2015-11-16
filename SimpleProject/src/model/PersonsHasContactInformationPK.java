package model;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
@Access(value=AccessType.PROPERTY)
public class PersonsHasContactInformationPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int personId;
	private int contactInformationId;
	
	@Column(name="persons_id")
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	
	@Column(name="contact_informations_id")
	public int getContactInformationId() {
		return contactInformationId;
	}
	public void setContactInformationId(int contactInformationId) {
		this.contactInformationId = contactInformationId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + contactInformationId;
		result = prime * result + personId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PersonsHasContactInformationPK))
			return false;
		PersonsHasContactInformationPK other = (PersonsHasContactInformationPK) obj;
		if (contactInformationId != other.contactInformationId)
			return false;
		if (personId != other.personId)
			return false;
		return true;
	} 

}
