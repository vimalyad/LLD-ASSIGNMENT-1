package service;

import config.PricingConfig;
import entities.BookingReceipt;
import entities.TripRequest;
import printer.ConsoleUi;
import utils.behaviours.IDistanceCalculator;
import utils.behaviours.IDriverAllocator;
import utils.behaviours.IPaymentGateway;

import static config.PricingConfig.BASE_FARE_PRICE;
import static config.PricingConfig.FARE_PER_KM;


public class TransportBookingService {



    private final IDistanceCalculator distanceCalculator;
    private final IDriverAllocator driverAllocator;
    private final IPaymentGateway paymentGateway;
    private final ConsoleUi console;

    public TransportBookingService(
            IDistanceCalculator distanceCalculator,
            IDriverAllocator driverAllocator,
            IPaymentGateway paymentGateway,
            ConsoleUi console
    ) {
        this.distanceCalculator = distanceCalculator;
        this.driverAllocator = driverAllocator;
        this.paymentGateway = paymentGateway;
        this.console = console;
    }


    public void book(TripRequest req) {

        double kiloMeters = distanceCalculator.km(req.from, req.to);
        console.print("DistanceKm=" + kiloMeters);

        String driver = driverAllocator.allocate(req.studentId);
        console.print("Driver=" + driver);

        double fare = BASE_FARE_PRICE + kiloMeters * FARE_PER_KM;
        fare = Math.round(fare * 100.0) / 100.0;

        String txn = paymentGateway.charge(req.studentId, fare);
        console.print("Payment=PAID txn=" + txn);

        BookingReceipt r = new BookingReceipt("R-501", fare);
        console.print("RECEIPT: " + r.id + " | fare=" + String.format("%.2f", r.fare));
    }
}
