/** @author Shayan Rizvi
 * Person class containing first name, last name, address, and zip.
 */

public class Person
{
	private String firstName;
	private String lastName;
	private String streetAddress;
	private String address;

	public Person(String name, String street, String city, String state, String zipCode)
	{
		String [] line = name.split(" ");
		
		firstName = line[0];
		lastName = line[1];
		streetAddress = street;
		address = city + ", " + state + " " + zipCode;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getStreetAddress()
	{
		return streetAddress;
	}
	
	public String getAddress()
	{
		return address;
	}
	
}
