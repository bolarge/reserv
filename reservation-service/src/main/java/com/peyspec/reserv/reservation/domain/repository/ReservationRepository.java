package com.peyspec.reserv.reservation.domain.repository;

import java.util.Collection;

/**
 *
 * @author Sourabh Sharma
 * @param <Restaurant>
 * @param <String>
 */
public interface ReservationRepository<Restaurant, String> extends Repository<Restaurant, String> {

    /**
     *
     * @param name
     * @return
     */
    boolean containsName(String name);

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<Restaurant> findByName(String name) throws Exception;
}
