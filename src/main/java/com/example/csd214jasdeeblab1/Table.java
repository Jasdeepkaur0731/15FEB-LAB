package com.example.csd214jasdeeblab1;

import javafx.scene.control.TableColumn;

public class Table {

    private int ID;
    private String Name;
    private String Subject;
    private int ExaminationHall;


    public Table(int ID, String name, String subject, int examinationHall) {
        this.ID = ID;
        Name = name;
        Subject = subject;
        ExaminationHall = examinationHall;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public int getExaminationHall() {
        return ExaminationHall;
    }

    public void setExaminationHall(int examinationHall) {
        ExaminationHall = examinationHall;
    }
}