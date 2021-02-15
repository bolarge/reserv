package com.peyspec.reserv.reservation.domain.repository;

import com.peyspec.reserv.reservation.domain.entity.Reservation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Bolaji Salau
 */
@Repository("reservationRepository")
public class InMemReservationRepository implements ReservationRepository<Reservation, String> {

    private Map<String, Reservation> entities;

    /**
     * Initialize the in-memory Restaurant Repository with empty Map
     */
    public InMemReservationRepository() {
        entities = new HashMap();
        Reservation restaurant = new Reservation("Le Meurice", "1", "228 rue de Rivoli, 75001, Paris", null);
        entities.put("1", restaurant);
        restaurant = new Reservation("L'Ambroisie", "2", "9 place des Vosges, 75004, Paris", null);
        entities.put("2", restaurant);
        restaurant = new Reservation("Arpège", "3", "84, rue de Varenne, 75007, Paris", null);
        entities.put("3", restaurant);
        restaurant = new Reservation("Alain Ducasse au Plaza Athénée", "4", "25 avenue de Montaigne, 75008, Paris", null);
        entities.put("4", restaurant);
        restaurant = new Reservation("Pavillon LeDoyen", "5", "1, avenue Dutuit, 75008, Paris", null);
        entities.put("5", restaurant);
        restaurant = new Reservation("Pierre Gagnaire", "6", "6, rue Balzac, 75008, Paris", null);
        entities.put("6", restaurant);
        restaurant = new Reservation("L'Astrance", "7", "4, rue Beethoven, 75016, Paris", null);
        entities.put("7", restaurant);
        restaurant = new Reservation("Pré Catelan", "8", "Bois de Boulogne, 75016, Paris", null);
        entities.put("8", restaurant);
        restaurant = new Reservation("Guy Savoy", "9", "18 rue Troyon, 75017, Paris", null);
        entities.put("9", restaurant);
        restaurant = new Reservation("Le Bristol", "10", "112, rue du Faubourg St Honoré, 8th arrondissement, Paris", null);
        entities.put("10", restaurant);
    }

    /**
     * Check if given restaurant name already exist.
     *
     * @param name
     * @return true if already exist, else false
     */
    @Override
    public boolean containsName(String name) {
        try {
            return this.findByName(name).size() > 0;
        } catch (Exception ex) {
            //Exception Handler
        }
        return false;
    }

    /**
     *
     * @param entity
     */
    @Override
    public void add(Reservation entity) {
        entities.put(entity.getId(), entity);
    }

    /**
     *
     * @param id
     */
    @Override
    public void remove(String id) {
        if (entities.containsKey(id)) {
            entities.remove(id);
        }
    }

    /**
     *
     * @param entity
     */
    @Override
    public void update(Reservation entity) {
        if (entities.containsKey(entity.getId())) {
            entities.put(entity.getId(), entity);
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public boolean contains(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Reservation get(String id) {
        return entities.get(id);
    }

    /**
     *
     * @return
     */
    @Override
    public Collection<Reservation> getAll() {
        return entities.values();
    }

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Reservation> findByName(String name) throws Exception {
        Collection<Reservation> restaurants = new ArrayList();
        int noOfChars = name.length();
        entities.forEach((k, v) -> {
            if (v.getName().toLowerCase().contains(name.toLowerCase().subSequence(0, noOfChars))) {
                restaurants.add(v);
            }
        });
        return restaurants;
    }

}
