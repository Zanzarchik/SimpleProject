package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the persons database table.
 * 
 */
@Entity
@Table(name="persons")
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Date birthDate;
	private String firstname;
	private String inn;
	private String lastname;
	private String middlename;
	private List<LoanAplication> loanAplications;

	public Person() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="birth_date")
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getInn() {
		return this.inn;
	}

	public void setInn(String inn) {
		this.inn = inn;
	}


	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getMiddlename() {
		return this.middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}


	//bi-directional many-to-one association to LoanAplication
	@OneToMany(mappedBy="person")
	public List<LoanAplication> getLoanAplications() {
		return this.loanAplications;
	}

	public void setLoanAplications(List<LoanAplication> loanAplications) {
		this.loanAplications = loanAplications;
	}

	public LoanAplication addLoanAplication(LoanAplication loanAplication) {
		getLoanAplications().add(loanAplication);
		loanAplication.setPerson(this);

		return loanAplication;
	}

	public LoanAplication removeLoanAplication(LoanAplication loanAplication) {
		getLoanAplications().remove(loanAplication);
		loanAplication.setPerson(null);

		return loanAplication;
	}

}