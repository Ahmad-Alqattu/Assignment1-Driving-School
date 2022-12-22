package edu.cs.birzeit.assignment1_driving_school.model;

import java.util.List;

public interface IStudentDA {
    public List<String> showStudents();
    public void addStudentsToTable(Student s);
}
