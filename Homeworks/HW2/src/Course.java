public class Course {

    // making the details about the course private like the instructor name, course code, and course title
    private String courseCode, courseTitle, instructorName;
    
    // making the maximum capacity of the course an integer since you cant have decimal values or a part of a person
    private int maximumCapacity;
    
    // tells how many students are currently in the class
    private int currentEnrollment;

    // setting up the building blocks by making those long names a little shorter
    public Course(String code, String title, String instructor) {
        courseCode = code;
        courseTitle = title;
        instructorName = instructor;
        
        // making the maximum capacity equal to 30
        maximumCapacity = 30;
        currentEnrollment = 29; // making the current enrollment 29 and storing the value
    }

    // getting the course code and returning the course code
    public String getCourseCode() {
        return courseCode;
    }

    // name or title of the course
    public String getCourseTitle() {
        return courseTitle;
    }

    // gets the instructors name and returns the name of the instructor
    public String getInstructorName() {
        return instructorName;
    }

    // gets that current enrollment of 29 that we stored earlier and returns it
    public int getCurrentEnrollment() {
        return currentEnrollment;
    }

    // gets that maximum capacity of 30 that we stored earlier and returns it
    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    // basically seeing if theres room to add a student or not by making an if statement and saying if the current enrollment is less then the maximum capacity that the student can join.
    public boolean enrollStudent() {
        if (currentEnrollment < maximumCapacity) {
            currentEnrollment++; // welcome aboard!
            return true;
        } else {
        	System.out.println("Sorry no more room in" + courseTitle +"bud. see if you can get an override from the instructor");
            // since it exceeds maximum, the student cannot register
            return false;
        }
    }
}
