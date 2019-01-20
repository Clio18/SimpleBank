package util;

import service.BankService;

import java.util.ArrayList;
import java.util.List;

public class ValidatorID {
    private final static String ID = "[0-9]+";

    public List<String> validation(String id) {
        List<String> alertList = new ArrayList<>();
        if (id.isEmpty()) {
            alertList.add("Enter the ID please!");
        }
        if (!id.matches(ID)) {
            alertList.add("Wrong ID!");
        }
        return alertList;
    }
}
