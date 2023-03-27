package Digimons;

public class Greymon extends Digimon{
    public Greymon() {
    }
    public Greymon(String nombre, String etapaDigievolutiva, float maxHP, float vidaActual, int nivel, int XP, float fuerza, float defensa, float agilidad) {
        super(nombre, etapaDigievolutiva, maxHP, vidaActual, nivel, XP, fuerza, defensa, agilidad);
    }

    public int ataques(int seleccion){
        int daño= 0;

        //verifica si se eliijio con exito un ataque
        //sera mas usado en futuras actualizaciones
        //boolean verify = false;
        //verifica si se eliijio con exito un ataque
        //sera mas usado en futuras actualizaciones
        //todo, que haya un menu donde se ponga los nombres de los movimientos, se puede con darle una variable por
        // nombre de movimineto y que se seleccione
        try{
            switch(seleccion){
                case 1:
                    System.out.println("Fuego Azul");
                    daño = 70;
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

            digimonCrecido.setMaxHP(digimonPorCrecer.getMaxHP()*+(7 * restaEntreNivelOriginalYNivelObtenido));
            digimonCrecido.setFuerza(digimonPorCrecer.getFuerza()*+(7 * restaEntreNivelOriginalYNivelObtenido));
            digimonCrecido.setDefensa(digimonPorCrecer.getDefensa()*+(5 * restaEntreNivelOriginalYNivelObtenido));
            digimonCrecido.setAgilidad(digimonPorCrecer.getAgilidad()*+(5 * restaEntreNivelOriginalYNivelObtenido));
        };

        return digimonCrecido;
    }


}
