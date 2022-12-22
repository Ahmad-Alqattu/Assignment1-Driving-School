package edu.cs.birzeit.assignment1_driving_school.model;

import java.util.ArrayList;
import java.util.List;

public class SessionDA implements ISessionDA{

    private List<Session> sessions;

    public SessionDA(){
        sessions = new ArrayList<>();

        sessions.add(new Session(1,2,2023,11,00,"ibrahim","bmw"));
        sessions.add(new Session(5,4,2023,10,30,"alaa","mercedes"));
        sessions.add(new Session(11,12,2023,15,50,"ali","mazda"));

    }
    @Override
    public void addSessionToTable(Session s){
        sessions.add(s);
    }
    /*
    @Override
    public List<String[]> showDates(){
        List<String[]> dates = new ArrayList<>();
        for(Session s: sessions){
            String[] date= {s.getDay().toString(),s.getMonth().toString(),s.getYear(),String.valueOf(s.getTime())};
            dates.add(date);
        }
        return dates;
    }
    */




}
