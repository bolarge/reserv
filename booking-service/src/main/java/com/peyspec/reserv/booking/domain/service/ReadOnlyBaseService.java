package com.peyspec.reserv.booking.domain.service;

import com.peyspec.reserv.booking.domain.repository.ReadOnlyRepository;

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
