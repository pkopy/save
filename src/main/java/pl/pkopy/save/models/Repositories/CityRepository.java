package pl.pkopy.save.models.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.pkopy.save.models.CityEntity;
@Repository
public interface CityRepository extends CrudRepository<CityEntity, Integer> {
}
