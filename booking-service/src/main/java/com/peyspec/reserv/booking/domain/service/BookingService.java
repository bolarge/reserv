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

    /**
     *
     * @param booking
     * @throws Exception
     */
    public void add(Booking booking) throws Exception;

    /**
     *
     * @param booking
     * @throws Exception
     */
    public void update(Booking booking) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    public void delete(String id) throws Exception;

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Entity findById(String id) throws Exception;

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<Booking> findByName(String name) throws Exception;

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<Booking> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}
