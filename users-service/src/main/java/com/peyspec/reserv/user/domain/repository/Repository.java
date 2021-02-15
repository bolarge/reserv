package com.peyspec.reserv.user.domain.repository;

/**
 *
 * @author Bolaji Salau
 * @param <TE>
 * @param <T>
 */
public interface Repository<TE, T> extends ReadOnlyRepository<TE, T> {

    void add(TE entity);

    void remove(T id);

    void update(TE entity);
}
