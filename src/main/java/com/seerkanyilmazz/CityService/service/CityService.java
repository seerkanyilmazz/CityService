package com.seerkanyilmazz.CityService.service;

import com.seerkanyilmazz.CityService.exception.CityAlreadyExistsException;
import com.seerkanyilmazz.CityService.exception.CityNotFoundException;
import com.seerkanyilmazz.CityService.model.City;
import com.seerkanyilmazz.CityService.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public List<City> getCities(String name) {
        if (name == null){
            return cityRepository.findAll();
        }
        else {
            return cityRepository.findAllByName(name);
        }
    }

    public City saveCity(City newCity) {
        Optional<City> cityByName = cityRepository.findByName(newCity.getName());
        if (cityByName.isPresent()){
            throw new CityAlreadyExistsException("City is already exists with name:" + newCity.getName());
        }
        return cityRepository.save(newCity);
    }

    public void deleteCity(String id) {
        cityRepository.deleteById(id);
    }

    public City getCityById(String id) {
        return cityRepository.findById(id)
                             .orElseThrow(() -> new CityNotFoundException("City is not found with id:" + id));
    }

    public void updateCity(String id, City newCity) {
        City oldCity = getCityById(id);
        oldCity.setId(newCity.getId());
        oldCity.setName(newCity.getName());
        oldCity.setCreatedDate(newCity.getCreatedDate());
        cityRepository.save(oldCity);
    }
}
