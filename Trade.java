package sample;

import java.util.Map;

public class Trade {
    private int executionID = 0;

    public void matching() {
        OrderBooks.orderBuy.forEach((idB, B) -> {
            //делаем проверку на лучшую цену продажи и совершаем сделкку
            if(B!=null && bestSellPrice(OrderBooks.orderSell, B)!=null) {
                executionID++;
                operate(B, bestSellPrice(OrderBooks.orderSell, B));
                if(B==null)return;

            }
        });
    }


     private Order bestSellPrice(Map<Integer, Order> map, Order orderBuy) {
         int minPrice = Integer.MAX_VALUE;
         Order orderSell = null;
         for (Order order:
              map.values()) {
             if(order != null && order.getPrice()< minPrice && canTrade(orderBuy, order)) {
                 minPrice = order.getPrice();
                 orderSell = order;
             }
         }

         return orderSell;
     }

     private boolean canTrade(Order B, Order S) {
         return B.getPrice() >= S.getPrice() && B.getName().equals(S.getName());
     }
    
     private void operate(Order b, Order s) {

        int realizableQuantity = Math.min(b.getQuantity(), s.getQuantity());

        TradeLedger.addOrder(b.toString());
        TradeLedger.addOrder(s.toString());

        String tradeLog = "New execution with ID " + executionID + ": " + b.getName() + " " + s.getPrice() + " @ " + realizableQuantity + " (orders " + b.getId() + " and " + s.getId();
        System.out.println(tradeLog);

        //Меняем колличество в соответствии с остатком по сделке,  отменяем заказ если колличество = 0
         
             if (b.getQuantity() <= realizableQuantity) {
                 OrderBooks.cancelOrder(b);
             } else if (b.getQuantity() > realizableQuantity) {
                 b.setQuantity(b.getQuantity() - realizableQuantity);
             }
         

         
             if (s.getQuantity() <= realizableQuantity) {
                 OrderBooks.cancelOrder(s);
             } else if (s.getQuantity() > realizableQuantity) {
                 s.setQuantity(s.getQuantity() - realizableQuantity);
             }
         
    }
}
