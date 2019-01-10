package entity;

public class DepositAccount extends Account {
    private double earnings;

    public DepositAccount(double money, double earnings) {
        super(money);
        this.earnings = earnings;
    }

    public double getEarnings() {
        return earnings;
    }

    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }
}
