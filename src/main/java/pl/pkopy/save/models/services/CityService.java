package pl.pkopy.save.models.services;

import lombok.Getter;
import lombok.Setter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import pl.pkopy.save.models.CityEntity;
import pl.pkopy.save.models.Repositories.CityRepository;


import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
@Setter
@SuppressWarnings("unchecked")
public class CityService {

    private CityRepository cityRepository;
    private List<CityEntity> cityEntities = new ArrayList<>();
    @Autowired
    public CityService(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }
    public List<CityEntity> insertCitiesToDB(){


        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("C:/city.txt"));

            JSONArray cities = (JSONArray) obj;
            for(Object citi : cities){

                JSONObject jsonObject = (JSONObject) citi;

                Long idCity = (Long) jsonObject.get("id");
                String name = (String) jsonObject.get("name");
                String country = (String) jsonObject.get("country") ;

                CityEntity cityEntity = new CityEntity();
                cityEntity.setIdCity(idCity);
                cityEntity.setCountry(country);
                cityEntity.setName(name);

                cityEntities.add(cityEntity);
                cityRepository.save(cityEntity);




//                System.out.println("Name: " + cityEntity.getName() + " id: " + cityEntity.getIdCity()+ " country: " + cityEntity.getCountry());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
//        cityRepository.saveAll(cityEntities);
        return cityEntities;

    }

    public List<CityEntity> findCityId(String city){

        return  cityRepository.findAllByName(city);


    }


}
