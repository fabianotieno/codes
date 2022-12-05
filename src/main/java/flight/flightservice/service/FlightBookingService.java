package flight.flightservice.service;

import flight.flightservice.dto.FlightBookingAcknowledgement;
import flight.flightservice.dto.FlightBookingRequest;
import flight.flightservice.entity.PassengerInfo;
import flight.flightservice.entity.PaymentInfo;
import flight.flightservice.repository.PassengerInfoRepo;
import flight.flightservice.repository.PaymentInfoRepo;
import flight.flightservice.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class FlightBookingService {
    @Autowired
    private PassengerInfoRepo passengerInfoRepo;
    @Autowired
    private PaymentInfoRepo paymentInfoRepo;
    @Transactional
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request){


        PassengerInfo passengerInfo=request.getPassengerInfo();
        passengerInfo=passengerInfoRepo.save(passengerInfo);

        PaymentInfo paymentInfo=request.getPaymentInfo();

        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(),passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepo.save(paymentInfo);
        return new FlightBookingAcknowledgement("Success",passengerInfo.getFare(),UUID.randomUUID().toString().split("-")[0],passengerInfo);

    }
}
