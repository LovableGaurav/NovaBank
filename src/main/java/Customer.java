public class Customer extends Person  {
    int accountNumber;
    int balance;
    boolean loanTaken;
    int salary;

    @Override
    public void displayDetails() {
        System.out.println("Account Number :"+ accountNumber);
        System.out.println("Balance :"+ balance);
        System.out.println("Loan Taken :"+isLoanTaken());
        System.out.println("Salary :"+ salary);
        System.out.println("PersonId : "+ getPersonId());
        System.out.println("Name :"+ getName() );
        System.out.println("PhoneNumber :"+getPhoneNumber());

    }

    public Customer(int personId, String name, int phoneNumber, int accountNumber, int balance, boolean loanTaken, int salary) {
        super(personId, name, phoneNumber);
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.loanTaken = loanTaken;
        this.salary = salary;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isLoanTaken() {
        return loanTaken;
    }

    public void setLoanTaken(boolean loanTaken) {
        this.loanTaken = loanTaken;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
