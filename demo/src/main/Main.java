package main;

import model.Invoice;
import service.DeliveryService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        DeliveryService service=new DeliveryService();
        List<Invoice> invoiceList=service.deliver();  //Invoice accessible thanks to transitive in module-info
        invoiceList.forEach(System.out::println);
    }
}
