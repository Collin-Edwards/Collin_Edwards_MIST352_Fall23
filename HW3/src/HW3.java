/**
 * 
 */

/**
 * @author Collin Edwards
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

public class HW3 {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
	//****** Keep as is *******************
		// The location of the employee text file 
		String strDataLocation ="src/EmployeeData.txt";
		String strOutputLocation ="src/EmployeeSummary.txt";
		File myFile = new File(strDataLocation);
		Scanner inputFile = new Scanner (myFile);
		PrintWriter writer =new PrintWriter(strOutputLocation);
		int intChoice  = Integer.parseInt( JOptionPane.showInputDialog(null,  ViewOptions()));
		DataSummary myData = new DataSummary(strDataLocation);
	//*************************************

		
		while(intChoice !=0)
		{
			switch(intChoice)
			{
			case 1:
				myData.ViewEmployeeAndIDs();
				break;
			case 2:
				String searchName = JOptionPane.showInputDialog(null, "Enter the Employee name to search for(Only text please)");
		        myData.SearchEmployee(searchName);
		        break;
			case 3:
				myData.ViewRoles();
				    break;
			case 4:
				String role = JOptionPane.showInputDialog(null, "Enter Role to View Employees(Again only text):");
		        myData.ViewEmployeeForRole(role);
		        break;
			case 5:
				 JOptionPane.showMessageDialog(null, "Average Salary: " + myData.getAverage());
			    break;
			case 6:
				myData.ViewEmployeeAndIDs();
				break;
			
				
				
			    
		
			}
			intChoice  = Integer.parseInt( JOptionPane.showInputDialog(null,  ViewOptions()));	
		}


		writer.close();
		inputFile.close();	
		
	}
	/**	 
	 * Keep as is
	 * A method to display options
	 * @return : The options to display in the GUI
	 */
	
	public static String ViewOptions()
	{
		String strMessageToDisplay="Choose an option:"
				+ "\n0.\tExit"
				+ "\n1.\tView Employees and IDs"
				+ "\n2.\tSearch for Employee"
				+ "\n3.\tView current roles"
				+ "\n4.\tView employees for a certain role"
				+ "\n5.\tView Average Salary"
				+ "\n6.\tSummerize and Write data";
		return strMessageToDisplay;
	} }
	
	
	
	



