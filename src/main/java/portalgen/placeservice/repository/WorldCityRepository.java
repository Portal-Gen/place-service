package portalgen.placeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portalgen.placeservice.entity.WorldCityEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorldCityRepository extends JpaRepository<WorldCityEntity, Long> {
    WorldCityEntity findByCityAndCountry(String city, String country);
}
