package sample;

public class Trade {
    private int executionID = 0;

    public void trade() {
        OrderBooks.orderBuy.forEach((idB, B) -> {
            if(B!=null) {

                OrderBooks.orderSell.forEach((idS, S) -> {
                    if(S!=null) {

                        if (canTrade(B, S)) {

                            executionID++;
                            operate(B, S);

                        }
                    }
                });
            }
        });
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


        if (b.getQuantity()<=realizableQuantity) {
            OrderBooks.cancelOrder(b);
        } else if (b.getQuantity()>realizableQuantity) {
            b.setQuantity(b.getQuantity()-realizableQuantity);
        }

        if (s.getQuantity()<=realizableQuantity) {
            OrderBooks.cancelOrder(s);
        } else if (s.getQuantity()>realizableQuantity) {
            s.setQuantity(s.getQuantity()-realizableQuantity);

        }
    }
}
