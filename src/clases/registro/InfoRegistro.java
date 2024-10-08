package clases.registro;

import clases.estacionamiento.Cubiculo;
import clases.personal.PersonaCarnet;

import java.time.LocalDate;
import java.util.ArrayList;

public class InfoRegistro {
    private PersonaCarnet persona;
    private int placaVehiculo;
    private LocalDate fecha;
    private Cubiculo cubiculo;
    private boolean vencido;

    public InfoRegistro(PersonaCarnet carnet, int placaVehiculo, Cubiculo cubiculo) {
        this.persona = carnet;
        this.placaVehiculo = placaVehiculo;
        this.fecha = LocalDate.now();
        this.cubiculo = cubiculo;
        this.vencido = false;
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
        return fecha;
    }

    public void setFech(LocalDate fech) {
        this.fecha = fech;
    }

    public Cubiculo getCubiculo() {
        return cubiculo;
    }

    public void setCubiculo(Cubiculo cubiculo) {
        this.cubiculo = cubiculo;
    }


    public boolean isVencido() {
        return vencido;
    }

    public void setVencido(boolean vencido) {
        this.vencido = vencido;
    }
        @Override
        public String toString () {
            return "InfoRegistro{" +
                    "persona=" + persona.getNombre() + persona.getApellido() +
                    ", Placa del vehiculo=" + placaVehiculo +
                    ", fecha=" + fecha +
                    ", cubiculo numero=" + cubiculo +
                    '}';

        }
    }
