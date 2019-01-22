package entity;

public class CreditAccount extends Account {
    private double withdraw;


    public CreditAccount(int id, double money, int id_client, String type) {
        super(id, money, id_client, type);
    }
}
