package com.company.telephony;

import com.company.telephony.interfaces.*;

import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable{
    @Override
    public String browse(String site) {
        boolean isValidSite = Pattern.compile("\\d").matcher(site).find();
        if (isValidSite){
            return "Invalid URL!";
        }
        return String.format("Browsing: %s!", site);
    }

    @Override
    public String call(String number) {
        boolean isValidNumber = Pattern.compile("\\D").matcher(number).find();
        if (isValidNumber){
            return "Invalid number!";
        }
        return String.format("Calling... %s", number);
    }
}
