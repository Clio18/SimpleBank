package entity;

public class Account {
    private int id;
    private double money;
    private int id_client;
    private String type;
    private int duration;

    public Account(int id, double money, int id_client, String type, int duration) {
        this.id = id;
        this.money = money;
        this.id_client = id_client;
        this.type = type;
        this.duration=duration;
    }

    public Account(double money, int id_client, String type) {
        this.money = money;
        this.id_client = id_client;
        this.type = type;
    }

    public Account(double money, int id_client) {
        this.money = money;
        this.id_client = id_client;
    }

    public Account(int id, double money, String type) {
        this.id = id;
        this.money = money;
        this.type = type;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Account: " +
                "ID is " + id +
                ", money ----" + money +
                "----, id of the client is " + id_client +
                " type of request is " + type +
                " duration is " + duration;
    }


    public String toStringForShowUser() {
        return "Account: " +
                "account number is: " + id +
                ", money on it - " + money +
                ", type of account: " + type;
    }
}
