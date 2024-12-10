public class PersonalMortgage extends Mortgage {
    public PersonalMortgage(int mortgageNumber, String customerName, double amount, double primeRate, int term)
    {
        super(mortgageNumber, customerName, amount, primeRate + 2, term);
    }

    @Override
    public void setInterestRate(double primeRate) {
        // Personal mortgage interest rate is 2% over prime rate
        super.setInterestRate(primeRate + 2);
    }
}
