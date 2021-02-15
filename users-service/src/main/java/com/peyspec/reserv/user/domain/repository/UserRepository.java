package com.peyspec.reserv.user.domain.repository;

import java.util.Collection;

/**
 *
 * @author Bolaji Salau
 * @param <Booking>
 * @param <String>
 */
public interface UserRepository<Booking, String> extends Repository<Booking, String> {

    boolean containsName(String name);

    public Collection<Booking> findByName(String name) throws Exception;
}
