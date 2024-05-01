package portalgen.placeservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import portalgen.placeservice.model.request.PlaceRequest;
import portalgen.placeservice.model.request.UpdatePlaceRequest;
import portalgen.placeservice.model.response.PlaceResponse;
import portalgen.placeservice.model.response.Response;
import portalgen.placeservice.service.PlaceService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PlaceController {
    private final PlaceService placeService;

    @PostMapping("/place")
    public Response<PlaceResponse> createPlace(@RequestBody PlaceRequest placeRequest) {
        return new Response<>(placeService.createPlace(placeRequest));
    }

    @PutMapping("/place")
    public Response<PlaceResponse> updatePlace(@RequestBody UpdatePlaceRequest placeRequest) {
        return new Response<>(placeService.updatePlace(placeRequest));
    }

    @GetMapping("/place/{placeId}")
    public Response<PlaceResponse> getPlace(@PathVariable Long placeId) {
        return new Response<>(placeService.getPlace(placeId));
    }

    @GetMapping("/place/google/{googlePlaceId}")
    public Response<PlaceResponse> getPlaceByGooglePlaceId(@PathVariable String googlePlaceId) {
        return new Response<>(placeService.getPlaceByGooglePlaceId(googlePlaceId));
    }

    @GetMapping("/places/{placeIds}")
    public Response<List<PlaceResponse>> getPlaces(@PathVariable List<Long> placeIds) {
        return new Response<>(placeService.getPlaces(placeIds));
    }
}
