package model;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="loan_status_dates")
@Access(value=AccessType.PROPERTY)
public class LoanStatusDate implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Date dateStatus;
	private LoanAplication loanAplicationId;
	private LoanStatusType loanStatusType;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="loan_status_types_id")
	public LoanStatusType getLoanStatusType() {
		return loanStatusType;
	}
	public void setLoanStatusType(LoanStatusType loanStatusType) {
		this.loanStatusType = loanStatusType;
	}
	
	@Column(name="date_status")
	public Date getDateStatus() {
		return dateStatus;
	}
	public void setDateStatus(Date dateStatus) {
		this.dateStatus = dateStatus;
	}
	
	@ManyToOne
	@JoinColumn(name="loan_aplications_id")
	public LoanAplication getLoanAplicationId() {
		return loanAplicationId;
	}
	public void setLoanAplicationId(LoanAplication loanAplicationId) {
		this.loanAplicationId = loanAplicationId;
	}
	
	
}
