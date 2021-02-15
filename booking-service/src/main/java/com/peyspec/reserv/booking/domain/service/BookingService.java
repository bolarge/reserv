package com.peyspec.reserv.booking.domain.service;

import com.peyspec.reserv.booking.domain.entity.Booking;
import com.peyspec.reserv.booking.domain.entity.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author Bolaji Salau
 */
public interface BookingService {

    public void add(Booking booking) throws Exception;

    public void update(Booking booking) throws Exception;

    public void delete(String id) throws Exception;

    public Entity findById(String id) throws Exception;

    public Collection<Booking> findByName(String name) throws Exception;

    public Collection<Booking> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}
