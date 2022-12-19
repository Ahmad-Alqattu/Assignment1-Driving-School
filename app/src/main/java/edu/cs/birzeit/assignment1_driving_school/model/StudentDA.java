package edu.cs.birzeit.assignment1_driving_school.model;

import java.util.ArrayList;
import java.util.List;

public class StudentDA implements IStudentDA{

    private List<Student> students;

    public StudentDA() {
        students = new ArrayList<>();

        students.add(new Student("ibrahim", "144", "0599234567", "male", "manual"));
        students.add(new Student("fatma", "224", "0599999924", "female", "manual"));
        students.add(new Student("alaa", "234", "0599999924", "male", "automatic"));
        students.add(new Student("yasmeen", "658", "0598021558", "female", "automatic"));
        students.add(new Student("ahmad", "164", "0598574578", "male", "truck"));
    }


    public void addStudentsToTable(Student s)
    {
        students.add(s);
    }

    public List<String> showStudents(){
        List<String> allStudents = new ArrayList<>();
        for(Student s: students){
            allStudents.add(s.getName() + "\n");
        }
        return allStudents;
    }

}
