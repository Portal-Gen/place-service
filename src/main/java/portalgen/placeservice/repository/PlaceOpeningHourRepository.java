package portalgen.placeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portalgen.placeservice.entity.PlaceOpeningHourEntity;

public interface PlaceOpeningHourRepository extends JpaRepository<PlaceOpeningHourEntity, Long> {
}
