/*********************************************************
 File: Assignment5_Objective-2
 By: Antonio Gonzalez
 Date: 04/24/2024
 Description: To understand and implement the Command
        design pattern in Java by creating a
        BankAccountTransaction class to perform
        various transactions related to bank account(s)
 ********************************************************/


import java.time.LocalDateTime;
// BankAccountTransaction class
public class BankAccountTransaction {
    private String id;
    private LocalDateTime datetime;
    private String type;
    private double amount;
    private String description;
    private BankAccount sourceAccount;
    private BankAccount destinationAccount;
    private String status;
    private BankAccount account;
    private TransactionInterface transaction;

    public BankAccountTransaction(String id, String type, double amount, String description, BankAccount account) {
        this.id = id;
        this.datetime = LocalDateTime.now();
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.account = account;

        if (type.equalsIgnoreCase("deposit")) {
            this.transaction = new DepositTransaction(account, amount);
        } else if (type.equalsIgnoreCase("withdraw")) {
            this.transaction = new WithdrawTransaction(account, amount);
        } else {
            throw new IllegalArgumentException("Invalid transaction type");
        }

    }

    public void execute() {
        try {
            transaction.execute();
            this.status = "Successful";
        } catch (Exception e) {
            this.status = "Failed";
        }
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public BankAccount getSourceAccount() {
        return sourceAccount;
    }

    public BankAccount getDestinationAccount() {
        return destinationAccount;
    }

    public String getStatus() {
        return status;
    }

    public BankAccount getAccount() {
        return account;
    }
    //PrintTransactionDetails class
    public void printTransactionDetails() {
        System.out.println("Transaction Details:");
        System.out.println("ID: " + id);
        System.out.println("Date/Time: " + datetime);
        System.out.println("Type: " + type);
        System.out.println("Amount: " + amount);
        System.out.println("Description: " + description);
        System.out.println("Status: " + status);
        System.out.println("Account Number: " + account.getAccountNumber());
    }
}


// BankAccount class
 abstract class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    // Getter method for accountNumber
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter method for balance
    public double getBalance() {
        return balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);
}


// SavingsAccount class
 class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

// CheckingAccount class
 class CheckingAccount extends BankAccount {
    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

// TransactionInterface
 interface TransactionInterface {
    void execute();
}

// DepositTransaction class
 class DepositTransaction implements TransactionInterface {
    private BankAccount account;
    private double amount;

    public DepositTransaction(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.deposit(amount);
    }
}

// WithdrawTransaction class
 class WithdrawTransaction implements TransactionInterface {
    private BankAccount account;
    private double amount;

    public WithdrawTransaction(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.withdraw(amount);
    }
}
class Main {
    public static void main(String[] args) {
        // Create new bank accounts
        BankAccount antoniosAccount = new SavingsAccount("1234567", 5000.00);
        System.out.println("Created account for Antonio with account number: " + antoniosAccount.getAccountNumber() + " and initial balance: " + antoniosAccount.getBalance());

        BankAccount briansAccount = new CheckingAccount("7654321", 2000.00);
        System.out.println("Created account for Brian with account number: " + briansAccount.getAccountNumber() + " and initial balance: " + briansAccount.getBalance());

        // Create new transactions
        BankAccountTransaction antoniosDeposit = new BankAccountTransaction("1", "deposit", 1000.00, "Antonio's deposit", antoniosAccount);
        BankAccountTransaction briansWithdrawal = new BankAccountTransaction("2", "withdraw", 500.00, "Brian's withdrawal", briansAccount);

        // Execute the transactions
        antoniosDeposit.execute();
        briansWithdrawal.execute();

        // Print the transaction details
        antoniosDeposit.printTransactionDetails();
        System.out.println("Antonio's updated balance: " + antoniosAccount.getBalance());
        System.out.println("\n");
        briansWithdrawal.printTransactionDetails();
        System.out.println("Brian's updated balance: " + briansAccount.getBalance());
    }
}

//Sample output

/*
Created account for Antonio with account number: 1234567 and initial balance: 5000.0
Created account for Brian with account number: 7654321 and initial balance: 2000.0
Transaction Details:
ID: 1
Date/Time: 2024-04-24T23:26:19.290287
Type: deposit
Amount: 1000.0
Description: Antonio's deposit
Status: Successful
Account Number: 1234567
Antonio's updated balance: 6000.0


Transaction Details:
ID: 2
Date/Time: 2024-04-24T23:26:19.291588
Type: withdraw
Amount: 500.0
Description: Brian's withdrawal
Status: Successful
Account Number: 7654321
Brian's updated balance: 1500.0

Process finished with exit code 0
 */
