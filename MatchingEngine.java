package sample;

import java.lang.Thread;
import java.lang.InterruptedException;

public class MatchingEngine extends Thread {

    public static void main(String[] args) {
            System.out.println("Commands:");
            System.out.println("1. add / cancel - add or cancel an operation order");
            System.out.println("2. somethingString - orders name");
            System.out.println("3. S / B - sell or buy operation");
            System.out.println("4. somethingInteger - price");
            System.out.println("5. somethingInteger - quantity");
            new TradingGateway(new MatchingEngine());

    }

    public void run() {

            Trade trade = new Trade();
            while (!isInterrupted())
            {
                try
                {
                    sleep(1000);
                    trade.matching();

                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}

