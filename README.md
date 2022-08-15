
Based on
https://www.youtube.com/watch?v=HeRZRGdvyL4&t=1899s

Class DeliveryService in module delivery needs interface BillingService in module billing.
Package services with interface BillingService is exported but not its implementation.

Module demo needs both invoice and delivery modules.
Can be achieved by keyword transitive (in module-info of delivery) or
aggregate "empty" module (module-info of billing_delivery_aggregated requires both invoice and billing).

![img.png](img.png)

![img_1.png](img_1.png)


