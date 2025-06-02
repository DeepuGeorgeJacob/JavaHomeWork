package bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankCustomer {

    private static int lastCustomerId = 10_000_000;
    private final String name;
    private final int customerId;
    private final List<BankAccount> accounts = new ArrayList<>();

    public BankCustomer(String name, double checkingAmount, double savingsAmount) {
        this.name = name;
        this.customerId = lastCustomerId++;
        accounts.add(new BankAccount(BankAccount.AccountType.CHECKING, checkingAmount));
        accounts.add(new BankAccount(BankAccount.AccountType.SAVINGS, savingsAmount));
    }

    public String getName() {
        return name;
    }

    public List<BankAccount> getAccounts() {
        List<BankAccount> copy = new ArrayList<>();
        for (BankAccount account : accounts) {
            copy.add(new BankAccount(account.getAccountType(), account.getBalance()));
        }
        return copy;
    }

    public BankAccount getAccount(final BankAccount.AccountType type) {
        for (BankAccount account : accounts) {
            if (account.getAccountType() == type) {
                return new BankAccount(account.getAccountType(), account.getBalance()); // Defensive copy
            }
        }
        return null; // or throw exception if not found
    }

    @Override
    public String toString() {
        String[] accountStrings = new String[accounts.size()];
        Arrays.setAll(accountStrings, i -> accounts.get(i).toString());
        return "Customer: %s (id:%015d)%n\t%s%n".formatted(name, customerId,
                String.join("\n\t", accountStrings));
    }

    public String getCustomerId() {
        return String.format("%015d", customerId);
    }
}
