package bank;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final int routingNumber;
    private static long lastTransactionId;
    private Map<String, BankCustomer> customers = new HashMap<>();

    public Bank(final int routingNumber) {
        this.routingNumber = routingNumber;
    }

    public BankCustomer getCustomer(String id) {
        return customers.get(id);
    }

    public void addCustomer(String name, double checkingInitialDeposit, double savingsInitialDeposit) {
        final BankCustomer bankCustomer = new BankCustomer(name, checkingInitialDeposit, savingsInitialDeposit);
        customers.put(bankCustomer.getCustomerId(), bankCustomer);
    }

    public void doTransaction(String id, BankAccount.AccountType accountType, double amount) {
        lastTransactionId++;
        final BankCustomer customer = customers.get(id);
        final BankAccount account = customer.getAccount(accountType);
        if (amount <= account.getBalance()) {
            account.commitTransaction(routingNumber, lastTransactionId, id, amount);
        }
    }
}
