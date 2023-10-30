public class Student {

    // secret stash for our student info
    private String name;  // the name
    private int id;       // your number
    private String major; // what's the major
    private String dob;   // their DOB
    private int hours;    // study hours

    // default constructor
    public Student() {
        // maybe some defaults here?
    }

    // setters

    public void setName(String theName) {
        this.name = theName;  // updates the students name
    }

    public void setID(int theID) {
        this.id = theID;  // set the id. the unique identifier for the student
    }

    public void setMajor(String theMajor) {
        this.major = theMajor;  // sets the major
    }

    public void setDOB(String theDOB) {
        this.dob = theDOB;  // sets the DOB of the student, we dont use age here bc in the database it'll increase redundancy
    }

    public void setHours(int hours) {
        this.hours = hours;  // sets the hours.
    }

    // getters

    public String getName() {
        return this.name; // fetches the name
    }

    public int getID() {
        return this.id;  // fetches that unique identifier or primary key that i mentioned earlier for the student
    }

    public String getMajor() {
        return this.major;  // fetches the students major
    }

    public String getDOB() {
        return this.dob;  // retrieves the DOB
    }

    public int getHours() {
        return this.hours; // fetches the hours 
    }
}
