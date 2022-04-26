package edu.upc.dsa.models;

import java.util.LinkedList;

public class User {
    String id;
    String name;
    LinkedList<PuntoInteres> listaPuntosVisitados = null;

    public User() {}

    public User(String id) {
        this.id = id;
        this.listaPuntosVisitados = new LinkedList<>();
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.listaPuntosVisitados = new LinkedList<>();
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

    public LinkedList<PuntoInteres> getListaPuntosVisitados() {
        return listaPuntosVisitados;
    }

    public void setListaPuntosVisitados(LinkedList<PuntoInteres> listaPuntosVisitados) {
        this.listaPuntosVisitados = listaPuntosVisitados;
    }

    public void addToList(PuntoInteres punto) {
        this.listaPuntosVisitados.add(punto);
    }
}
