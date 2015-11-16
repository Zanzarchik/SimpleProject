package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the loan_aplications database table.
 * 
 */
@Embeddable
public class LoanAplicationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private int id;
	private int personsId;
	private int loanProductsId;

	public LoanAplicationPK() {
	}

	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(name="persons_id", insertable=false, updatable=false)
	public int getPersonsId() {
		return this.personsId;
	}
	public void setPersonsId(int personsId) {
		this.personsId = personsId;
	}

	@Column(name="loan_products_id", insertable=false, updatable=false)
	public int getLoanProductsId() {
		return this.loanProductsId;
	}
	public void setLoanProductsId(int loanProductsId) {
		this.loanProductsId = loanProductsId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LoanAplicationPK)) {
			return false;
		}
		LoanAplicationPK castOther = (LoanAplicationPK)other;
		return 
			(this.id == castOther.id)
			&& (this.personsId == castOther.personsId)
			&& (this.loanProductsId == castOther.loanProductsId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.personsId;
		hash = hash * prime + this.loanProductsId;
		
		return hash;
	}
}