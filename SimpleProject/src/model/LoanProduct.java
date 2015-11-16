package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the loan_products database table.
 * 
 */
@Entity
@Table(name="loan_products")
@NamedQuery(name="LoanProduct.findAll", query="SELECT l FROM LoanProduct l")
public class LoanProduct implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private BigDecimal commonSum;
	private String description;
	private int durationWeek;
	private BigDecimal payPerWeek;
	private List<LoanAplication> loanAplications;

	public LoanProduct() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Column(name="common_sum")
	public BigDecimal getCommonSum() {
		return this.commonSum;
	}

	public void setCommonSum(BigDecimal commonSum) {
		this.commonSum = commonSum;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Column(name="duration_week")
	public int getDurationWeek() {
		return this.durationWeek;
	}

	public void setDurationWeek(int durationWeek) {
		this.durationWeek = durationWeek;
	}


	@Column(name="pay_per_week")
	public BigDecimal getPayPerWeek() {
		return this.payPerWeek;
	}

	public void setPayPerWeek(BigDecimal payPerWeek) {
		this.payPerWeek = payPerWeek;
	}


	//bi-directional many-to-one association to LoanAplication
	@OneToMany(mappedBy="loanProduct")
	public List<LoanAplication> getLoanAplications() {
		return this.loanAplications;
	}

	public void setLoanAplications(List<LoanAplication> loanAplications) {
		this.loanAplications = loanAplications;
	}

	public LoanAplication addLoanAplication(LoanAplication loanAplication) {
		getLoanAplications().add(loanAplication);
		loanAplication.setLoanProduct(this);

		return loanAplication;
	}

	public LoanAplication removeLoanAplication(LoanAplication loanAplication) {
		getLoanAplications().remove(loanAplication);
		loanAplication.setLoanProduct(null);

		return loanAplication;
	}

}