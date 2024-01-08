/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package cs202.turagencija.enums;

/**
 *
 * @author djoki_4zczxr0
 */
public enum PrevozTip {
    AUTOBUS("Autobus"),
    AUTOBUS_DVA_NIVOA("Autobus sa dva nivoa"),
    AVION("Avion"),
    VOZ("Voz");

    private final String toString;

    private PrevozTip(String toString) {
        this.toString = toString;
    }

    @Override
    public String toString() {
        return toString;
    }

}
