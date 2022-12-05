package flight.flightservice.utils;

import flight.flightservice.exception.InsufficientAmountException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {

    private static Map<String, Double> paymentMap=new HashMap<>();

    static {
        paymentMap.put("acc1", 27000.0);
        paymentMap.put("acc2", 10000.0);
        paymentMap.put("acc3", 120000.0);
        paymentMap.put("acc4", 8000.0);
    }

    public static boolean validateCreditLimit(String accNo, double paidAmount){
        if(paidAmount>paymentMap.get(accNo)){
            throw new InsufficientAmountException("Failed!! Insufficient Balance.");
        }else{
            return true;
        }
    }
}
