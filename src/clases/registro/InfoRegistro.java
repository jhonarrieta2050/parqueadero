package clases.registro;

import clases.personal.PersonaCarnet;

import java.time.LocalDate;

public class InfoRegistro {
    private PersonaCarnet persona;
    private int placaVehiculo;
    private LocalDate fech;
    private int NCubiculo;

    public InfoRegistro(PersonaCarnet carnet, int placaVehiculo,int cubiculo){
        this.persona = carnet;
        this.placaVehiculo = placaVehiculo;
        this.fech = LocalDate.now();
        this.NCubiculo = cubiculo;
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

    public int getNCubiculo() {
        return NCubiculo;
    }

    public void setNCubiculo(int NCubiculo) {
        this.NCubiculo = NCubiculo;
    }
}
