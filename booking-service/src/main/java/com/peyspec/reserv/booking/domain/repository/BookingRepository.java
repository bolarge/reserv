package com.peyspec.reserv.booking.domain.repository;

import java.util.Collection;

/**
 *
 * @author Bolaji Salau
 * @param <Booking>
 * @param <String>
 */
public interface BookingRepository<Booking, String> extends Repository<Booking, String> {

    boolean containsName(String name);

    public Collection<Booking> findByName(String name) throws Exception;
}
