package com.example.demo;

public class Table {


    private Integer Numtab;

    public Integer getNumtab() {
        return Numtab;
    }

    public void setNumtab(Integer numtab) {
        Numtab = numtab;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setNbreplace(Integer nbreplace) {
        this.nbreplace = nbreplace;
    }

    public String getEtat() {
        return etat;
    }

    public Integer getNbreplace() {
        return nbreplace;
    }

    public Table(Integer numtab, String etat, Integer nbreplace) {
        Numtab = numtab;
        this.etat = etat;
        this.nbreplace = nbreplace;
    }

    private String etat;
    private Integer nbreplace;
}
