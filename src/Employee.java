/** @author Shayan Rizvi
 * Subclass of the Person class, includes ssn and deptName.
 */

public class Employee extends Person
{
	private String ssn;
	private String deptName;
	
	public Employee(String name, String street, String city, String state, String zipCode,
			String socialSecurityNumber, String departmentName)
	{
		super(name, street, city, state, zipCode);
		ssn = socialSecurityNumber;
		deptName = departmentName;
	}
	
	public String getSsn()
	{
		return ssn;
	}
	
	public String getDeptName()
	{
		return deptName;
	}

	public Double getSalary()
	{
		return null;
	}

	public Double getTotalPay()
	{
		return null;
	}
	
	

}
