/**
 * 
 */
package csci4380.finalp.dogs.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author jkris
 *
 */
@Document(collection="Dogs")
public class Dog 
{
	@Id
	String id;
	Integer petId;
	@Indexed(direction=IndexDirection.ASCENDING)
	String name;
	String type;
	String ownerName;
	String address;
	int age;
	Boolean isSpayed;
	String birthdate;
	
	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dog(Integer petId, String name, String type, String ownerName, String address, int age, Boolean isSpayed,
			String birthdate) {
		super();
		this.petId = petId;
		this.name = name;
		this.type = type;
		this.ownerName = ownerName;
		this.address = address;
		this.age = age;
		this.isSpayed = isSpayed;
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return "Dog [id=" + id + ", petId=" + petId + ", name=" + name + ", type=" + type + ", ownerName=" + ownerName
				+ ", address=" + address + ", age=" + age + ", isSpayed=" + isSpayed + ", birthdate=" + birthdate + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getPetId() {
		return petId;
	}

	public void setPetId(Integer petId) {
		this.petId = petId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Boolean getIsSpayed() {
		return isSpayed;
	}

	public void setIsSpayed(Boolean isSpayed) {
		this.isSpayed = isSpayed;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
		

}
