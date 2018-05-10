/** @author Shayan Rizvi
 * Subclass of the Employee class, includes salary.
 */

public class Faculty extends Employee
{
	private Double salary;
	
	public Faculty(String name, String street, String city, String state,
			String zipCode, String socialSecurityNumber, String departmentName, String facultySalary)
	{
		super(name, street, city, state, zipCode, socialSecurityNumber, departmentName);
		salary  = Double.parseDouble(facultySalary);
	}
	
	public Double getSalary()
	{
		return salary / 26;
	}

}
