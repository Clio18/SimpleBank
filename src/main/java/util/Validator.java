package util;

import entity.Client;
import service.BankService;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    private final static String NAME = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
    //from 4 to 8 and at least one digit
    private final static String PASSWORD = "^(?=.*\\d)(?=.*[a-zA-Z]).{4,8}$";

    public List<String> validation(Client client){
        List<String> alertList = new ArrayList<>();
        if(!client.getName().matches(NAME)){
            alertList.add("Wrong name!");
        }
        if(!client.getLastName().matches(NAME)){
            alertList.add("Wrong last name!");
        }
        if (!client.getLogin().matches(NAME)){
            alertList.add("Wrong login!");
        }
        if (!client.getPassword().matches(PASSWORD)){
            alertList.add("Wrong password");
        }
        return alertList;
    }
}
