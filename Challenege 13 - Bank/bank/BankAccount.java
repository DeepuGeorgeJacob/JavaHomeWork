package bank;

import java.util.Collections;
import java.util.Map;

public class BankAccount {

    public enum AccountType {CHECKING, SAVINGS}

    private final AccountType accountType;
    private final Map<Long, Transaction> transactions = Collections.emptyMap();

    private double balance;

    BankAccount(AccountType accountType, double balance) {
        this.accountType = accountType;
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void commitTransaction(final int routingNumber, long transactionId, String customerId, double amount) {
        final Transaction transaction = new Transaction(amount, transactionId, Integer.getInteger(customerId), routingNumber);
        transactions.put(transactionId, transaction);
        balance -= amount;

    }

    @Override
    public String toString() {
        return "%s €%.2f".formatted(accountType, balance);
    }

}