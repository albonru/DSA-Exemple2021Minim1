package edu.upc.dsa;

import edu.upc.dsa.models.PuntoInteres;
import edu.upc.dsa.models.User;

import java.util.List;

public interface GameManager {
    public void addUser(User user);
    public List<User> getUsersList(); //alfabeticamente
    public User consultUser(String id);
    public void informMovement(User user, PuntoInteres punto);
    public List<PuntoInteres> consultPuntosUser(User user);
    public List<User> listaUsersEnPunto(PuntoInteres punto);
    public List<User> listaUsersPorPuntos(); //descendente

    public void clear();
}
