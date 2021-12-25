package Apliccation;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc =new Scanner(System.in);
        SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy");
        Calendar cd = Calendar.getInstance();
        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date data = sdf1.parse(sc.nextLine());
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.nextLine());
        System.out.print("How many items to this order? ");
        Date act = new Date();
        int qtd = sc.nextInt();
        Order order = new Order(act,status,new Client(name,email,data));
        for(int i = 1;i<=qtd;i++){
            System.out.println("Enter #"+i+" item data:");
            sc.nextLine();
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            Double price = sc.nextDouble();
            System.out.print("Quantity: ");
            int productQtd = sc.nextInt();
            order.addItem(new OrderItem(productQtd,price,new Product(productName,price)));
        }
        System.out.println(order);


    }
}
