
import Digimons.*;
import Metodos.MetodosDigimon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // crear digimon del Usuario, creado de una forma
        Agumon userDigi = new Agumon("Agumon", "Niño", 20,
                20,1, 0, 5, 5, 5);

        // Oponente Inicial, creado de otra forma
        Agumon enemiDigimon = new Agumon();
        enemiDigimon.setNivel(1);
        enemiDigimon.setNombre("Agumon");
        enemiDigimon.setEtapaDigievolutiva("Niño");
        enemiDigimon.setMaxHP(15);
        enemiDigimon.setVidaActual(15);
        enemiDigimon.setFuerza(3);
        enemiDigimon.setDefensa(3);
        enemiDigimon.setAgilidad(3);

        String repetir="";

        boolean verify = true;
        int laPalanca=0;


        do{
            System.out.println("=== Menu Principal ===\n" +
                    "elija una de las siguientes opciones segun lo que usted desea\n" +
                    "1- Pelear Contra un digimon\n" +
                    "2- Guardar Partida\n"+
                    "3- Cargar Partida\n" +
                    "4- Cerrar el juego\n");
            Scanner scOpcion = new Scanner(System.in);

            // La palanca

            try{
                laPalanca = scOpcion.nextInt();
                switch(laPalanca){
                    case 1:// Pelea Iniciada
                        System.out.println("Ingresaste en el modo de pelea");


                        //aca esta el case 1
                        System.out.println("Un " + enemiDigimon.getNombre() + " salvaje a aparecido");
                        System.out.println(userDigi.getNombre() + ", Te elijo a ti");

                        boolean seguirPeleando = true;
                        while (userDigi.getVidaActual()>0 && enemiDigimon.getVidaActual()>0 && seguirPeleando==true) {
                            // tu turno
                            System.out.println(userDigi.getNombre() + ", es tu turno");
                            System.out.println("" +
                                    "1- Atacar\n"+
                                    "2- DigiEvolucionar\n"+
                                    "3- Guardar y cerrar\n");
                            System.out.println("Elije una opcion");
                            Scanner sc2 = new Scanner(System.in);

                            int eleccion = sc2.nextInt();

                            switch (eleccion) {
                                case 1:
                                    //el movimiento sera predefinido por ser esta una version incompleta
                                    float daño = MetodosDigimon.elDaña(userDigi.ataques(1), userDigi);

                                    //hay que descontar la vida y usar la defensa
                                    float dañoReducido = MetodosDigimon.esDañado(daño, enemiDigimon);
                                    enemiDigimon.setVidaActual(enemiDigimon.getVidaActual()-dañoReducido);
                                    System.out.println(userDigi.getNombre() + " a atacado he hizo " + daño + " puntos de " +
                                            "daño neto... pero en realidad inflingio "+dañoReducido + " por la propia defensa" +
                                            " de " + enemiDigimon.getNombre() + " salvaje");
                                    
                                case 2:
                                    //evolucionar metodo va aqui
                                    System.out.println("Ingrese en que quiere evolucionar, la primera letra en mayuscula");
                                    Scanner scEvolutivo = new Scanner(System.in);
                                    String digiEvol =scEvolutivo.next();
                                    userDigi = userDigi.digiEvolucion(userDigi, digiEvol);
                                    if (digiEvol == "Greymon"){
                                        userDigi.setNombre("Greymon");
                                    }
                                    if (digiEvol == "Ikkakumon"){
                                        userDigi.setNombre("Ikkakumon");
                                    }
                                    if (digiEvol == "Garurumon"){
                                        userDigi.setNombre("Garurumon");
                                    }
                                    break;
                                case 3:
                                    // meter lo de guardar

                                    System.out.println("Ingrese el nombre a poner para el archivo de guardado," +
                                            "si es su primera vez se recomienda un nombre que indique quien es");
                                    Scanner scGuardar = new Scanner(System.in);
                                    String nombreArchivo = scGuardar.next();
                                    MetodosDigimon.guardarEstado(nombreArchivo, userDigi, enemiDigimon);
                                    //con esto sale del combate
                                    seguirPeleando = false;
                                    
                                default:
                                    System.out.println("Opcion Invalida");
                                    break;
                            }

                            // turno enemigo
                            if (enemiDigimon.getVidaActual()>0) {
                                System.out.println(enemiDigimon.getNombre() + " salvaje ataca");

                                // daño que emite el digimon
                                float daño = MetodosDigimon.elDaña(enemiDigimon.ataques(1), enemiDigimon);

                                float dañoReducido = MetodosDigimon.esDañado(daño, userDigi);
                                userDigi.setVidaActual(userDigi.getVidaActual()-dañoReducido);
                                System.out.println(enemiDigimon.getNombre() + " salvaje a atacado he hizo " + daño + " puntos de daño neto..."+
                                        "pero en realidad inflingio "+dañoReducido + " por la propia defensa de " + userDigi.getNombre());
                            }else{break;}
                        }

                        // Quien gano
                        if (userDigi.getVidaActual()>0 && enemiDigimon.getVidaActual()<0) {
                            System.out.println(userDigi.getNombre() + " derroto a " + enemiDigimon.getNombre() + " salvaje");
                            // La parte que gusta
                            int experienciaObtenida = MetodosDigimon.cuantaExperienciaVale(enemiDigimon);
                            int nivelOrignal = userDigi.getNivel();
                            int nivelObtenido = MetodosDigimon.subirNivel(userDigi, experienciaObtenida);
                            userDigi.crecimientoDigimon(userDigi, nivelObtenido - nivelOrignal);
                            System.out.println(userDigi.getNombre() + " gano " + experienciaObtenida + " puntos de experiencia y subio "
                                    + (nivelObtenido - nivelOrignal) + " niveles");

                        } else if (userDigi.getVidaActual()<0 && enemiDigimon.getVidaActual()>0){//manco
                            System.out.println(userDigi.getNombre() + " fue derrotado por " + enemiDigimon.getNombre() + " salvaje!");
                        }
                        break;
                    case 2:
                        System.out.println("Ingrese el nombre a poner para el archivo de guardado," +
                                "si es su primera vez se recomienda un nombre que indique quien es" +
                                "." +
                                "." +
                                "." +
                                "No Apagar la consola");
                        Scanner scGuardar = new Scanner(System.in);
                        String nombreArchivo = scGuardar.next();
                        MetodosDigimon.guardarEstado(nombreArchivo, userDigi, enemiDigimon);
                        break;
                    case 3://cargar
                        System.out.println("Ingrese el nombre del archivo en el que usted guardo la partida");

                        Scanner scCargar = new Scanner(System.in);
                        nombreArchivo = scCargar.next();
                        MetodosDigimon.cargarEstado(nombreArchivo, userDigi, enemiDigimon);



                    case 4://Cerrar el programa
                        System.out.println("Cerrando el programa");
                        verify = true;
                        break;
                    default:
                        System.out.println("Cierre de emergencia");
                        verify = true;
                        break;

                }


                break;
            }catch(Exception ex){
                System.out.println("No Ingresaste algo que fuese un numero");
            }

        }while(verify==true);

        System.out.println("Gracias por probar esta abominacion encontra de todo fan the digimon");


        Scanner scGuardar2 = new Scanner(System.in);
        MetodosDigimon.guardarEstado("salvado", userDigi, enemiDigimon);
    }
}
