import java.math.BigDecimal;

public class Loan {

protected int LoanId;
protected LoanType LoanType;
int principalAmount;
int rateofInterest;
int timesInYears;

    public Loan(int loanId, LoanType loanType, int principalAmount, int rateofInterest, int timesInYears) {
        LoanId = loanId;
        LoanType = loanType;
        this.principalAmount = principalAmount;
        this.rateofInterest = rateofInterest;
        this.timesInYears = timesInYears;
    }

    public int getLoanId() {
        return LoanId;
    }

    public void setLoanId(int loanId) {
        LoanId = loanId;
    }

    public LoanType getLoanType() {
        return LoanType;
    }

    public void setLoanType(LoanType loanType) {
        LoanType = loanType;
    }

    public int getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(int principalAmount) {
        this.principalAmount = principalAmount;
    }

    public int getRateofInterest() {
        return rateofInterest;
    }

    public void setRateofInterest(int rateofInterest) {
        this.rateofInterest = rateofInterest;
    }

    public int getTimesInYears() {
        return timesInYears;
    }

    public void setTimesInYears(int timesInYears) {
        this.timesInYears = timesInYears;
    }

    public void Calculate_simple_Intrest{
       BigDecimal Simple_Intrest = BigDecimal.valueOf((principalAmount * rateofInterest *timesInYears)/100);
    }
    public void Calculate_CompoundInterest{
        BigDecimal Compound_Interest = (principalAmount(1 + (rateofInterest) / 100) * * timesInYears) - principalAmount;
    }
}
