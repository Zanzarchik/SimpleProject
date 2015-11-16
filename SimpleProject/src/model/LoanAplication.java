package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the loan_aplications database table.
 * 
 */
@Entity
@Table(name="loan_aplications")
@NamedQuery(name="LoanAplication.findAll", query="SELECT l FROM LoanAplication l")
public class LoanAplication implements Serializable {
	private static final long serialVersionUID = 1L;
	private LoanAplicationPK id;
	private Date date;
	private LoanProduct loanProduct;
	private Person person;

	public LoanAplication() {
	}


	@EmbeddedId
	public LoanAplicationPK getId() {
		return this.id;
	}

	public void setId(LoanAplicationPK id) {
		this.id = id;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	//bi-directional many-to-one association to LoanProduct
	@ManyToOne
	@JoinColumn(name="loan_products_id")
	public LoanProduct getLoanProduct() {
		return this.loanProduct;
	}

	public void setLoanProduct(LoanProduct loanProduct) {
		this.loanProduct = loanProduct;
	}


	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="persons_id")
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}