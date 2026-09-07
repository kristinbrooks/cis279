// CourseSection.java
// Kristin Brooks
// a class that represents a course section at PCC

public class CourseSection {
    private int crn;
    private String department;
    private int courseNumber;
    private String instructionalMode;
    private String meetingDays;
    private String meetingTimes;
    private int capacity;
    private int enrollment;
    private int instructorId;

    public CourseSection() {
        // Constructor assigning all the instance variables default values
        this.crn = 0;
        this.department = "";
        this.courseNumber = 0;
        this.instructionalMode = "";
        this.meetingDays = "";
        this.meetingTimes = "";
        this.capacity = 0;
        this.enrollment = 0;
        this.instructorId = 0;
    } // end of constructor

    public CourseSection(int crn, String dept, int courseNum, String mode, String days, String times, int capacity, int enrollment, int id) {
        // Constructor creating a CourseSection with specified values
        this.crn = crn;
        this.department = dept;
        this.courseNumber = courseNum;
        this.instructionalMode = mode;
        this.meetingDays = days;
        this.meetingTimes = times;
        this.capacity = capacity;
        this.enrollment = enrollment;
        this.instructorId = id;
    } //end of constructor

    public int getCrn() {
        return crn;
    }

    public void setCrn( int crn ) {
        // check that CRN is 5 digits and positive and throw error if it's not
        int length = String.valueOf(Math.abs(crn)).length();
        if ( length != 5 || crn <= 0 ) {
            throw new IllegalArgumentException("CRN must be 5 digits and positive.");
        }
        this.crn = crn;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        // check that department is 3 characters long and throw error if not
        if ( department.length() != 3 ) {
            throw new IllegalArgumentException("Department code must be 3 characters long.");
        }
        this.department = department.toUpperCase();
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        // check that courseNumber is 3 digits and positive and throw error if it's not
        int length = String.valueOf(Math.abs(courseNumber)).length();
        if ( length != 3 || courseNumber <= 0 ) {
            throw new IllegalArgumentException("Course number must be 3 digits and positive.");
        }
        this.courseNumber = courseNumber;
    }

    public String getInstructionalMode() {
        return instructionalMode;
    }

    public void setInstructionalMode(String instructionalMode) {
        // check that it is one of the 3 mode options
        String mode = instructionalMode.toLowerCase();
        if ( !(mode.equals("online") || mode.equals("in-person") || mode.equals("hybrid")) ) {
            throw new IllegalArgumentException("The Instructional mode must be either online, in-person, or hybrid.");
        }
        this.instructionalMode = mode;
    }

    public String getMeetingDays() {
        return meetingDays;
    }

    public void setMeetingDays(String meetingDays) {
        this.meetingDays = meetingDays;
    }

    public String getMeetingTimes() {
        return meetingTimes;
    }

    public void setMeetingTimes(String meetingTimes) {
        this.meetingTimes = meetingTimes;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        // check that capacity is positive
        if ( capacity <= 0 ) {
            throw new IllegalArgumentException("Capacity of a class must be positive.");
        }
        this.capacity = capacity;
    }

    public int getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(int enrollment) {
        // check that enrollment is 0 or greater
        if ( enrollment < 0 ) {
            throw new IllegalArgumentException("Enrollment cannot be less than 0.");
        }
        this.enrollment = enrollment;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        // check that ID is positive
        if ( instructorId <= 0 ) {
            throw new IllegalArgumentException("Instructor ID must be a positive number.");
        }
        this.instructorId = instructorId;
    }

    public String toString() {
        // returns a string representation of the object
        StringBuilder str = new StringBuilder();
        str.append("CRN : ");
        str.append(getCrn());
        str.append("\n");
        str.append("Department : ");
        str.append(getDepartment());
        str.append("\n");
        str.append("Course number : ");
        str.append(getCourseNumber());
        str.append("\n");
        str.append("Instructional mode : ");
        str.append(getInstructionalMode());
        str.append("\n");
        str.append("Meeting days : ");
        str.append(getMeetingDays());
        str.append("\n");
        str.append("Meeting times : ");
        str.append(getMeetingTimes());
        str.append("\n");
        str.append("Capacity : ");
        str.append(getCapacity());
        str.append("\n");
        str.append("Enrollment : ");
        str.append(getEnrollment());
        str.append("\n");
        str.append("Instructor's ID : ");
        str.append(getInstructorId());
        return str.toString();
    } // end of function toString

} // end of class CourseSection
