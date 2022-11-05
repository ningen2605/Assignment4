package courses.assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Course Database Manager class
 * @author Ricardo Abuabara
 */
public class CourseDBManager implements CourseDBManagerInterface {
    CourseDBStructure CDBS = new CourseDBStructure(20);

    /**
     * creates a CourseDatabaseElement object and adds it to the hash table CourseDatabaseStructure
     * @param id course id
     * @param crn course crn
     * @param credits number of credits
     * @param roomNum course room number
     * @param instructor name of the instructor
     */
    @Override
    public void add(String id, int crn, int credits, String roomNum, String instructor) {

           CourseDBElement CDBE = new CourseDBElement(id, crn, credits, roomNum, instructor);
        CDBS.add(CDBE);
    }

    /**
     * uses the course element get method to return course with the given crn
     * @param crn course crn (key)
     * @return course with given crn
     */
    @Override
    public CourseDBElement get(int crn) {
        try {
            return CDBS.get(crn);
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * reads the courses information from the input file
     * @param input input file
     * @throws FileNotFoundException
     */
    @Override
    public void readFile(File input) throws FileNotFoundException {
        Scanner in = new Scanner(input);
        int cred;
        int crn;
        CourseDBElement CDBE;
        String courses;
        String[] course;
        while (in.hasNextLine()){
            courses = in.nextLine();
            course = courses.split(" ", 5);
            crn = Integer.parseInt(course[1]);
            cred = Integer.parseInt(course[2]);
            CDBE = new CourseDBElement(course[0], crn, cred, course[3], course[4]);
            CDBS.add(CDBE);
        }
    }

    /**
     * uses the CourseDatabase Structure showAll method to print all the courses in the database
     * @return all courses in database
     */
    @Override
    public ArrayList<String> showAll() {
        return CDBS.showAll();
    }
}
