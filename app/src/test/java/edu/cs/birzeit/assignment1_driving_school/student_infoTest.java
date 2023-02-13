package edu.cs.birzeit.assignment1_driving_school;

import org.junit.Test;

import static org.junit.Assert.*;
public class student_infoTest{
    @Test
    public void calculatePaymentTest(){
        student_info s = new student_info();
        assertEquals(50, s.calculatePayment(200,250));
    }

}
