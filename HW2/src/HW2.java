
public class HW2 {/**
	 * 
	 */

	/**
	 * @author MJ
	 *
	

		/**
		 * @param args
		 */
		public static void main(String[] args) {
			
			Course course1 = new Course("MIST352", "Businsess Application Programming","MJ Ahmad");
			Course course2 = new Course("CS101", "Introd. to Computer Science","Sarah Jones");
			Student student1 = new Student("Ashley Jaber");
			Student student2 = new Student("Ali June");
			
			//Keep If statements the way they are.
			if (course1.enrollStudent()) 
				{System.out.println("Enrolling Ashley Jaber in MIST352 successful");
				
				}

			else
				{System.out.println("Enrolling Ashley Jaber in MIST352 not successful");
		       
				
				}
			 // b. printout the Current enrollment
	        System.out.println("Current enrollment " + course1.getCurrentEnrollment());
	        // c. adding three grades for the MIST352 course. 
	        double[] gradesMIST352 = {95, 60, 80}; // had a rough time on the second test, but picked it up for the third
	        double avgMIST352 = (gradesMIST352[0] + gradesMIST352[1] + gradesMIST352[2]) / 3;
	        // d. printout the average of those grades
	        System.out.println("The current GPA is: " + avgMIST352);

			if (course2.enrollStudent())
				{System.out.println("Enrolling Ashley Jaber in CS101 successful");
			
				}

			else
				{System.out.println("Enrolling Ashley Jaber in CS101 not successful");
				
				}
			 System.out.println("Current enrollment " + course2.getCurrentEnrollment());
			 double[] gradesCS101 = {55, 85, 90}; // the three grades for CS 101
		        double avgCS101 = (gradesCS101[0] + gradesCS101[1] + gradesCS101[2]) / 3;
		        System.out.println("The current GPA is: " + avgCS101);
			
		     // f. trying to enroll Ali June to both classes
			if (course1.enrollStudent())
				{System.out.println("Enrolling Ali June in MIST352 successful");
					
				}

			else
				{System.out.println("Enrolling Ali June in MIST352 not successful");
					
				}
			
			if (course2.enrollStudent()) 
				{ System.out.println("Enrolling Ali June in CS101 successful");
					
				}
			else
				{System.out.println("Enrolling Ali June in CS101 not successful");
					
				}
			//7C. The program won't enroll Ali in these courses because the enrollment limit has a fixed value of 30 so when we attempt to enroll ashley into the class the enrollment count for each course reaches the maximum limit, thus we are unable to enroll her.
			//Add your code below for question 8
			//Question 8
			 if (avgMIST352 > avgCS101) {
		            System.out.println("Ashley's GPA in MIST352 is greater than in CS101.");
		        } else if (avgMIST352 < avgCS101) {
		            System.out.println("Ashley's GPA in CS101 is greater than in MIST352.");
		        } else {
		            System.out.println("Ashley's GPA in MIST352 and CS101 are equal.");
		        }
		    }
			

	}

