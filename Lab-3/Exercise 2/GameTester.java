abstract class GameTester {
    protected String name;
    protected boolean isFullTime;

    public GameTester(String name, boolean isFullTime) {
        this.name = name;
        this.isFullTime = isFullTime;
    }

    public String getName() {
        return name;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    // Abstract method to calculate salary
    public abstract double determineSalary();
}
