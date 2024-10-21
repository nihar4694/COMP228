class Health extends Insurance {

    public Health() {
        super("Health Insurance");
    }

    @Override
    public void setInsuranceCost(double cost) {
        this.monthlyCost = cost;
    }

    @Override
    public void displayInfo() {
        System.out.println("Insurance Type: " + getType());
        System.out.println("Monthly Cost: $" + getMonthlyCost());
    }
}
