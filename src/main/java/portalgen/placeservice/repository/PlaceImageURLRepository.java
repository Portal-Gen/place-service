package portalgen.placeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portalgen.placeservice.entity.PlaceImageURLEntity;

@Repository
public interface PlaceImageURLRepository extends JpaRepository<PlaceImageURLEntity, Long> {
}
