package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the loan_status_types database table.
 * 
 */
@Entity
@Table(name="loan_status_types")
@NamedQuery(name="LoanStatusType.findAll", query="SELECT l FROM LoanStatusType l")
public class LoanStatusType implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String description;
	private List<LoanStatusDate> loanStatusDates;

	public LoanStatusType() {
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


	//bi-directional many-to-one association to LoanStatusDate
	@OneToMany(mappedBy="loanStatusType")
	public List<LoanStatusDate> getLoanStatusDates() {
		return this.loanStatusDates;
	}

	public void setLoanStatusDates(List<LoanStatusDate> loanStatusDates) {
		this.loanStatusDates = loanStatusDates;
	}

	public LoanStatusDate addLoanStatusDate(LoanStatusDate loanStatusDate) {
		getLoanStatusDates().add(loanStatusDate);
		loanStatusDate.setLoanStatusType(this);

		return loanStatusDate;
	}

	public LoanStatusDate removeLoanStatusDate(LoanStatusDate loanStatusDate) {
		getLoanStatusDates().remove(loanStatusDate);
		loanStatusDate.setLoanStatusType(null);

		return loanStatusDate;
	}

}