package pl.pkopy.save.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.pkopy.save.models.CityEntity;
import pl.pkopy.save.models.ListOfWheather;
import pl.pkopy.save.models.Repositories.CityRepository;
import pl.pkopy.save.models.services.CityService;
import pl.pkopy.save.models.services.WeatherService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private CityRepository cityRepository;
    private CityService cityService;
    private List<CityEntity> cities;
    private ListOfWheather listOfWheather;
    private WeatherService weatherService;
    @Autowired
    public MainController(CityRepository cityRepository, CityService cityService, WeatherService weatherService){
        this.cityService = cityService;
        this.cityRepository = cityRepository;
        this.weatherService = weatherService;
        cities  = new ArrayList<>();

    }

    @GetMapping
    public String indexGet(){
        return "index";
    }

    @PostMapping("/")

    public String index(@RequestParam("city") String city, Model model){

        model.addAttribute("weathers",weatherService.makeCall(city));

//            cities   = cityService.insertCitiesToDB();
//        CityEntity cityEntity = new CityEntity();
//        cityEntity.setCountry("PL");
//        cityEntity.setName("POLSKA");
//
//
//        cityRepository.saveAll(cities);

//        cityRepository.saveAll();
//        List<ListOfWheather> listOfWheathers = weatherService.makeCall("Radom");
//        StringBuilder tekst = new StringBuilder();
//        for(ListOfWheather weater : listOfWheathers){
//            tekst.append("time: " +weater.getDt() + " temp: " + weater.getMainWeather().getTemp() + " hum: " + weater.getMainWeather().getHumidity() +"===\n");
//        }
//
//
        return "index";
    }


}
