package services;

import model.Invoice;
import services.implementation.BillingServiceImpl;

import java.util.List;

public interface BillingService {
    List<Invoice> generate();

    static BillingService build() {
        return new BillingServiceImpl();
    }

}
