package entity;

public class CreditAccount extends Account {
    private double withdraw;
    private double sum_rate;
    private int duration;

    public CreditAccount(int id, double money, int id_client, String type, int duration) {
        super(id, money, id_client, type, duration);
    }

    public CreditAccount(double money, int id_client, int duration) {
        super(money, id_client);
        this.duration = duration;
    }

    public CreditAccount(double money, int id_client, String type, int duration) {
        super(money, id_client, type);
        this.duration = duration;

    }

    public CreditAccount(int id, String type, double money, int duration, double sum_rate, double withdraw) {
        super(id, money, type);
        this.duration = duration;
        this.sum_rate = sum_rate;
        this.withdraw = withdraw;
    }

    public double getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(double withdraw) {
        this.withdraw = withdraw;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getSum_rate() {
        return sum_rate;
    }

    public void setSum_rate(double sum_rate) {
        this.sum_rate = sum_rate;
    }

    @Override
    public String toString() {
        return "Account: " +
                "account number is: " + this.getId() +
                " withdraw of credit - " + withdraw +
                ", type is " + this.getType() +
                ", sum_rate is " + sum_rate +
                ", duration is " + duration;
    }
}
