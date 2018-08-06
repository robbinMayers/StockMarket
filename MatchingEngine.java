package sample;

import java.lang.Thread;
import java.lang.InterruptedException;

public class MatchingEngine extends Thread {

    public static void main(String[] args) {

            new TradingGateway(new MatchingEngine());

    }

    public void run() {

            Trade trade = new Trade();
            while (!Thread.currentThread().isInterrupted())
            {
                try
                {
                    sleep(10000);
                    trade.trade();

                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }
}

