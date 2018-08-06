package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TradingGateway {

    TradingGateway(MatchingEngine engine) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            engine.start();
            while(!engine.isInterrupted())
            {

                String query = reader.readLine();

                if (query.equals("") || !isCorrectQuery(query))
                {
                    throw new InterruptedException();
                }
                operateQuery(query);

            }

            reader.close();

        } catch(IOException | InterruptedException e) {e.printStackTrace();}

    }
    private boolean isCorrectQuery(String query)
    {
        String[] q = query.split(" ");

        return q[0].equals("add") || q[0].equals("cancel") || q[2].equals("S") || q[2].equals("B");
    }

    private void operateQuery(String query)
    {
        String q = query.split(" ")[0];
        Order order = new Order(query);

        if(q.equals("add"))
        {

            OrderBooks.addOrder(order);

        } else if (q.equals("cancel"))
        {

            OrderBooks.cancelOrder(order);
        }
    }

}
