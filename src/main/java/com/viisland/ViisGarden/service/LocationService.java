package com.viisland.ViisGarden.service;

import com.viisland.ViisGarden.entity.Location;
import com.viisland.ViisGarden.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    @Transactional
    public Location addLocation(Location location) throws Exception {
        try {
            return locationRepository.save(location);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Transactional
    public Location updateLocation(String locationId, Location location) throws Exception {
        try {
            Optional<Location> findLocation = findRelevantLocation(locationId);
            if (findLocation.isPresent()) {
                findLocation.get().setDistrict(location.getDistrict());
                findLocation.get().setNeighbourhood(location.getNeighbourhood());
                findLocation.get().setStreet(location.getStreet());
                findLocation.get().setProvince(location.getProvince());
                findLocation.get().setParcel(location.getParcel());
                return locationRepository.save(findLocation.get());
            } else {
                throw new Exception("Can not find relevant location data.");
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Transactional
    public Location deleteLocation(String locationId) throws Exception {
        try {
            Optional<Location> findLocation = findRelevantLocation(locationId);
            if (findLocation.isPresent()) {
                locationRepository.deleteById(locationId);
                return findLocation.get();
            } else {
                throw new Exception("Can not delete location id: "+locationId);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public Location getLocation(String locationId) throws Exception {
        Optional<Location> findLocation = findRelevantLocation(locationId);
        if (findLocation.isPresent()) {
            return  findLocation.get();
        } else {
            throw new Exception("Can not find the location: " + locationId);
        }
    }

    public List<Location> getAllLocation() {
        return locationRepository.findAll();
    }

    private Optional<Location> findRelevantLocation(String locationId) throws Exception {
        try {
            if (!locationId.isBlank()) {
                return locationRepository.findById(locationId);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
