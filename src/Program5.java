import java.util.*;
import java.io.*;

/**
 * 
 * @author Shayan
 *
 * This program reads Employee object data from an csv file, determines the subclass of
 * each object based on parameter size (Faculty or Student Employee), places each Employee
 * object into a sorted arraylist of its respective category, calculates total pay for
 * student employees, and prints the formatted results to a seperate csv file.
 *
 */
public class Program5 
{
	public static void bubbleSort(ArrayList<Employee> personList) // bubble sort for arraylists
	{
		boolean swapped = true; 
		int j = 0; 
		Employee personTemp;
		
		while (swapped)
		{ 
			swapped = false; 
			j++; 
			for (int i = 0; i < personList.size() - j; i++) // for every object in personList
			{
				if (personList.get(i).getLastName().compareTo(personList.get(i + 1).getLastName()) > 0)
				{
					personTemp = personList.get(i); 
					personList.set(i, personList.get( i + 1)); // swap positions
					personList.set(i + 1, personTemp);
					
					swapped = true; 
				} // end if
			} // end for
		} // end while
	} // end bubbleSort
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner in = new Scanner(new File("p5input.csv")); // declare input file
		PrintWriter out = new PrintWriter("sr6047yj.csv"); // declare output file
		
		ArrayList<Employee> employeeList = new ArrayList<Employee>(); // initialize Employee arraylist
		ArrayList<Employee> facultyList = new ArrayList<Employee>(); // initialize Faculty arraylist
		ArrayList<Employee> studentEmployeeList = new ArrayList<Employee>(); // initialize StudentEmployee arraylist

		while(in.hasNextLine())  // as long as there is another line in the file
		{
			String fileLine = in.nextLine();  // read in a line of data
			String [] line = fileLine.split(","); // split input and store in a list
			
			if(line.length == 8) // determine whether object is faculty or student employee
			{
				Faculty newFaculty = new Faculty(line[0], line[1], line[2], line[3], // create new faculty object
						line[4], line[5], line[6], line[7]);
				facultyList.add(newFaculty); // add new faculty object to the faculty list
				employeeList.add(newFaculty); // add new faculty object to the employee list
			} // end if
			else
			{
				StudentEmployee newStudentEmployee = new StudentEmployee(line[0], line[1], line[2], line[3], // create new student employee object
						line[4], line[5], line[6], line[7], line[8]);
				studentEmployeeList.add(newStudentEmployee); // add new student employee object to the student employee list
				employeeList.add(newStudentEmployee); // add new student employee object to the employee list
			} // end else
			 
		} //end while
		
		bubbleSort(employeeList); // sort arraylists
		bubbleSort(facultyList);
		bubbleSort(studentEmployeeList);
		
		// print formatted results
		
		out.println("FACULTY");
		out.println("--------------");
		
		for(int i = 0; i < facultyList.size(); i++)  //for each item in the faculty list
		{
			out.println("\" " + facultyList.get(i).getLastName() + ", " + "\" " + facultyList.get(i).getFirstName()
					+ "," + facultyList.get(i).getStreetAddress() + "," + "\" " + facultyList.get(i).getAddress() + "\" "
					+ "," + facultyList.get(i).getSsn());
			out.println("," + facultyList.get(i).getDeptName() + "," + "$" + facultyList.get(i).getSalary());
			out.println();
		}
		
		out.println("STUDENT EMPLOYEES");
		out.println("---------------------------------");
		
		for(int i = 0; i < studentEmployeeList.size(); i++)  //for each item in the student employee list
		{
			out.println("\" " + studentEmployeeList.get(i).getLastName() + ", " + "\" " + studentEmployeeList.get(i).getFirstName()
					+ "," + studentEmployeeList.get(i).getStreetAddress() + "," + "\" " +  studentEmployeeList.get(i).getAddress() + "\" "
					+ "," + studentEmployeeList.get(i).getSsn());
			out.println("," + studentEmployeeList.get(i).getDeptName() + "," + "$" + studentEmployeeList.get(i).getTotalPay());
			out.println();
		}
		
		out.println("ALL EMPLOYEES");
		out.println("-------------------------");
		
		for(int i = 0; i < employeeList.size(); i++)  //for each item in the employee list
		{
			out.println("\" " + employeeList.get(i).getLastName() + ", " + "\" " + employeeList.get(i).getFirstName()
					+ "," + employeeList.get(i).getSsn());
		}

		in.close(); // close input file
		out.close(); // close output file
	} // end main
}
