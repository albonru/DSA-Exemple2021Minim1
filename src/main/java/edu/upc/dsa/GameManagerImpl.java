package edu.upc.dsa;

import edu.upc.dsa.models.PuntoInteres;
import edu.upc.dsa.models.User;

import java.util.*;
import java.util.logging.Logger;

public class GameManagerImpl implements GameManager {

    LinkedList<User> listaUsuarios = new LinkedList<>();

    static final Logger logger = Logger.getLogger(GameManagerImpl.class.getName());
    private static GameManagerImpl manager;

    //Singleton
    public static GameManagerImpl getInstance(){
        if(manager==null){
            manager= new GameManagerImpl();
        }
        return manager;
    }

    private GameManagerImpl() {}

    @Override
    public void addUser(User user) {
        boolean found = false;

        for (User u: this.listaUsuarios) {
            if (u.getId().equals(user.getId())) {
                found = true;
                logger.info("User already exists");
            }
        }

        if (!found) {
            this.listaUsuarios.add(user);
            logger.info("User added");
        }
    }

    @Override
    public List<User> getUsersList() {
        LinkedList<User> llista = new LinkedList<User>(this.listaUsuarios);

        Collections.sort(llista, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        logger.info("Users list (alph. descendent): " + llista.toString());
        return llista;
    }

    @Override
    public User consultUser(String id) {
        boolean found = false;
        User user = null;
        for (User u: this.listaUsuarios) {
            if (u.getId().equals(id)) {
                found = true;
                user = u;
            }
        }
        if (found) {
            logger.info("User " + user.getName() + " with id " + id +" has been found");
        }
        else {
            logger.info("User id " + id + " has NOT been found");
        }
        return user;
    }

    @Override
    public void informMovement(User user, PuntoInteres punto) {
        user.addToList(punto);
        punto.addToList(user);
        logger.info("User " + user.getName() + "has moved to " + punto.getName());
    }

    @Override
    public List<PuntoInteres> consultPuntosUser(User user) {
        return user.getListaPuntosVisitados();
    }

    @Override
    public List<User> listaUsersEnPunto(PuntoInteres punto) {
        return punto.getListaUsersVisited();
    }

    @Override
    public List<User> listaUsersPorPuntos() {
        LinkedList<User> llista = new LinkedList<>(this.listaUsuarios);

        Collections.sort(llista, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getListaPuntosVisitados().size(), o2.getListaPuntosVisitados().size());
            }
        });
        Collections.reverse(llista);
        return llista;
    }

    // funcions auxiliars

    public void clear() {
        this.listaUsuarios.clear();
    }
}
