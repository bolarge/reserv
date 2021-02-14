package com.peyspec.reserv.reservation.domain.service;

import com.peyspec.reserv.reservation.domain.repository.ReadOnlyRepository;

/**
 *
 * @author Bolaji Salau
 * @param <TE>
 * @param <T>
 */
public abstract class ReadOnlyBaseService<TE, T> {

    private ReadOnlyRepository<TE, T> repository;

    ReadOnlyBaseService(ReadOnlyRepository<TE, T> repository) {
        this.repository = repository;
    }
}
