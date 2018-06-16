package pl.pkopy.save.models.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pkopy.save.models.CityEntity;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<CityEntity, Integer> {
    List<CityEntity> findAllByName(String city);
}
