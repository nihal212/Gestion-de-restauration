package com.example.demo;

public class TablesControl {
    private Integer numtab;
    private Integer nbrplace;
    private String etatab;
    public void setNumtab(Integer numtab){
        this.numtab=numtab;
    }
    public void setNbrplace(Integer nbrplace){
        this.nbrplace=nbrplace;
    }
    public void setEtatab(String etatab){
        this.etatab=etatab;
    }
    public Integer getNumtab(){ return numtab;}
    public Integer getNbrplace(){ return nbrplace;}
    public String getEtatab(){ return etatab;}
}
