package service;

import model.Invoice;
import services.BillingService;

import java.util.List;

public class DeliveryService {

    public List<Invoice> deliver() {
        BillingService service=BillingService.build();
        //BillingServiceImpl serviceImpl; //does not compile because package implementation is not exported
        List<Invoice> invoiceList=service.generate();

        return invoiceList;
    }

}
