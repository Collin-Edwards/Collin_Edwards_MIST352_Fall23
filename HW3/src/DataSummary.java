import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

/**
 * Collin Edwards
 * MIST 352-001 Business Application Programming
 * HW3
 * I used ChatGPT to code one and only one of the Java classes for this homework.
 * This is the prompt I used, and I will also be attaching screenshots for my submission.
 */

public class DataSummary {
    private String fileLocation; // The path to the file containing the employee data
    private double averageSalary; // The average salary of all employees, calculated from the data file

    /**
     * Constructor for DataSummary class.
     * @param file the path to the employee data file
     * @throws FileNotFoundException if the file path provided does not point to an actual file
     */
    public DataSummary(String file) throws FileNotFoundException {
        this.fileLocation = file; // Store the file path
        this.averageSalary = getAverage(); // Calculate the average salary using the getAverage method
    }

    /**
     * Reads the employee data file, calculates, and returns the average salary.
     * @return the calculated average salary of all employees
     * @throws FileNotFoundException if the employee data file is not found
     */
    public double getAverage() throws FileNotFoundException {
        File employeeFile = new File(fileLocation); // Create a File object for the provided file path
        Scanner fileScanner = new Scanner(employeeFile); // Open a Scanner to read from the File
        double totalSalary = 0; // Accumulate total salaries
        int employeeCount = 0; // Count the number of employees
        
        while (fileScanner.hasNextLine()) { // While there are more lines to read in the file
            String line = fileScanner.nextLine(); // Read the next line
            String[] data = line.split(","); // Split the line by commas into an array of strings
            totalSalary += Double.parseDouble(data[5]); // Add the salary (assumed to be at index 5) to the total
            employeeCount++; // Increment the employee count
        }
        fileScanner.close(); // Close the scanner to free system resources
        
        // Return the average salary by dividing total salary by the number of employees
        // If employeeCount is zero, avoid division by zero by returning 0
        return employeeCount > 0 ? totalSalary / employeeCount : 0;
    }

    /**
     * Prints all employees' names and their IDs to the console.
     * @throws FileNotFoundException if the employee data file is not found
     */
    public void ViewEmployeeAndIDs() throws FileNotFoundException {
        File employeeFile = new File(fileLocation); // Create a File object for the provided file path
        Scanner fileScanner = new Scanner(employeeFile); // Open a Scanner to read from the File
        
        while (fileScanner.hasNextLine()) { // While there are more lines to read in the file
            String line = fileScanner.nextLine(); // Read the next line
            String[] data = line.split(","); // Split the line by commas into an array of strings
            // Print the employee ID and name to the console, assumed to be at index 3 and 0 respectively
            System.out.println("ID: " + data[3] + ", Name: " + data[0]);
        }
        fileScanner.close(); // Close the scanner to free system resources
    }

    /**
     * Searches for an employee by name and prints the employee's data if found.
     * @param strEmployee the name of the employee to search for
     * @throws FileNotFoundException if the employee data file is not found
     */
    public void SearchEmployee(String strEmployee) throws FileNotFoundException {
        File employeeFile = new File(fileLocation); // Create a File object for the provided file path
        Scanner fileScanner = new Scanner(employeeFile); // Open a Scanner to read from the File
        boolean found = false; // A flag to indicate if the employee was found or not
        
        while (fileScanner.hasNextLine()) { // While there are more lines to read in the file
            String line = fileScanner.nextLine(); // Read the next line
            if (line.contains(strEmployee)) { // If the line contains the employee's name
                System.out.println(line); // Print the line to the console
                found = true; // Set the found flag to true
                break; // Break out of the loop since we found the employee
            }
        }
        if (!found) { // If the employee was not found after going through the whole file
            System.out.println("Not Found"); // Print "Not Found" to the console
        }
        fileScanner.close(); // Close the scanner to free system resources
    }

    /**
     * This method accepts an employee role (i.e., position) and views for all employees in that role.
     * It should print out all employees' info to a GUI, otherwise, it should print out Not Found.
     * @param strRole Employee role to search for.
     * @throws FileNotFoundException Thrown if the employee data file is not found.
     */
    public void ViewEmployeeForRole(String strRole) throws FileNotFoundException {  File employeeFile1 = new File(fileLocation); // Create a File object for the provided file path.
    Scanner fileScanner = new Scanner(employeeFile1); // Open a Scanner to read from the File.
    Writer strOutputLocation = null;
	PrintWriter writer = new PrintWriter(strOutputLocation); // Use the provided output location.

    while (fileScanner.hasNextLine()) { // While there are more lines to read in the file.
        String line = fileScanner.nextLine(); // Read the next line.
        String[] data = line.split(","); // Split the line by commas into an array of strings.

        // Assuming the name is at index 0, ID at index 1, and salary at index 5.
        String name = data[0];
        String id = data[1];
        double salary = Double.parseDouble(data[5]);
        
        // Create an Employee object to use the SalaryBarChart method.
        // This assumes that Employee has a constructor that takes a 'line' of employee data.
        Employee employee = new Employee(line); 
        String salaryBar = employee.SalaryBarChart(salary); // Generate the salary bar.
        
        // Determine if the salary is above or below the average.
        String aboveOrBelowAverage = salary > averageSalary ? "true" : "false";
        
        // Format the output string to include the salary bar and above/below average indicator.
        String output = String.format("ID: %s, Name: %s, %s, %s", id, name, salaryBar, aboveOrBelowAverage);
        
        // Print the formatted employee info to the console.
        System.out.println(output);
        
        // Write the formatted employee info to the file.
        writer.println(output);
    }
    
    // Close the scanner and the writer to free system resources and ensure data is saved.
    fileScanner.close();
    writer.close();
}
    /**
	 * Keep as is.
	 * This method displays the distinct roles in the text file
	 * @throws FileNotFoundException 
	 */
	public void ViewRoles() throws FileNotFoundException
	{	
		       
		        File myFile = new File(fileLocation);
		        Scanner inputFile = new Scanner(myFile);
		        Set<String> distinctRoles = new HashSet<>();

		        while(inputFile.hasNextLine()) {
		            String strData2Show = inputFile.nextLine();
		            // Splitting the line by comma
		            String[] dataParts = strData2Show.split(",");
		            // The role is the third element in the array (index 2)
		            distinctRoles.add(dataParts[2]);
		        }
		        inputFile.close();
		        String strRole="";
		        // Displaying distinct roles
		        for (String role : distinctRoles) {
		        	strRole = strRole + role + "\n";
		            //System.out.println(role);
		        }
		        JOptionPane.showMessageDialog(null, strRole);
		    }
	
}
