package sample;

import java.util.Date;

public class Order {


        private int price;
        private int quantity;
        private int id;
        private String name;
        private boolean operation; //Buy if "true" & Sell if "false"
        private Date date;

        public Order (String query) {
            String[] q = query.split(" ");

            setName(q[1]);

            if (q[2].equals("B")){
                setOperation(true);
            } else if (q[2].equals("S")){
                setOperation(false);
            }
            setPrice(Integer.parseInt(q[3]));
            setQuantity(Integer.parseInt(q[4]));
            setDate(new Date());

        }

        @Override
        public String toString() {
            String op = "Sell";
            if (getOperation()) {
                op = " Buy";
            }
            return "Order ID: " + getId()+ " Name: "+ getName() + " Price: " + getPrice() + " Quantity: " + getQuantity() + " Operation: " + op;
        }

        //Getters & Setters
        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public boolean getOperation() {
            return operation;
        }

        public void setOperation(boolean operation) {
            this.operation = operation;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
}
