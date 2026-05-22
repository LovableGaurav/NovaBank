import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static final Map<Integer, Customer> customers = new HashMap<>();
    private static final List<Loan> loans = new ArrayList<>();
    private static final LinkedList<String> transactions = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        FileHandler.loadData(customers, loans, transactions);

        while (true) {

            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Create Loan");
            System.out.println("4. Calculate Simple Interest");
            System.out.println("5. Calculate Compound Interest");
            System.out.println("6. Deposit Money");
            System.out.println("7. Withdraw Money");
            System.out.println("11. Exit");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid input format. Please enter a number.");
                continue;
            }

            try {
                switch (choice) {
                    case 1: addCustomer(scanner); break;
                    case 2: viewCustomers(); break;
                    case 3: createLoan(scanner); break;
                    case 4: calculateSI(scanner); break;
                    case 5: calculateCI(scanner); break;
                    case 6: deposit(scanner); break;
                    case 7: withdraw(scanner); break;
                    case 11:
                        System.out.println("Saving execution data state...");
                        FileHandler.saveData(customers, loans);
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid Choice. Please selection an option from the menu.");
                }
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            }
        }
    }

    // 1. Add Customer
    private static void addCustomer(Scanner sc) {
        System.out.print("Enter Customer ID: ");
        int id = Integer.parseInt(sc.nextLine());
        if (customers.containsKey(id)) {
            System.out.println("ERROR: Customer ID already exists.");
            return;
        }
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();
        System.out.print("Enter Account Number: ");
        int accNum = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Initial Balance: ");
        double balance = Double.parseDouble(sc.nextLine());
        System.out.print("Enter Monthly Salary: ");
        double salary = Double.parseDouble(sc.nextLine());

        Customer customer = new Customer(PersonId, name, phoneNumber, AccountNumber, balance, salary, false);
        customers.put(Personid, customer);
        System.out.println("Customer Added Successfully.");
    }

    // 2. View Customers
    private static void viewCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customer records found.");
            return;
        }

        for (Customer c : customers.values()) {
            c.displayDetails();
        }
    }

    // 3. Create Loan
    private static void createLoan(Scanner sc) throws InvalidLoanException {
        System.out.print("Enter Customer ID: ");
        int cid = Integer.parseInt(sc.nextLine());
        Customer c = customers.get(cid);
        if (c == null) {
            System.out.println("ERROR: Customer not found.");
            return;
        }

        System.out.print("Enter Loan ID: ");
        String lid = sc.nextLine();
        System.out.print("Enter Loan Type: ");
        String type = sc.nextLine();
        System.out.print("Enter Principal Amount: ");
        double principal = Double.parseDouble(sc.nextLine());
        System.out.print("Enter Rate Of Interest: ");
        double rate = Double.parseDouble(sc.nextLine());
        System.out.print("Enter Time (Years): ");
        int years = Integer.parseInt(sc.nextLine());

        double maxLoan = 0;
        if (c.getSalary() < 25000) maxLoan = 200000;
        else if (c.getSalary() <= 50000) maxLoan = 500000;
        else maxLoan = 1000000;

        System.out.println("Salary = \u20B9" + c.getSalary());
        System.out.println("Eligible Loan = \u20B9" + maxLoan);

        if (principal > maxLoan) {
            throw new InvalidLoanException("Requested amount exceeds the approved loan eligibility ceiling limit!");
        }

        Loan loan = new Loan(PersonId, type, principal, rateofInterest, timesinYears);
        loans.add(loan);
        c.setLoanTaken(true);
        System.out.println("Loan Approved.");
        System.out.println("Loan Created Successfully.");

        String timestamp = new SimpleDateFormat("dd-MM-yyyy hh:mm a").format(new Date());
        String transLog = "[" + timestamp + "] Loan Created For Customer " + cid + " - Amount: \u20B9" + principal;
        transactions.add(transLog);
        FileHandler.logTransaction(transLog);
    }

    // 4. Calculate Simple Interest
    private static void calculateSI(Scanner sc) {
        System.out.print("Enter Principal Amount: ");
        double p = Double.parseDouble(sc.nextLine());
        System.out.print("Enter Rate: ");
        double r = Double.parseDouble(sc.nextLine());
        System.out.print("Enter Time: ");
        int t = Integer.parseInt(sc.nextLine());

        System.out.println(Calculate_Simple_Interest);
    }

    // 5. Calculate Compound Interest
    private static void calculateCI(Scanner sc) {
        System.out.print("Enter Principal Amount: ");
        double p = Double.parseDouble(sc.nextLine());
        System.out.print("Enter Rate: ");
        double r = Double.parseDouble(sc.nextLine());
        System.out.print("Enter Time: ");
        int t = Integer.parseInt(sc.nextLine());

        System.out.println(Calculate_Compound_Interest);
    }

    // 6. Deposit Money
    private static void deposit(Scanner sc) throws InvalidAmountException {
        System.out.print("Enter Account Number: ");
        int accNum = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Deposit Amount: ");
        double amount = Double.parseDouble(sc.nextLine());

        if (amount < 0) throw new InvalidAmountException("Amount cannot be negative.");

        for (Customer c : customers.values()) {
            if (c.getAccountNumber() == accNum) {
                c.setBalance(c.getBalance() + amount);
                System.out.println("\u20B9" + amount + " Deposited Successfully.");
                System.out.println("Updated Balance = \u20B9" + c.getBalance());

                String timestamp = new SimpleDateFormat("dd-MM-yyyy hh:mm a").format(new Date());
                String log = "[" + timestamp + "] Account " + accNum + " Deposited \u20B9" + amount;
                transactions.add(log);
                FileHandler.logTransaction(log);
                return;
            }
        }
        System.out.println("ERROR: Account number not linked to any active user.");
    }

    // 7. Withdraw Money
    private static void withdraw(Scanner sc) throws InvalidAmountException, InsufficientBalanceException {
        System.out.print("Enter Account Number: ");
        int accNum = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Withdraw Amount: ");
        double amount = Double.parseDouble(sc.nextLine());

        if (amount < 0) throw new InvalidAmountException("Amount cannot be negative.");

        for (Customer c : customers.values()) {
            if (c.getAccountNumber() == accNum) {
                if (amount > c.getBalance()) {
                    throw new InsufficientBalanceException("Cannot withdraw amount greater than balance.");
                }
                c.setBalance(c.getBalance() - amount);
                System.out.println("\u20B9" + amount + " Withdrawn Successfully.");
                System.out.println("Remaining Balance = \u20B9" + c.getBalance());

                String timestamp = new SimpleDateFormat("dd-MM-yyyy hh:mm a").format(new Date());
                String log = "[" + timestamp + "] Account " + accNum + " Withdrawn \u20B9" + amount;
                transactions.add(log);
                FileHandler.logTransaction(log);
                return;
            }
        }
        System.out.println("ERROR: Account location breakdown error.");
    }
}