package portalgen.placeservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import portalgen.placeservice.entity.WorldCityEntity;
import portalgen.placeservice.model.request.SearchWorldCityRequest;
import portalgen.placeservice.model.response.Response;
import portalgen.placeservice.service.WorldCityService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class WorldCityController {
    private final WorldCityService worldCityService;

    @PostMapping("/world-city")
    public Response<WorldCityEntity> searchWorldCity(@RequestBody SearchWorldCityRequest searchWorldCityRequest) {
        return new Response<>(worldCityService.searchWorldCity(searchWorldCityRequest));
    }
}
