public abstract class Mortgage implements MortgageConstants {
    private int mortgageNumber;
    private String customerName;
    private double amount;
    private double interestRate;
    private int term;

    public Mortgage(int mortgageNumber, String customerName, double amount, double interestRate, int term) {
        if (amount > MAX_MORTGAGE_AMOUNT) {
            throw new IllegalArgumentException("Mortgage amount cannot exceed $" + MAX_MORTGAGE_AMOUNT);
        }
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
        this.amount = amount;
        this.interestRate = interestRate;

        // Enforce valid term: Short-term (1 year) as default if term is not defined
        if (term != SHORT_TERM && term != MEDIUM_TERM && term != LONG_TERM) {
            this.term = SHORT_TERM;
        } else {
            this.term = term;
        }
    }

    void setInterestRate(double primeRate){};

    public String getMortgageInfo() {
        return "Bank Name: " + BANK_NAME +
                "\nMortgage Number: " + mortgageNumber +
                "\nCustomer Name: " + customerName +
                "\nMortgage Amount: $" + amount +
                "\nInterest Rate: " + interestRate + "%" +
                "\nTerm: " + term + " years" +
                "\nTotal Amount Owed: $" + calculateTotalAmountOwed();
    }

    public double calculateTotalAmountOwed() {
        return amount + (amount * (interestRate / 100) * term);
    }

    public int getTerm() {
        return term;
    }

    public double getAmount() {
        return amount;
    }
}
