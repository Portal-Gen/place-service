package portalgen.placeservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import portalgen.placeservice.model.request.PlaceDescriptionRequest;
import portalgen.placeservice.model.request.UpdatePlaceDescriptionRequest;
import portalgen.placeservice.model.response.PlaceDescriptionResponse;
import portalgen.placeservice.model.response.Response;
import portalgen.placeservice.service.PlaceDescriptionService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PlaceDescriptionController {
    private final PlaceDescriptionService placeDescriptionService;

    @PostMapping("/place-description")
    public Response<PlaceDescriptionResponse> createPlaceDescription(@RequestBody PlaceDescriptionRequest placeDescriptionRequest) {
        return new Response<>(placeDescriptionService.createPlaceDescription(placeDescriptionRequest));
    }

    @GetMapping("/place-description/{placeDescriptionId}")
    public Response<PlaceDescriptionResponse> getPlaceDescription(@PathVariable Long placeDescriptionId) {
        return new Response<>(placeDescriptionService.getPlaceDescription(placeDescriptionId));
    }

    @GetMapping("/place-descriptions/{placeId}")
    public Response<List<PlaceDescriptionResponse>> getPlaceDescriptions(@PathVariable Long placeId) {
        return new Response<>(placeDescriptionService.getPlaceDescriptions(placeId));
    }

    @PutMapping("/place-description")
    public Response<PlaceDescriptionResponse> updatePlaceDescription(@RequestBody UpdatePlaceDescriptionRequest placeDescriptionRequest) {
        return new Response<>(placeDescriptionService.updatePlaceDescription(placeDescriptionRequest));
    }

    @DeleteMapping("/place-description/{placeDescriptionId}")
    public Response<PlaceDescriptionResponse> deletePlaceDescription(@PathVariable Long placeDescriptionId) {
        return new Response<>(placeDescriptionService.deletePlaceDescription(placeDescriptionId));
    }

    @DeleteMapping("/place-descriptions/{placeId}")
    public Response<List<PlaceDescriptionResponse>> deletePlaceDescriptions(@PathVariable Long placeId) {
        return new Response<>(placeDescriptionService.deletePlaceDescriptions(placeId));
    }
}
