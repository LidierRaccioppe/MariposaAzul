package Digimons;

public class Agumon extends Digimon{

    public Agumon() {
    }

    public Agumon(String nombre, String etapaDigievolutiva, float maxHP, float vidaActual, int nivel, int XP, float fuerza, float defensa, float agilidad) {
        super(nombre, etapaDigievolutiva, maxHP, vidaActual, nivel, XP, fuerza, defensa, agilidad);
    }

    //ataques
    public int ataques(int seleccion){
        int daño= 0;
        //verifica si se eliijio con exito un ataque
        //sera mas usado en futuras actualizaciones
        //boolean verify = false;
        //si los ataques tiene un daño superior a una cierta cifra seran considerados como que la cantidad en la que superan
        //esa cifra es daño verdadero y por tanto sobre pasa el limite posible
        //aca se añadiran los demas ataques
        //todo, que haya un menu donde se ponga los nombres de los movimientos, se puede con darle una variable por
        // nombre de movimineto y que se seleccione
        try{
            switch(seleccion){
                case 1:
                    System.out.println("Flama Bebé");
                    daño = 40;
                    //verify = true;
                    break;
                default:
                    System.out.println("Movimiento inexistente");
                    break;
            }
        }catch(Exception ex){
            System.out.println("Usted no Ingreso un numero para el ataque");
        }
        return daño;
    }

    @Override
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

            digimonCrecido.setMaxHP(digimonPorCrecer.getMaxHP()*+(3 * restaEntreNivelOriginalYNivelObtenido));
            digimonCrecido.setFuerza(digimonPorCrecer.getFuerza()*+(3 * restaEntreNivelOriginalYNivelObtenido));
            digimonCrecido.setDefensa(digimonPorCrecer.getDefensa()*+(2 * restaEntreNivelOriginalYNivelObtenido));
            digimonCrecido.setAgilidad(digimonPorCrecer.getAgilidad()*+(2 * restaEntreNivelOriginalYNivelObtenido));
        };
        return digimonCrecido;
    }

    public <T extends Digimon> T digiEvolucion(Digimon digimon, String evolucionDeseada) {

        switch (evolucionDeseada) {
            case "Greymon":
                if (digimon.getNivel() >= 4 && digimon.getFuerza() >= 20) {

                    Greymon digimonEvol = new Greymon();
                    digimon.setMaxHP((digimon.getMaxHP()*2));
                    digimon.setAgilidad(digimon.getAgilidad()*2);
                    digimon.setFuerza(digimon.getFuerza()*3);
                    digimon.setDefensa(digimon.getDefensa()*2);

                    System.out.println(digimon.getNombre() + " a evolucionado en Greymon ");
                    return (T) new Greymon(digimon.getNombre(), "Adulto", digimon.getMaxHP(), digimon.getVidaActual() ,digimon.getNivel(), digimon.getXP(),
                            digimon.getFuerza(), digimon.getDefensa(),
                            digimon.getAgilidad());
                } else {
                    System.out.println("No cumples los requisitos de evolucion");
                    return (T) new Agumon(digimon.getNombre(), "Adulto", digimon.getMaxHP(), digimon.getVidaActual() ,digimon.getNivel(), digimon.getXP(),
                            digimon.getFuerza(), digimon.getDefensa(),
                            digimon.getAgilidad());
                }
            case "Ikkakumon":
                if (digimon.getNivel() >= 4 && digimon.getDefensa() >= 20) {

                    // ya se que Agumon no evoluciona en Ikkakumon
                    Ikkakumon digimonEvol = new Ikkakumon();
                    digimon.setMaxHP(digimon.getMaxHP()*2);
                    digimon.setAgilidad(digimon.getAgilidad()*2);
                    digimon.setFuerza(digimon.getFuerza()*2);
                    digimon.setDefensa(digimon.getDefensa()*3);

                    System.out.println(digimon.getNombre() + " a evolucionado en Ikkakumon ");
                    return (T) new Ikkakumon(digimon.getNombre(), "Adulto", digimon.getMaxHP(), digimon.getVidaActual() ,digimon.getNivel(), digimon.getXP(),
                            digimon.getFuerza(), digimon.getDefensa(),
                            digimon.getAgilidad());
                } else {
                    System.out.println("No cumples los requisitos de evolucion");
                    return (T) new Agumon(digimon.getNombre(), "Adulto", digimon.getMaxHP(), digimon.getVidaActual() ,digimon.getNivel(), digimon.getXP(),
                            digimon.getFuerza(), digimon.getDefensa(),
                            digimon.getAgilidad());
                }
            case "Garurumon":
                if (digimon.getNivel() >= 4 && digimon.getAgilidad() >= 20) {

                    Garurumon digimonEvol = new Garurumon();
                    digimon.setMaxHP(digimon.getMaxHP()*2);
                    digimon.setAgilidad(digimon.getAgilidad()*3);
                    digimon.setFuerza(digimon.getFuerza()*2);
                    digimon.setDefensa(digimon.getDefensa()*2);

                    System.out.println(digimon.getNombre() + " a evolucionado en Garurumon ");
                    return (T) new Garurumon(digimon.getNombre(), "Adulto", digimon.getMaxHP(), digimon.getVidaActual() ,digimon.getNivel(), digimon.getXP(),
                            digimon.getFuerza(), digimon.getDefensa(),
                            digimon.getAgilidad());
                } else {
                    System.out.println("No cumples los requisitos de evolucion");
                    return (T) new Agumon(digimon.getNombre(), "Adulto", digimon.getMaxHP(), digimon.getVidaActual() ,digimon.getNivel(), digimon.getXP(),
                            digimon.getFuerza(), digimon.getDefensa(),
                            digimon.getAgilidad());
                }
            default:
                System.out.println("Ingrese un Nombre correcto o se encuentra en la mas alta etapa de esta version");
                return (T) new Agumon(digimon.getNombre(), "Adulto", digimon.getMaxHP(), digimon.getVidaActual() ,digimon.getNivel(), digimon.getXP(),
                        digimon.getFuerza(), digimon.getDefensa(),
                        digimon.getAgilidad());
        }
    }


}
