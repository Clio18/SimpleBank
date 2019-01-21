package entity;

public class History {
    private String account_type;
    private Double money;
    private int id_client;
    private String date;
    private String message;

    public History(String account_type, Double money, int id_client, String date) {
        this.account_type = account_type;
        this.money = money;
        this.id_client = id_client;
        this.date = date;
    }

    public History(String account_type, Double money, String date, String message) {
        this.account_type = account_type;
        this.money = money;
        this.date = date;
        this.message = message;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Activity " +
                "account creation: " + account_type +
                ", money on account - " + money +
                ", date of action: " + date +
                ", message from BANK: " + message.toUpperCase();
    }
}
