/**
 * Collin Edwards
 * MIST 352-001 Business Application Programming
 * HW3
 * I used ChatGPT to code one and only one of the Java classes for this homework.
 * This is the prompt I used, and I will also be attaching screenshots for my submission.
 */
import java.util.Date;

public class Employee {
    private String name;
    private String dateOfBirth;
    private String role;
    private int employeeId;
    private String email;
    private double salary;
    private boolean aboveAvg ;
    private String bar;

    // Constructor 
    /**
     * You need to code this
     * This constructor accepts one line from a text file
     * It should split it up and initialize all attributes in this class using the values from the line
     * For example, name should equal to the first portion of the splited line and dateOfBirth is second and so on.
     * Lastly, set aboveAvg to false 
     * @param line
     */
    public Employee(String line)   		
    		 {  String[] parts = line.split(","); //using a comma to split the lines
    		    name = parts[0];						//for lines 31-36 i implemented the array technique we learned during online class this week, and from chapters 7, slides 5-8
    		    dateOfBirth = parts[1];		// assigning a dob to the second part of the employee split line
    		    role = parts[2];			// now assigning a role to the third part of the employee
    		    employeeId = Integer.parseInt(parts[3]);  //making the fourth part of the split line an integer to assign to employeeID
    		    salary = Double.parseDouble(parts[5]); 		// making the salary a double data time to assign to the salary
    		    aboveAvg = false;						// just a boolean value to determine whether or no the employee is making above the average salary

        setAboveAvg(salary);
    }
    
    /**
     * You need to code this
     * This method accepts the average salary from the main and decide whether this employee's salary is above average or not
     * If it is, then set aboveAvg to true
     * @param intAverage
     */
   public void setAboveAvg(double dblAverage)
   {
	   aboveAvg = salary > dblAverage;  // essentially it compares the employee's salary with average salary
	   
   }
	
   /**
	 * You need to code this.
	 * This method accepts an employee's salary and returns a bar chart of stars representation of the salary
	 * For example, 
	 * 				if the salary is 60,000, then the bar should return 6 stars:  ******
	 * 				if the salary is 95,600, then the bar should return 9 stars:  *********
	 * @param salary: the employee salary
	 * @return bar: representation in start of the salary. Each * represents $10,000
	 */
   public String SalaryBarChart(double salary) {		//like what you stated above on what must be included, it makes a "bar chart" using asterisks. each * represents 10000
	   int stars = (int) (salary / 10000);
	    return "*".repeat(stars);

	    	}
   
   /**
    * You need to code this.
    * This method provides a summary of each employee.
    * It returns a string formatted to include: employee name, employee ID, the bar chart of the salary, and whether salary is above average or not.
    * @return : Formatted string of employees basic information.
    */
   public String SummerizeEmployee()		// this makes a summary of the employee's information. makes the name a string data type, ID a double data type, and of course the salary bar a string since its *
	 
	 { String salaryBar = SalaryBarChart(salary);
	    String aboveAvgStr = aboveAvg ? "Above Average" : "Not Above Average";
	    return String.format("Name: %s, ID: %d, Salary Bar: %s, %s", 
	                         name, employeeId, salaryBar, aboveAvgStr);
		
	 }
	 

}
