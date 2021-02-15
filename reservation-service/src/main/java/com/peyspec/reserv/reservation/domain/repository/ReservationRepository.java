package com.peyspec.reserv.reservation.domain.repository;

import java.util.Collection;

/**
 *
 * @author Sourabh Sharma
 * @param <Reservation>
 * @param <String>
 */
public interface ReservationRepository<Reservation, String> extends Repository<Reservation, String> {

    boolean containsName(String name);

    public Collection<Reservation> findByName(String name) throws Exception;
}
