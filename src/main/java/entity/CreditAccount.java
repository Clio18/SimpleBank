package entity;

public class CreditAccount extends Account {
    private double withdraw;
    private double sumRate;
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

    public CreditAccount(int id, double money, String type, double sumRate, int duration, double withdraw) {
        super(id, money, type);
        this.duration = duration;
        this.sumRate = sumRate;
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

    public double getSumRate() {
        return sumRate;
    }

    public void setSumRate(double sumRate) {
        this.sumRate = sumRate;
    }

    @Override
    public String toString() {
        return "Account: " +
                "account number is: " + this.getId() +
                " withdraw of credit - " + withdraw +
                ", type is " + this.getType() +
                ", sumRate is " + sumRate +
                ", duration is " + duration;
    }
}
