class FullTimeGameTester extends GameTester {

    public FullTimeGameTester(String name) {
        super(name, true);  // Full-time status is always true
    }

    @Override
    public double determineSalary() {
        return 3000;  // Full-time base salary
    }
}
