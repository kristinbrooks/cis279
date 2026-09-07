// CourseSectionDriver.java
// Kristin Brooks
// driver program for CourseSection.java

public class CourseSectionDriver {

    public static void main(String[] args) {
        CourseSection course1 = new CourseSection();
        course1.setCrn(10420);
        course1.setDepartment("CIS");
        course1.setCourseNumber(279);
        course1.setInstructionalMode("online");
        course1.setMeetingDays("N/A");
        course1.setMeetingTimes("N/A");
        course1.setCapacity(30);
        course1.setEnrollment(27);
        course1.setInstructorId(42);

        System.out.println(course1);

        CourseSection course2 = new CourseSection(20123, "CIS", 131, "in-person",
                "MWF", "11:30-12:45", 30, 25, 71);

        System.out.println();
        System.out.println(course2);

        System.out.println();
        System.out.println("krbrooks@mail.pima.edu");
    } // end of main
} // end of class CourseSectionDriver
