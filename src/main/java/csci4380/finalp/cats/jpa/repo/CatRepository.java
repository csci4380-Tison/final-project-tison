/**
 * 
 */
package csci4380.finalp.cats.jpa.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import csci4380.finalp.cats.jpa.model.Cat;

/**
 * @author jkris
 *
 */
public interface CatRepository extends JpaRepository<Cat, Integer> 
{
	//public Cat insert(Cat cat);

	public Optional<List<Cat>> findByType(String type);
	public Optional<List<Cat>> findByName(String name);
	public Optional<List<Cat>> findByOwnerName(String ownerName);
	public Optional<List<Cat>> findByNameOrOwnerName(String name, String ownerName);
	
	@Query("select c from CAT c where lower(c.type) = lower(:type)")
	public Cat findByTypeIgnoreCaseQuery(@Param("type") String type);

	@Query("select c from CAT c where (lower(c.name) = lower(:name)) or (lower(c.ownerName) = lower(:ownerName))")
	public Cat findByNameOrOwnerNameIgnoreCaseQuery(@Param("name") String name, @Param("ownerName") String ownerName);
	
	/*	@Query("select c from CAT c where lower(c.petId) = lower(:petId)")
	 *	public Cat findByIdIgnoreCaseQuery(@Param("petID") Integer petId);
	 */
}
