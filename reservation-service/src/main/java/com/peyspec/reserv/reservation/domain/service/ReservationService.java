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

    public void add(Reservation reservation) throws Exception;

    public void update(Reservation reservation) throws Exception;

    public void delete(String id) throws Exception;

    public Entity findById(String reservationId) throws Exception;

    public Collection<Reservation> findByName(String name) throws Exception;

    public Collection<Reservation> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}
