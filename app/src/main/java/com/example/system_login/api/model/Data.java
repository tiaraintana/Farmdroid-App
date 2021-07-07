package com.example.system_login.api.model;

import java.io.Serializable;

public class Data implements Serializable {

    private String tanggal;
    private String judul;
    private String note;
    private String key;

    public Data() {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return " " + tanggal + "\n" +
                " " + judul + "\n" +
                " " + note;
    }

    public Data(String nm, String mrk, String hrg) {
        tanggal = nm;
        judul = mrk;
        note = hrg;
    }
}