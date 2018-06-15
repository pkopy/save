package pl.pkopy.save.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.pkopy.save.models.CityEntity;
import pl.pkopy.save.models.Repositories.CityRepository;
import pl.pkopy.save.models.services.CityService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private CityRepository cityRepository;
    private CityService cityService;
    private List<CityEntity> cities;
    @Autowired
    public MainController(CityRepository cityRepository, CityService cityService){
        this.cityService = cityService;
        this.cityRepository = cityRepository;
        cities  = new ArrayList<>();

    }

    @GetMapping("/")
    @ResponseBody
    public String index(){
            cities   = cityService.cos();
//        CityEntity cityEntity = new CityEntity();
//        cityEntity.setCountry("PL");
//        cityEntity.setName("POLSKA");
//
//
        cityRepository.saveAll(cities);

//        cityRepository.saveAll();

        StringBuilder tekst = new StringBuilder();
        for(CityEntity city : cities){
            tekst.append("id: " + city.getIdCity() + " name: " + city.getName() + " country: " + city.getCountry() +"\n");
        }

        return tekst.toString();
    }
}
