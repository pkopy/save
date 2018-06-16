package pl.pkopy.save.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainWeather {
    private double temp;
    private double pressure;
    private long humidity;
}
