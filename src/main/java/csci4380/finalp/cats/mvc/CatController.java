/**
 * 
 */
package csci4380.finalp.cats.mvc;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import csci4380.finalp.cats.jpa.model.Cat;
import csci4380.finalp.cats.jpa.repo.CatRepository;

/**
 * @author jkris
 *
 */

@Controller
@RequestMapping("/mvc/cat")
public class CatController 
{
	@Autowired
	private CatRepository catRepository;
	
	@RequestMapping("/echoMessage")
	@ResponseBody
	public String echoMessage(@RequestParam(value="msg", defaultValue="Hello jkris") String message)
	{
		return "echoMessage echoes: " + message;
	}
	
	@GetMapping("/index4angular-hello")
	public String index4angular_hello()
	{
		return "index4angular-hello";
	}
	
	@GetMapping("/list")
	public String showCatList(Model model, @RequestParam(defaultValue="0") int page, @RequestParam(value="rowsPerPage", defaultValue="3") int size)
	{
		Page<Cat> catsPage = catRepository.findAll(new PageRequest(page, size));
		model.addAttribute("catsData", catsPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("rowsPerPage", size);
		return "catList";
	}
	
	@PostMapping("/save")
	public String saveCat(Cat cat)
	{
		catRepository.save(cat);
		return "redirect:/mvc/cat/list";
	}
	
	@GetMapping("/delete")
	public String deleteCat(Integer petId) 
	{
		catRepository.deleteById(petId);
		return "redirect:/mvc/cat/list";	
	}	

	@GetMapping("/detailOptional")
	@ResponseBody			
	public Optional<Cat> showCatDetailOptional(Integer petId) 
	{
		return catRepository.findById(petId);
	}

	@GetMapping("/detail")
	@ResponseBody			
	public Cat showCatDetail(Integer petId) 
	{
		Optional<Cat> cat = catRepository.findById(petId);
		return cat.isPresent() ? cat.get() : null;
	}

}

