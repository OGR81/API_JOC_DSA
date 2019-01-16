package edu.upc.dsa.modelos;

public class PNJ {

    private String idPNJ;
    private int idMap;
    private int type;
    private String dialogue1;
    private String dialogue2;
    private String dialogue3;
    private String dialogue4;
    private int idPosition;

    public PNJ() {
    }

    public PNJ(String idPNJ, int idMap, int type, String dialogue1, String dialogue2,
               String dialogue3, String dialogue4, int idPosition) {
        this.idPNJ = idPNJ;
        this.type = type;
        this.idMap = idMap;
        this.dialogue1 = dialogue1;
        this.dialogue2 = dialogue2;
        this.dialogue3 = dialogue3;
        this.dialogue4 = dialogue4;
        this.idPosition = idPosition;
    }

    public String getidPNJ() {
        return idPNJ;
    }

    public void setIdPNJ(String idPNJ) {
        this.idPNJ = idPNJ;
    }

    public int getidMap() {
        return idMap;
    }

    public void setDialogue1(String dialogue1) {
        this.dialogue1 = dialogue1;
    }

    public String getDialogue1() {
        return dialogue1;
    }

    public void setDialogue2(String dialogue2) {
        this.dialogue2 = dialogue2;
    }

    public String getDialogue2() {
        return dialogue2;
    }

    public void setDialogue3(String dialogue3) {
        this.dialogue3 = dialogue3;
    }

    public String getDialogue3() {
        return dialogue3;
    }

    public void setDialogue4(String dialogue4) {
        this.dialogue4 = dialogue4;
    }

    public String getDialogue4() {
        return dialogue4;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public int getIdPosition() {
        return idPosition;

    }
}