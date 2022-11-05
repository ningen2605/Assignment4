package courses.assignment4;

import java.io.IOException;

/**
 * Course Database Element class
 * @author Ricardo Abuabara
 */
public class CourseDBElement{
    protected String ID;
    protected int crn;
    protected int credits;
    protected String room;
    protected String instructorName;

    /**
     * Default constructor
     */
    public CourseDBElement() {
        this.ID = null;
        this.crn = 00000;
        this.credits = 0;
        this.room = null;
        this.instructorName = null;
    }

    /**
     * constructor to assign values to following fields
     * @param id
     * @param crn
     * @param credits
     * @param roomNum
     * @param instructor
     * @throws IOException
     */
    public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
    ID = id;
    this.crn = crn;
    this.credits = credits;
    room = roomNum;
    instructorName = instructor;
    }

    /**
     * returns value of ID
     * @return ID value to assign to ID field
     */
    public String getID() {
        return ID;
    }

    /**
     * returns value of room
     * @return room value to assign to room field
     */
    public String getRoomNum() {
        return room;
    }

    /**
     * returns value of crn
     * @return crn value to assign to crn field
     */
    public int getCRN() {
        return crn;
    }

    /**
     * returns the hashcode of the parse crn to string
     * @return
     */
    public int hashCode(){
        String crn1= Integer.toString(crn);
        return crn1.hashCode();
    }

    /**
     *
     * @return return string format of course
     */
    public String toString(){
        String course = "Course:"+ID+ " CRN:"+crn+" Credits:"+credits+
                " Instructor:"+instructorName+" Room:"+ room;
        return course;
    }

    /**
     * sets value to crn field
     * @param crn value to assign to crn field
     */
    public void setCRN(int crn) {
        this.crn=crn;
    }
}
