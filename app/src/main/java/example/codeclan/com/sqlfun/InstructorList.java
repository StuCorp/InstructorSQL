package example.codeclan.com.sqlfun;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by user on 06/07/2017.
 */


public class InstructorList {
    private ArrayList<Instructor> instructors;

    public InstructorList() {
        instructors = new ArrayList<Instructor>();
        instructors.add(new Instructor("Ally", "Java"));
        instructors.add(new Instructor("Steve", "Java"));
        instructors.add(new Instructor("Alan", "JavaScript"));
        instructors.add(new Instructor("John", "ADA95"));
    }

    public ArrayList<Instructor> getInstructors(){
        return new ArrayList<>(instructors);
    }

}
