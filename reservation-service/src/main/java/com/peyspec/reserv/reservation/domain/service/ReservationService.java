package com.peyspec.reserv.reservation.domain.service;

import com.peyspec.reserv.reservation.domain.entity.Entity;
import com.peyspec.reserv.reservation.domain.entity.Reservation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author Bolaji Salau
 */
public interface ReservationService {

    /**
     *
     * @param reservation
     * @throws Exception
     */
    public void add(Reservation reservation) throws Exception;

    /**
     *
     * @param reservation
     * @throws Exception
     */
    public void update(Reservation reservation) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    public void delete(String id) throws Exception;

    /**
     *
     * @param reservationId
     * @return
     * @throws Exception
     */
    public Entity findById(String reservationId) throws Exception;

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<Reservation> findByName(String name) throws Exception;

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<Reservation> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}
