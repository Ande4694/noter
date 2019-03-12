package com.example.demo.Model;


import java.time.LocalDate;

public class Note {

    private int id;

    private String note;
    private String lastChanged;



    public Note( String note) {

        this.note = note;
        lastChanged = java.time.LocalDate.now().toString();
    }

    public int getId() {
        return id;
    }



    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged() {
        lastChanged = java.time.LocalDate.now().toString();
    }

    public void setId(int id) {
        this.id = id;
    }

    public Note() {
        lastChanged = java.time.LocalDate.now().toString();
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", lastChanged=" + lastChanged +
                '}';
    }
}
