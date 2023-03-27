package Metodos;

import Digimons.Digimon;

import java.io.*;

public class MetodosDigimon {

    public static float elDaña( //cuanto daño entrega
                                int dañoDelAtaque //cuanto daño hace el ataque
            , Digimon atacante
    ) {
        //este daño sera el que reciba el digimon
        float dañoPorEnviar;
        // como deberia hacer el daño
        dañoPorEnviar = (float) ( dañoDelAtaque/20 + 2);

        return dañoPorEnviar;
    }

    //este va en una libreria
    public static float esDañado(
            float dañoRecibido, //cuanto daño recibe
            Digimon quienEsDañado //el digimon que es atacado
    ) {
        //este daño sera el que reciba el digimon
        float dañoSufrido;
        //formula de reduccion de daño
        float defensaNatural = ( quienEsDañado.getDefensa()) / 15 + 2;

        dañoSufrido = (float) dañoRecibido - defensaNatural;

        //evite que se haga daño negativo
        if (dañoSufrido < 0) {
            dañoSufrido = 0;
        }
        //este sera descontado de la vida actual del digimon
        return dañoSufrido;
    }

    public static int subirNivel(Digimon queDigimonObtieneXP, int puntosDeExperienciaPorAgregar) {

        int nivelConseguido = queDigimonObtieneXP.getNivel();
        //todo, hacer que aumenten las estadisticas al subir de nivel, hacer metodo

        while (puntosDeExperienciaPorAgregar > 0) {
            if (queDigimonObtieneXP.getNivel() * 2 + 40 < puntosDeExperienciaPorAgregar) {
                nivelConseguido = queDigimonObtieneXP.getNivel() + 1;
                // para que no se pierda la xp al subir de nivel
                puntosDeExperienciaPorAgregar = puntosDeExperienciaPorAgregar - queDigimonObtieneXP.getNivel() * 2 + 40;
            } else {
                queDigimonObtieneXP.setXP(puntosDeExperienciaPorAgregar);
                break;
            }
        }
        return nivelConseguido;
    }

    public static int cuantaExperienciaVale(Digimon porCalcular) {
        //(todo) el valor tres sera despues una constante, que sera afectada por la dificultad seleccionada
        int cuantoVale = (int) (porCalcular.getNivel() * (porCalcular.getFuerza() + porCalcular.getDefensa() * porCalcular.getAgilidad()) / 3);

        return cuantoVale;
    }


    public static void guardarEstado(String fileName, Digimon userDigi, Digimon enemiDigi) {
        try {

            File file = new File(fileName);

            //almacenador, y sobre escribira, para asi evitar problemas
            FileWriter writer = new FileWriter(file);

            // Ingresa el digimon del usuario en el archivo con un orden seperados por la "," y con "contraBarra n" para indicar el fin
            writer.write(userDigi.getNombre() + "," +
                    userDigi.getEtapaDigievolutiva() + "," +
                    userDigi.getMaxHP() + "," +
                    userDigi.getVidaActual() + "," +
                    userDigi.getNivel() + "," +
                    userDigi.getXP() + "," +
                    userDigi.getFuerza() + "," +
                    userDigi.getDefensa() + "," +
                    //este salto de linea sirve para marcar el fin, para el readLine
                    userDigi.getAgilidad() + "\n");

            // Ingresa el digimon del usuario en el archivo con un orden seperados por la "," y con "contraBarra n" para indicar el fin
            writer.write(enemiDigi.getNombre() + "," +
                    enemiDigi.getEtapaDigievolutiva() + "," +
                    userDigi.getMaxHP() + "," +
                    userDigi.getVidaActual() + "," +
                    enemiDigi.getNivel() + "," +
                    enemiDigi.getXP() + "," +
                    enemiDigi.getFuerza() + "," +
                    enemiDigi.getDefensa() + "," +
                    //este salto de linea sirve para marcar el fin, para el readLine
                    enemiDigi.getAgilidad() + "\n");

            writer.close();
            System.out.println("Guardado exitoso");
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    // Carga el estado del juego
    public static void cargarEstado(String fileName, Digimon userDigi, Digimon enemiDigi) {
        try {
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            // obten los datos almacenados
            BufferedReader bufferedReader = new BufferedReader(reader);
            // los guarda
            String line = bufferedReader.readLine();
            //se separaran por la ","
            String[] playerDigimonState = line.split(",");
            userDigi.setNombre(playerDigimonState[0]);
            userDigi.setEtapaDigievolutiva(playerDigimonState[1]);
            userDigi.setMaxHP(Integer.parseInt(playerDigimonState[2]));
            userDigi.setVidaActual(Integer.parseInt(playerDigimonState[3]));
            userDigi.setNivel(Integer.parseInt(playerDigimonState[4]));
            userDigi.setXP(Integer.parseInt(playerDigimonState[5]));
            userDigi.setFuerza(Integer.parseInt(playerDigimonState[6]));
            userDigi.setDefensa(Integer.parseInt(playerDigimonState[7]));
            userDigi.setAgilidad(Integer.parseInt(playerDigimonState[8]));

            //leera la linea hasta un salto de linea \n
            line = bufferedReader.readLine();
            // la "," sirve como cortador
            String[] enemyDigimonState = line.split(",");
            enemiDigi.setNombre(enemyDigimonState[0]);
            enemiDigi.setEtapaDigievolutiva(enemyDigimonState[1]);
            enemiDigi.setMaxHP(Integer.parseInt(enemyDigimonState[2]));
            enemiDigi.setVidaActual(Integer.parseInt(enemyDigimonState[3]));
            enemiDigi.setNivel(Integer.parseInt(enemyDigimonState[4]));
            enemiDigi.setXP(Integer.parseInt(enemyDigimonState[5]));
            enemiDigi.setFuerza(Integer.parseInt(enemyDigimonState[6]));
            enemiDigi.setDefensa(Integer.parseInt(enemyDigimonState[7]));
            enemiDigi.setAgilidad(Integer.parseInt(enemyDigimonState[8]));

            reader.close();
            System.out.println("Carga exitosa");
        } catch (IOException ex) {
            System.out.println("Error en al Guardad o Cargar");
            ex.getMessage();
        }


    }
}