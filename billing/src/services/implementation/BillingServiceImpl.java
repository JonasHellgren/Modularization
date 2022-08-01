package services.implementation;

import model.Invoice;
import services.BillingService;

import java.util.List;

public class BillingServiceImpl implements BillingService {
    @Override
    public List<Invoice> generate() {
        Invoice invoice=new Invoice();
        invoice.setCode("ABC");
        return List.of(invoice);
    }
}
