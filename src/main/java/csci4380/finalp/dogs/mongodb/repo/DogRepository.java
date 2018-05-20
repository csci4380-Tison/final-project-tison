/**
 * 
 */
package csci4380.finalp.dogs.mongodb.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import csci4380.finalp.dogs.mongodb.model.Dog;

/**
 * @author jkris
 *
 */
@Repository
public interface DogRepository extends MongoRepository<Dog, String> {

	public Optional<List<Dog>> findByPetId(Integer petId);
	public Optional<List<Dog>> findByNameOrOwnerName(String name, String ownerName);
	
	public void deleteByPetId(String petId);
	
	@Query("{'type': ?0}")
	public List<Dog> findByTypeIgnoreCaseQuery(String type);

}
