package clases.registro;

import clases.estacionamiento.Cubiculo;
import clases.personal.PersonaCarnet;

import java.time.LocalDate;
import java.util.ArrayList;

public class InfoRegistro {
    private PersonaCarnet persona;
    private int placaVehiculo;
    private LocalDate fech;
    private Cubiculo cubiculo;

    public InfoRegistro(PersonaCarnet carnet, int placaVehiculo,Cubiculo cubiculo){
        this.persona = carnet;
        this.placaVehiculo = placaVehiculo;
        this.fech = LocalDate.now();
        this.cubiculo = cubiculo;
    }

    public PersonaCarnet getPersona() {
        return persona;
    }

    public void setPersona(PersonaCarnet persona) {
        this.persona = persona;
    }

    public int getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(int placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public LocalDate getFech() {
        return fech;
    }

    public void setFech(LocalDate fech) {
        this.fech = fech;
    }

    public Cubiculo getCubiculo() {
        return cubiculo;
    }

    public void setCubiculo(Cubiculo cubiculo) {
        this.cubiculo = cubiculo;
    }
}
