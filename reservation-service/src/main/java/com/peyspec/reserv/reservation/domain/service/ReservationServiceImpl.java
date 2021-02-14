package com.peyspec.reserv.reservation.domain.service;

import com.peyspec.reserv.reservation.domain.entity.Entity;
import com.peyspec.reserv.reservation.domain.entity.Reservation;
import com.peyspec.reserv.reservation.domain.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author Bolaji Salau
 */
@Service("restaurantService")
public class ReservationServiceImpl extends BaseService<Reservation, String>
        implements ReservationService {

    private ReservationRepository<Reservation, String> reservationRepository;

    /**
     *
     * @param restaurantRepository
     */
    @Autowired
    public ReservationServiceImpl(ReservationRepository<Reservation, String> restaurantRepository) {
        super(restaurantRepository);
        this.reservationRepository = restaurantRepository;
    }

    @Override
    public void add(Reservation reservation) throws Exception {
        if (reservationRepository.containsName(reservation.getName())) {
            throw new Exception(String.format("There is already a product with the name - %s", reservation.getName()));
        }

        if (reservation.getName() == null || "".equals(reservation.getName())) {
            throw new Exception("Restaurant name cannot be null or empty string.");
        }
        super.add(reservation);
    }

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Reservation> findByName(String name) throws Exception {
        return reservationRepository.findByName(name);
    }

    /**
     *
     * @param restaurant
     * @throws Exception
     */
    @Override
    public void update(Reservation restaurant) throws Exception {
        reservationRepository.update(restaurant);
    }

    /**
     *
     * @param id
     * @throws Exception
     */
    @Override
    public void delete(String id) throws Exception {
        reservationRepository.remove(id);
    }

    /**
     *
     * @param restaurantId
     * @return
     * @throws Exception
     */
    @Override
    public Entity findById(String restaurantId) throws Exception {
        return reservationRepository.get(restaurantId);
    }

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Collection<Reservation> findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
