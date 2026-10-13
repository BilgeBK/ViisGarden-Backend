package com.viisland.ViisGarden.controller;

import com.viisland.ViisGarden.commons.PathConstant;
import com.viisland.ViisGarden.entity.Location;
import com.viisland.ViisGarden.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PathConstant.LocationPath.LOCATION_MAP)
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @PostMapping(PathConstant.LocationPath.ADD_LOCATION)
    public ResponseEntity<Location> addLocation(@RequestBody @Validated Location location) throws Exception {
        Location response = locationService.addLocation(location);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(PathConstant.LocationPath.UPDATE_LOCATION)
    public ResponseEntity<Location> updateLocation(@PathVariable String locationId, @RequestBody @Validated Location location) throws Exception {
        Location response = locationService.updateLocation(locationId,location);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(PathConstant.LocationPath.DELETE_LOCATION)
    public ResponseEntity<Location> deleteLocation(@PathVariable String locationId) throws Exception {
        Location response = locationService.deleteLocation(locationId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(PathConstant.LocationPath.GET_LOCATION)
    public ResponseEntity<Location> getLocation(@PathVariable String locationId) throws Exception {
        Location response = locationService.getLocation(locationId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(PathConstant.LocationPath.GET_ALL_LOCATION)
    public ResponseEntity<List<Location>> getAllLocation() {
        List<Location> response = locationService.getAllLocation();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
