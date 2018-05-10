/** @author Shayan Rizvi
 * Subclass of the Employee class, includes hourly wage and hours worked per week.
 */

public class StudentEmployee extends Employee
{
	private double hourlyRate;
	private double hoursPerWeek;
	private double total;
	
	public StudentEmployee(String name, String street, String city, String state,
			String zipCode, String socialSecurityNumber, String departmentName,
			String rate, String hours)
	{
		super(name, street, city, state, zipCode, socialSecurityNumber, departmentName);
		hourlyRate = Double.parseDouble(rate);;	
		hoursPerWeek = Double.parseDouble(hours);;
	}

	public Double getTotalPay()
	{
		total = hourlyRate * hoursPerWeek * 2;
		return total;
	}
}
