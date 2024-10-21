class PartTimeGameTester extends GameTester {
    private int hoursWorked;
    private final double hourlyRate = 20.0;

    public PartTimeGameTester(String name, int hoursWorked) {
        super(name, false);  // Part-time status is always false
        this.hoursWorked = hoursWorked;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public double determineSalary() {
        return hoursWorked * hourlyRate;  // Salary based on hours worked
    }
}
