package portalgen.placeservice.service;

import portalgen.placeservice.entity.WorldCityEntity;
import portalgen.placeservice.model.request.SearchWorldCityRequest;

public interface WorldCityRepoService {
    WorldCityEntity save(WorldCityEntity worldCityEntity);

    WorldCityEntity findById(Long id);

    WorldCityEntity findIdByCityNameAndCountryName(SearchWorldCityRequest searchWorldCityRequest);

    boolean existsById(Long id);
}
