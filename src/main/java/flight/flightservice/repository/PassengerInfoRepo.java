package flight.flightservice.repository;

import flight.flightservice.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepo extends JpaRepository<PassengerInfo, Long> {
}
