package entities;

import enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;
    private List<OrderItem> list = new ArrayList<>();
    private Client client;

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client=client;
    }

    public void addItem(OrderItem item){
        list.add(item);
    }
    public void removeItem(OrderItem item){

        list.remove(item);
    }
    public double total(){
        double total =0;
        for(OrderItem it:list){
            total+=it.subTotal();
        }
        return total;
    }

    @Override
    public String toString()  {
        StringBuilder sb = new StringBuilder();
        String line= "";
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy hh:MM:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("(dd/MM/yyyy)");
        String now = sdf1.format(moment);
        String birthday = sdf2.format(client.getBirthDate());
        sb.append("ORDER SUMMARY:"+'\n');
        sb.append("Order moment: "+now+'\n');
        sb.append("Order status: "+status+'\n');
        sb.append("Client: "+this.client.getName()+" "+birthday);
        sb.append(" - "+client.getEmail()+"\n");
        sb.append("Order items:"+"\n");
        double total;
        double price=0;
        for(OrderItem it:list){
            total = it.getProduct().getPrice()*it.getQuantity();
            line=it.getProduct().getName()+", $"+String.format("%.2f",it.getProduct().getPrice())+", Quantity: "+it.getQuantity()+", Subtotal: $"+String.format("%.2f",total)+"\n";
            sb.append(line);
            price+=total;
        }
        sb.append("Total price: $"+ price);
        return  sb.toString();
    }
}

