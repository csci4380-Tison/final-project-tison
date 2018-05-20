/**
 * 
 */
package csci4380.finalp.init;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import csci4380.finalp.dogs.mongodb.model.Dog;
import csci4380.finalp.dogs.mongodb.repo.DogRepository;

/**
 * @author jkris
 *
 */
@Component
public class InitDogMongoDb implements CommandLineRunner 
{
	private DogRepository dogRepository;
	
	@Autowired
	public InitDogMongoDb(DogRepository dogRepository) {
		super();
		this.dogRepository = dogRepository;
	}
	

	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//Integer petId, String name, String type, String ownerName, String address, int age, Boolean isSpayed, String birthdate
		Dog dogOne = new Dog(1, "Zakk", "Maltese", "Glorietta M Tison", "400 Greens Ridge Road", 8, true, "09/23/2010");
		Dog dogTwo = new Dog(2, "Drew", "Mixed", "Glorietta M Tison", "400 Greens Ridge Road", 5, true, "05/04/2013");
		
		//System.out.println("-----> JKRIS ----> Saving dogs");
		
		//Dog savedDogOne = dogRepository.save(dogOne);
		//Dog savedDogTwo = dogRepository.save(dogTwo);
		List<Dog> dogs = Arrays.asList(dogOne, dogTwo);
		dogRepository.saveAll(dogs);
		
		System.out.println("-----> JKRIS ----> Saved dogs");
	}


}
