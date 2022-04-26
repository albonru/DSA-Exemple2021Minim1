package edu.upc.dsa;

import edu.upc.dsa.models.PuntoInteres;
import edu.upc.dsa.models.User;
import org.apache.log4j.Logger;

public class GameTest {
    private static Logger logger = Logger.getLogger(GameTest.class);
    GameManager manager = GameManagerImpl.getInstance();

    public void setUp() {
        User user1 = new User("318972", "Alba");
        User user2 = new User("23489ewqu", "Aleix");
        manager.addUser(user1);
        manager.addUser(user2);

        PuntoInteres punto1 = new PuntoInteres("adh234", "Puente");
        PuntoInteres punto2 = new PuntoInteres("fKHE3", "Plaza");
        PuntoInteres punto3 = new PuntoInteres("xm98123", "Cafeteria");
        manager.informMovement(user1, punto1);
        manager.informMovement(user1, punto2);
        manager.informMovement(user2, punto3);
    }

    public void tearDown() {
        manager.clear();
    }

    public void generalTest() {
        logger.info("Condicions inicials de la llista d'usuaris: " +  manager.getUsersList().toString());
        logger.info("Condicions inicials usuaris segons punts d'interes: " + manager.listaUsersPorPuntos());

        User user3 = new User("3e92j", "Maria");
        manager.addUser(user3);

        PuntoInteres punto4 = new PuntoInteres("d37", "Biblioteca");
        PuntoInteres punto5 = new PuntoInteres("f3FEw", "Secretaria");
        PuntoInteres punto6 = new PuntoInteres("FNwu73", "Seguretat");
        manager.informMovement(user3, punto4);
        manager.informMovement(user3, punto5);
        manager.informMovement(user3, punto6);

        logger.info("Condicions finals de la llista d'usuaris: " +  manager.getUsersList().toString());
        logger.info("Condicions finals usuaris segons punts d'interes: " + manager.listaUsersPorPuntos());
    }
}
