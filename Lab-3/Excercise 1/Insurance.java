abstract class Insurance {
    protected String type;
    protected double monthlyCost;

    public Insurance(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public abstract void setInsuranceCost(double cost);

    public abstract void displayInfo();
}
