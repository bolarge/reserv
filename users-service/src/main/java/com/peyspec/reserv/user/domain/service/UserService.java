package com.peyspec.reserv.user.domain.service;

import com.peyspec.reserv.user.domain.entity.Entity;
import com.peyspec.reserv.user.domain.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author Bolaji Salau
 */
public interface UserService {

    /**
     *
     * @param booking
     * @throws Exception
     */
    public void add(User booking) throws Exception;

    /**
     *
     * @param booking
     * @throws Exception
     */
    public void update(User booking) throws Exception;

    /**
     *
     * @param id
     * @throws Exception
     */
    public void delete(String id) throws Exception;

    /**
     *
     * @param restaurantId
     * @return
     * @throws Exception
     */
    public Entity findById(String restaurantId) throws Exception;

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<User> findByName(String name) throws Exception;

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Collection<User> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}
