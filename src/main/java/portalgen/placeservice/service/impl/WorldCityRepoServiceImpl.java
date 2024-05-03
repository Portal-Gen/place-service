package portalgen.placeservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import portalgen.placeservice.entity.WorldCityEntity;
import portalgen.placeservice.exception.BadRequestError;
import portalgen.placeservice.exception.ResponseException;
import portalgen.placeservice.model.request.SearchWorldCityRequest;
import portalgen.placeservice.repository.WorldCityRepository;
import portalgen.placeservice.service.WorldCityRepoService;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class WorldCityRepoServiceImpl implements WorldCityRepoService {
    private final WorldCityRepository worldCityRepository;
    @Override
    public WorldCityEntity save(WorldCityEntity worldCityEntity) {
        return worldCityRepository.save(worldCityEntity);
    }

    @Override
    public WorldCityEntity findById(Long id) {
        Optional<WorldCityEntity> worldCityEntity = worldCityRepository.findById(id);
        if (worldCityEntity.isPresent()) {
            return worldCityEntity.get();
        } else {
            throw new ResponseException(BadRequestError.WORLD_CITY_NOT_FOUND);
        }
    }

    @Override
    public WorldCityEntity findIdByCityNameAndCountryName(SearchWorldCityRequest searchWorldCityRequest) {
        WorldCityEntity worldCity = worldCityRepository.findByCityAndCountry(searchWorldCityRequest.getCity(), searchWorldCityRequest.getCountry());

        if (worldCity == null) {
            throw new ResponseException(BadRequestError.WORLD_CITY_NOT_FOUND);
        }

        return worldCity;
    }

    @Override
    public boolean existsById(Long id) {
        return worldCityRepository.existsById(id);
    }
}
