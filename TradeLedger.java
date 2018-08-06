package sample;

import java.util.LinkedList;

public class TradeLedger  {

     private static final LinkedList<String> ordersHistory = new LinkedList<>();

     static void addOrder(String tradeLog) {
                ordersHistory.add(tradeLog);
        }

}
