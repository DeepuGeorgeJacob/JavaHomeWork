package bank;

public class Transaction {
    private int routingNumber;
    private int customerId;
    private long transactionId;
    private double transactionAmount;

    public Transaction(
            double transactionAmount,
            long transactionId,
            int customerId,
            int routingNumber) {
        this.transactionAmount = transactionAmount;
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.routingNumber = routingNumber;
    }

    public int getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(int routingNumber) {
        this.routingNumber = routingNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
