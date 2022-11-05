package courses.assignment4;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Student generate test file for CourseDBManager
 * @author Ricardo Abuabara
 */
public class CourseDBManagerSTUDENT_Test {
    private CourseDBManager manager = new CourseDBManager();

    @Before
    public void setUp() throws Exception {
        manager = new CourseDBManager();
    }

    @After
    public void tearDown() throws Exception {
        manager = null;
    }

    @Test
    public void testShowAll() {
        manager.add("MATH182", 83459, 1, "SW210", "Chuck Norris");
        manager.add("BIO140", 21321, 2, "SC300", "Alex Jones");
        manager.add("PHYS201", 31231, 3, "SC214", "Michio Kaku");
        manager.add("CHEM301", 98745, 4, "HW401", "Nile Red");
        ArrayList<String> list = manager.showAll();

        assertEquals(list.get(0), "\nCourse:MATH182 CRN:83459 Credits:1 Instructor:Chuck Norris Room:SW210");
        assertEquals(list.get(3), "\nCourse:BIO140 CRN:21321 Credits:2 Instructor:Alex Jones Room:SC300");
        assertEquals(list.get(1), "\nCourse:PHYS201 CRN:31231 Credits:3 Instructor:Michio Kaku Room:SC214");
        assertEquals(list.get(2), "\nCourse:CHEM301 CRN:98745 Credits:4 Instructor:Nile Red Room:HW401");
    }

    @Test
    public void testRead() {
        try {
            File inputFile = new File("Test1.txt");
            PrintWriter inFile = new PrintWriter(inputFile);
            inFile.println("PHYS201 31231 3 SC214 Michio Kaku");
            inFile.print("CHEM301 98745 4 HW401 Nile Red");
            inFile.close();
            manager.readFile(inputFile);
        } catch (Exception e) {
            fail("failed, exception thrown");
        }
    }

}
