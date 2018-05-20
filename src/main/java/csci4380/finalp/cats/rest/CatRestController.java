/**
 * 
 */
package csci4380.finalp.cats.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import csci4380.finalp.cats.jpa.model.Cat;
import csci4380.finalp.cats.jpa.repo.CatRepository;

/**
 * @author jkris
 *
 */
@RestController
@RequestMapping("rest/v1/cats")
public class CatRestController 
{
	@Autowired CatRepository catRepository;

	// curl -i -X GET http://localhost:8888/rest/v1/cats/echoMessage?msg=Hi
	//http://localhost:8888/rest/v1/cats/echoMessage?msg=Hi
	
	@RequestMapping("/echoMessage")
	public String echoMessage(@RequestParam(value="msg", defaultValue="Hello jkris") String message)
	{
		return "echoMessage echoed: " + message;
	}
	
	
	// curl -i http://localhost:8888/rest/v1/cats
	// curl -i http://localhost:8888/rest/v1/cats?page=2
	// curl -i http://localhost:8888/rest/v1/cats?rowsPerPage=3
	// curl -i "http://localhost:8888/rest/v1/cats?page=2&rowsPerPage=3"
	
	@GetMapping("")	
	public Page<Cat> findAll(@RequestParam(defaultValue="0") int page, @RequestParam(value="rowsPerPage", defaultValue="3") int size)
	{
		Page<Cat> catsPage = catRepository.findAll(new PageRequest(page, size));
		return catsPage;
	}
	
	// curl -i http://localhost:8888/rest/v1/cats/a
	@GetMapping("/all")
	public List<Cat> findAll()
	{
		List<Cat> cats = catRepository.findAll();
		return cats;
	}

	//	curl -X POST -H "Content-Type: application/json" -i  -d '{"name":"ilker_0", "type":"kiris_0", "ownerName":"freshman ", "address":"", "age":5, "isSpayed":false, "birthdate":"2018-04-29"}' http://localhost:8888/rest/v1/cats
	//	curl -X POST -H "Content-Type: application/json"     -d '{"name":"ilker_1", "type":"kiris_0", "ownerName":"freshman ", "address":"", "age":6, "isSpayed":false, "birthdate":"2018-04-29"}' http://localhost:8888/rest/v1/cats
	//	curl -X POST -H "Content-Type: application/json" --data '{"name":"ilker_2", "type":"kiris_0", "ownerName":"freshman ", "address":"", "age":7, "isSpayed":true, "birthdate":"2018-04-29"}' http://localhost:8888/rest/v1/cats	
	
	@PostMapping("")
	public Optional<Cat> save(@RequestBody final Cat cat)
	{
		Cat savedCat = catRepository.save(cat);
		return catRepository.findById(savedCat.getPetId());
	}
	
	@PutMapping("")
	public Optional<Cat> update(@RequestBody final Cat cat)
	{
		Cat updatedCat = catRepository.save(cat);
		return catRepository.findById(updatedCat.getPetId());
	}
	
	/*
	 * @PutMapping("rest/v1/cats")
	public Cat insert(@RequestBody final Cat cat)
	{
		Cat insertedCat = catRepository.insert(cat);
		return insertedCat;
	}
	 * 
	 */
	
	@GetMapping("/{petId}")
	public Optional<Cat> findById(@PathVariable Integer petId)
	{
		Optional<Cat> cat = catRepository.findById(petId);
		return cat;
	}
	
	@DeleteMapping("/{petId}")
	public void deleteById(@PathVariable Integer petId)
	{
		catRepository.deleteById(petId);
	}
	
	@GetMapping("/byNameOrOwnerName/{name}/{ownerName}")
	public Optional<List<Cat>> findByNameOrOwnerName(@PathVariable String name, @PathVariable String ownerName)
	{
		Optional<List<Cat>> cat = catRepository.findByNameOrOwnerName(name, ownerName);
		return cat;
	}
	
	@GetMapping("/byTypeIgnoreCase/{type}")
	public Cat findByTypeIgnoreCaseQuery(@PathVariable String type)
	{
		Cat cat = catRepository.findByTypeIgnoreCaseQuery(type);
		return cat;
	}
}
