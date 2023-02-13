package edu.cs.birzeit.assignment1_driving_school.model;

public class Session {
    private int day;
    private int month;
    private int year;
    private int time;
    private String name;
    private String car;
    private int m;
    private int h;

    public Session(int day, int month, int year, int h, int m, String name, String car) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.m = m;
        this.h = h;
        this.name = name;
        this.car = car;

    }    public Session(){

    }


    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

}
