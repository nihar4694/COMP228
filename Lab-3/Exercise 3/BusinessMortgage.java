public class BusinessMortgage extends Mortgage {
    public BusinessMortgage(int mortgageNumber, String customerName, double amount, double primeRate, int term) {
        super(mortgageNumber, customerName, amount, primeRate + 1, term);
    }

    @Override
    public void setInterestRate(double primeRate) {
        // Business mortgage interest rate is 1% over prime rate
        super.setInterestRate(primeRate + 1);
    }
}
