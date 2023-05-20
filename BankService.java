// Interface Segregation.

// With problems :

public interface BankService {
    public void deposit(long accountNumber, double amount);
    public void withdrawal(long accountNumber, double amount);

    public void createAccount(String customerId, String accountType);
    public void closeAccount(long accountNumber);

    public void createCustomer(String name, String address);
    public void deleteCustomer(long customerId);
}

class ATM {
    /*
        The problem is that the ATM class has access to methods that can creates customers and accounts.
        Things that the ATM should never have to be concerned with.
        That Violates the Interface Segregation.
        ----
        If we decide to change how create customers (Like add new param), it means that all other classes that depend on BankService 
        would have to be recompiled, and redeployed even thought it doesn't care about the logic.
    
     */ 
    private BankService bankService;

    public void deposit(long accountNumber, double amount) {
        bankService.deposit(accountNumber, amount);
    }

    
    public void withdrawal(long accountNumber, double amount) {
        bankService.withdrawal(accountNumber, amount);
    }
}

// The Solution

interface TransactionService {
    public void deposit(long accountNumber, double amount);
    public void withdrawal(long accountNumber, double amount);
}


interface AccountService {
    public void createAccount(String customerId, String accountType);
    public void closeAccount(long accountNumber);
}


interface CustomerService {
    public void createCustomer(String name, String address);
    public void deleteCustomer(long customerId);
}

class ATM2 {
    private TransactionService transactionService;

    public void deposit(long accountNumber, double amount) {
        transactionService.deposit(accountNumber, amount);
    }

    
    public void withdrawal(long accountNumber, double amount) {
        transactionService.withdrawal(accountNumber, amount);
    }
}

// End Solution.
