package Digimons;

import java.util.ArrayList;

/**
 * Esto luego se pasara a la interface
 * no lo puse por molestia a tener que poner abstract
 * @author dam1
 */
public class Digimon {

    //nombre del digimon
    private String nombre;

    //niño, adulto y mas por agregar
    private String etapaDigievolutiva;

    //cuantos punto de vida limite superior tiene
    private float maxHP;

    //cuantos puntos de vida tiene actualmente, estos son para el combate
    // y se inician asi para que cada vez que se crea la vida este llena
    private float vidaActual=maxHP;

    //que tanto nivel tiene, sera en base a la cantidad de experiencia
    private int nivel;

    //cuantos puntos de experiencia tiene
    private int XP;

    //cuanta potencia dentran detras los ataques
    private float fuerza;

    //cuanto daño sera reducido
    private float defensa;

    //quien es mas rapido y decidira quien ataca primero;
    private float agilidad;

    private final int numeroEvoluciones = 3;

    public Digimon() {
    }


    public Digimon(String nombre, String etapaDigievolutiva, float maxHP, float vidaActual, int nivel, int XP, float fuerza, float defensa, float agilidad) {
        this.nombre = nombre;
        this.etapaDigievolutiva = etapaDigievolutiva;
        this.maxHP = maxHP;
        this.vidaActual = vidaActual;
        this.nivel = nivel;
        this.XP = XP;
        this.fuerza = fuerza;
        this.defensa = defensa;
        this.agilidad = agilidad;
    }

    //el digimon al subir de nivel deben de aumentar sus estadisticas, de momento se considera que tiene todos sus movimiento al evolucionar
    public Digimon crecimientoDigimon(Digimon digimonPorCrecer, int restaEntreNivelOriginalYNivelObtenido){
        //este es de un agumon
        Digimon digimonCrecido = null;

        // el digimon debe de aumentar sus estadisticas, al ser el base se hara que este sea con un crecimiento constante en todas sus estadisticas

        // crecimiento de digimon generico

        //para no tener que poner los setters y getters de atributos que no cambien al subir de nivel
        digimonCrecido = digimonPorCrecer;

        //es para evitar que los stats se vuelvan cero, si el digimon no sube de nivel
        if(restaEntreNivelOriginalYNivelObtenido!=0){
            // esta forma de crecer solo funciona con el generico por tener crecimiento constante

            digimonCrecido.setMaxHP(digimonPorCrecer.getMaxHP()*+(6 * restaEntreNivelOriginalYNivelObtenido));
            digimonCrecido.setFuerza(digimonPorCrecer.getFuerza()*+(5 * restaEntreNivelOriginalYNivelObtenido));
            digimonCrecido.setDefensa(digimonPorCrecer.getDefensa()*+(5 * restaEntreNivelOriginalYNivelObtenido));
            digimonCrecido.setAgilidad(digimonPorCrecer.getAgilidad()*+(5 * restaEntreNivelOriginalYNivelObtenido));
        };

        return digimonCrecido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEtapaDigievolutiva() {
        return etapaDigievolutiva;
    }

    public void setEtapaDigievolutiva(String etapaDigievolutiva) {
        this.etapaDigievolutiva = etapaDigievolutiva;
    }

    public float getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(float maxHP) {
        this.maxHP = maxHP;
    }

    public float getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(float vidaActual) {
        this.vidaActual = vidaActual;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getXP() {
        return XP;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }

    public float getFuerza() {
        return fuerza;
    }

    public void setFuerza(float fuerza) {
        this.fuerza = fuerza;
    }

    public float getDefensa() {
        return defensa;
    }

    public void setDefensa(float defensa) {
        this.defensa = defensa;
    }

    public float getAgilidad() {
        return agilidad;
    }

    public void setAgilidad(float agilidad) {
        this.agilidad = agilidad;
    }

    public int getNumeroEvoluciones (){return numeroEvoluciones;}
}
