package com.peyspec.reserv.user.domain.repository;

import com.peyspec.reserv.user.domain.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sourabh Sharma
 */
@Repository("userRepository")
public class InMemUserRepository implements UserRepository<User, String> {

    private Map<String, User> entities;

    /**
     * Initialize the in-memory Restaurant Repository with empty Map
     */
    public InMemUserRepository() {
        entities = new HashMap();
        User user = new User("1", "User Name 1", "Address 1", "City 1", "9999911111");
        entities.put("1", user);
        User user2 = new User("1", "User Name 2", "Address 2", "City 2", "9999922222");
        entities.put("2", user2);
    }

    @Override
    public boolean containsName(String name) {
        try {
            return this.findByName(name).size() > 0;
        } catch (Exception ex) {
            //Exception Handler
        }
        return false;
    }

    @Override
    public void add(User entity) {
        entities.put(entity.getId(), entity);
    }

    @Override
    public void remove(String id) {
        if (entities.containsKey(id)) {
            entities.remove(id);
        }
    }

    @Override
    public void update(User entity) {
        if (entities.containsKey(entity.getId())) {
            entities.put(entity.getId(), entity);
        }
    }

    @Override
    public boolean contains(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User get(String id) {
        return entities.get(id);
    }

    @Override
    public Collection<User> getAll() {
        return entities.values();
    }

    @Override
    public Collection<User> findByName(String name) throws Exception {
        Collection<User> users = new ArrayList();
        int noOfChars = name.length();
        entities.forEach((k, v) -> {
            if (v.getName().toLowerCase().contains(name.toLowerCase().subSequence(0, noOfChars))) {
                users.add(v);
            }
        });
        return users;
    }

}
