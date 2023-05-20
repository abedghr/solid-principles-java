// Open/Closed Principles

// With problems :
public class Account {
    private String accountNumber;
    private double balance;

    /* there is a problem in this method, whenever we want to add a new interest calculation, the account class has to be modified,
     and this is violation of the Open/Closed Principles (because it means that this class is not closed for modification.) */
    public double calculateInterest() {
        if(accountNumber.startsWith("000")) {
            return balance * 0.05;
        } else if (accountNumber.startsWith("001")) {
            return balance * 0.01;
        } else {
            return 0;
        }
    }
}


// The first solution :

abstract class Account1 {
    private String accountNumber;
    private double balance;

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public abstract double calculateInterest2();
}


class SavingAccounts extends Account1 {
    public double calculateInterest2() {
        return this.getBalance() * 0.05;
    }
}

class CurrentAccounts extends Account1 {
    public double calculateInterest2() {
        return this.getBalance() * 0.01;
    }
}

// End First Solution.


// The second Solution :

interface InterestCalculation {
    double calculateInterest2(double balance);
}

class SavingsInterestCalculation implements InterestCalculation {

    public double calculateInterest2(double balance) {
        return balance * 0.05;
    }
    
}

class CurrentInterestCalculation implements InterestCalculation {

    public double calculateInterest2(double balance) {
        return balance * 0.01;
    }
    
}

class Account2 {
    private double balance;
    
    public double calculateInterest(InterestCalculation inserCalc) {
        return inserCalc.calculateInterest2(balance);
        
    }
}

// End Second Solution.
