package pl.pkopy.save.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ListOfWheather {
    @JsonProperty("list")
    private MainWeather mainWeather;
    private String dt;

}
