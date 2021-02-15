package com.peyspec.reserv.booking.domain.repository;

import java.util.Collection;

/**
 *
 * @author Bolaji Salau
 * @param <TE>
 * @param <T>
 */
public interface ReadOnlyRepository<TE, T> {

    boolean contains(T id);

    TE get(T id);

    Collection<TE> getAll();
}
