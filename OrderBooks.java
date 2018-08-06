package sample;

import java.util.HashMap;
import java.util.Map;

public class OrderBooks {

    private  static  int id = 1;
    public static final Map<Integer, Order> orderBuy = new HashMap<>();
    public static final Map<Integer, Order> orderSell = new HashMap<>();


    public static void addOrder(Order order) {
        String status;
        if(order.getId()>=1)
        {
            System.out.println("Changed order: " + order.getId());
        } else {
            order.setId(id++);
        }

        if (order.getOperation())
        {
            orderBuy.put(order.getId(), order);
            status = "Buy";

        } else {
            orderSell.put(order.getId(),order);
            status = "Sell";
        }
        TradeLedger.addOrder(order.toString());
        System.out.println("Order with ID " + order.getId() + " added: " + order.getName() + " " + status + " " + order.getPrice() + " @ " + order.getQuantity() );
    }

    public static void cancelOrder(Order order) {
        String status = "Sell";
        if (order.getOperation())status = "Buy";
        System.out.println("Order with ID " + order.getId() + " canceled: " + order.getName() + " " + status + " " + order.getPrice() + " @ " + order.getQuantity());
        if (order.getOperation()) {
            orderBuy.put(order.getId(), null);
        } else {
            orderSell.put(order.getId(),null);
        }
    }
}
