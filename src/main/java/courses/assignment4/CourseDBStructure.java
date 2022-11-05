package courses.assignment4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Data Structure class used with the Manager class
 * @author Ricardo Abuabara
 */
public class CourseDBStructure implements CourseDBStructureInterface {
    protected int HashSize = 0;
    protected int elementSize = 0;
    protected LinkedList [] hashTable;

    /**
     * constructor which takes an integer size for hash table
     * @param size represents the size of hash table
     */
    public CourseDBStructure(int size){
        HashSize = size;
        hashTable = new LinkedList[HashSize];
    }

    /**
     * constructor used for testing
     * @param testing string used for testing
     * @param size size of hash table
     */
    public CourseDBStructure(String testing, int size) {
        HashSize = size;
        hashTable = new LinkedList[HashSize];
    }

    /**
     * Adds an element to the hash table
     * @param cde1 the CourseDBElement to be added to CourseDBStructure
     */
    @Override
    public void add(CourseDBElement cde1) {
        int c;
        c = Math.abs(cde1.hashCode())% HashSize;
        LinkedList <CourseDBElement>current = hashTable[c];
        if(current == null)
        {
            hashTable[c] = new LinkedList<CourseDBElement>();
        }
        hashTable[c].add(cde1);
        elementSize++;
    }

    /**
     * Uses the hashcode of CourseDBElement to see if the element
     * @param crn crn (key) whose associated courseDatabaseElement is to be returned
     * @return course with the passed crn
     * @throws IOException thrown when course not found
     */
    @Override
    public CourseDBElement get(int crn) throws IOException {
        String crn1 = Integer.toString(crn);
        int c = Math.abs(crn1.hashCode())% HashSize;
        if(hashTable[c] == null)
        {
            throw new IOException();
        }
        else{
            return (CourseDBElement) hashTable[c].get(0);
        }
    }

    /**
     * Prints all the courses in the database as a string
     * @return list of courses as a string
     */
    public ArrayList<String> showAll() {
        ArrayList<String> courses = new ArrayList<>();
        for(int i = 0; i < HashSize; i++)
        {
            if(hashTable[i] != null){
                for(int j = 0; j < hashTable[i].size(); j++){
                    CourseDBElement element = (CourseDBElement) hashTable[i].get(j);
                    courses.add("\n" + element.toString());
                }
            }
        }
        return courses;
    }

    /**
     * method that returns the size of hash table
     * @return size of hashTable
     */
    @Override
    public int getTableSize() {
        return HashSize;
    }
}
