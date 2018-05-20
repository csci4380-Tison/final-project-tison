/**
 * 
 */
package csci4380.finalp.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import csci4380.finalp.cats.jpa.model.Cat;
import csci4380.finalp.cats.jpa.repo.CatRepository;

/**
 * @author jkris
 *
 */
@Component
public class InitCatDb implements CommandLineRunner
{
	private CatRepository catRepository;
	
	@Autowired
	public InitCatDb(CatRepository catRepository) {
		super();
		this.catRepository = catRepository;
	}
	
	
	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception 
	{
		// TODO Auto-generated method stub
		//String name, String type, String ownerName, String address, String birthdate, Integer age, Boolean isSpayed
		Cat catOne = new Cat("Mona Lisa", "Manx", "Glorienne Kattrina Tison", "400 Greens Ridge Road", "10/08/2013", 5, true);
		Cat savedCatOne = catRepository.save(catOne);
		System.out.println("-----> JKRIS ----> Saved catOne");
	}


}
