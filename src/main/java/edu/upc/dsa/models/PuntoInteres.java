package edu.upc.dsa.models;

import java.util.LinkedList;

public class PuntoInteres {
    String id;
    String name;
    LinkedList<User> listaUsersVisited = null;

    public PuntoInteres() {}

    public PuntoInteres(String id, String name) {
        this.id = id;
        this.name = name;
        this.listaUsersVisited = new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<User> getListaUsersVisited() {
        return listaUsersVisited;
    }

    public void setListaUsersVisited(LinkedList<User> listaUsersVisited) {
        this.listaUsersVisited = listaUsersVisited;
    }

    public void addToList(User user) {
        this.listaUsersVisited.add(user);
    }
}
