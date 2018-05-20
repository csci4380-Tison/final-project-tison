/**
 * 
 */
package csci4380.finalp.cats.jpa.model;

//import java.util.Date;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

/**
 * @author jkris
 *
 */
@Entity(name="CAT")
public class Cat 
{
	@Id
	@GeneratedValue
	Integer petId;
	String name, type;
//	@Column(name="owner_name")
	String ownerName;
	String address;
	Integer age;
	Boolean isSpayed;
	String birthdate;
	
	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cat(String name, String type, String ownerName, String address, String birthdate, Integer age,
			Boolean isSpayed) {
		super();
		this.name = name;
		this.type = type;
		this.ownerName = ownerName;
		this.address = address;
		this.birthdate = birthdate;
		this.age = age;
		this.isSpayed = isSpayed;
	}
	
	

	public Cat(Integer petId, String name, String type, String ownerName, String address, String birthdate, Integer age,
			Boolean isSpayed) 
	{
		this(name, type, ownerName, address, birthdate, age, isSpayed);
		this.petId = petId;
	}

	@Override
	public String toString() {
		return "Cat [petId=" + petId + ", age=" + age + ", name=" + name + ", type=" + type + ", ownerName=" + ownerName
				+ ", address=" + address + ", birthdate=" + birthdate + ", isSpayed=" + isSpayed + "]";
	}

	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public Boolean getIsSpayed() {
		return isSpayed;
	}

	public void setIsSpayed(Boolean isSpayed) {
		this.isSpayed = isSpayed;
	}
}
