package flight.flightservice.repository;

import flight.flightservice.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepo extends JpaRepository<PaymentInfo, String> {
}
