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

    public void add(User booking) throws Exception;

    public void update(User booking) throws Exception;

    public void delete(String id) throws Exception;

    public Entity findById(String restaurantId) throws Exception;

    public Collection<User> findByName(String name) throws Exception;

    public Collection<User> findByCriteria(Map<String, ArrayList<String>> name) throws Exception;
}
