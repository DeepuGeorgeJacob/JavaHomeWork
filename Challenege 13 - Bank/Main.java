import bank.Bank;
import bank.BankCustomer;
import bank.BankAccount;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create bank instance
        Bank bank = new Bank(123456);

        // Step 2: Add a customer
        bank.addCustomer("Alice", 1000.0, 5000.0);

        // Step 3: Retrieve customer by ID
        String customerId = String.format("%015d", 10_000_000); // First customer ID based on your logic
        BankCustomer customer = bank.getCustomer(customerId);

        if (customer != null) {
            System.out.println("Customer Details:");
            System.out.println(customer);

            // Step 4: Review an account (e.g., checking) — via defensive copy
            BankAccount checkingAccount = customer.getAccount(BankAccount.AccountType.CHECKING);
            System.out.println("Checking Account Balance: €" + checkingAccount.getBalance());

            // Step 5: Perform a withdrawal through the bank
            System.out.println("\nPerforming a withdrawal of €200 from CHECKING:");
            bank.doTransaction(customerId, BankAccount.AccountType.CHECKING, 200.0);

            // Step 6: Check balance again (need to refetch to reflect changes)
            checkingAccount = customer.getAccount(BankAccount.AccountType.CHECKING);
            System.out.println("Updated Checking Account Balance: €" + checkingAccount.getBalance());
        } else {
            System.out.println("Customer not found.");
        }
    }
}
