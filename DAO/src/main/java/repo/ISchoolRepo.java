package repo;

import org.springframework.data.repository.CrudRepository;

import model.School;

public interface ISchoolRepo extends CrudRepository<School, Long>{

}
