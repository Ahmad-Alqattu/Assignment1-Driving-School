package edu.cs.birzeit.assignment1_driving_school.model;

import java.util.ArrayList;
import java.util.List;

public class TeacherDa {
    public static TeacherDa TeacherDa_1;
    public List<Teacher> Teachers;

    public static TeacherDa getInstance()
    {
        if (TeacherDa_1 == null)
            TeacherDa_1 = new TeacherDa();

        return TeacherDa_1;
    }

    public TeacherDa() {
        Teachers = new ArrayList<>();

        Teachers.add(new Teacher("ibrahim asfor", "ibrahim@gmail.com", "12345"));
        Teachers.add(new Teacher("ahmad luay", "ahmadl.qatu@gmail.com", "1235"));
        Teachers.add(new Teacher("sajed abed", "sajed@gmail.com", "1235"));
    }


    public void addTeachersToTable(Teacher s)
    {
        getInstance().Teachers.add(s);
    }

}
