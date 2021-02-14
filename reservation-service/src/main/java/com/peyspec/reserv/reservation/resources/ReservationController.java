package com.peyspec.reserv.reservation.resources;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import com.peyspec.reserv.reservation.domain.entity.Entity;
import com.peyspec.reserv.reservation.domain.entity.Reservation;
import com.peyspec.reserv.reservation.domain.service.ReservationService;
import com.peyspec.reserv.reservation.domain.valueobject.RestaurantVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/v1/reservations")
public class ReservationController {

    /**
     * Logger
     */
    protected Logger logger = Logger.getLogger(ReservationController.class.getName());

    /**
     * restaurant service
     */
    protected ReservationService restaurantService;

    /**
     *
     * @param restaurantService
     */
    @Autowired
    public ReservationController(ReservationService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Autowired
    DiscoveryClient client;

    /**
     *
     * @return
     */
    @RequestMapping("/services")
    public List<String> home() {
        return client.getServices();
    }

    /**
     * Fetch restaurants with the specified name. A partial case-insensitive
     * match is supported. So <code>http://.../restaurants/rest</code> will find
     * any restaurants with upper or lower case 'rest' in their name.
     *
     * @param name
     * @return A non-null, non-empty collection of restaurants.
     */
    //@HystrixCommand(fallbackMethod = "defaultRestaurants")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Reservation>> findByName(@RequestParam("name") String name) {
        logger.info(String.format("restaurant-service findByName() invoked:{} for {} ", restaurantService.getClass().getName(), name));
        name = name.trim().toLowerCase();
        Collection<Reservation> restaurants;
        try {
            restaurants = restaurantService.findByName(name);
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Exception raised findByName REST Call", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return restaurants.size() > 0 ? new ResponseEntity<>(restaurants, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Fetch restaurants with the given id.
     * <code>http://.../v1/restaurants/{restaurant_id}</code> will return
     * restaurant with given id.
     *
     * @param id
     * @return A non-null, non-empty collection of restaurants.
     */
    //@HystrixCommand(fallbackMethod = "defaultRestaurant")
    @RequestMapping(value = "/{restaurant_id}", method = RequestMethod.GET)
    public ResponseEntity<Entity> findById(@PathVariable("restaurant_id") String id) {
        logger.info(String.format("restaurant-service findById() invoked:{} for {} ", restaurantService.getClass().getName(), id));
        id = id.trim();
        Entity restaurant;
        try {
            restaurant = restaurantService.findById(id);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Exception raised findById REST Call {0}", ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return restaurant != null ? new ResponseEntity<>(restaurant, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Add restaurant with the specified information.
     *
     * @param restaurantVO
     * @return A non-null restaurant.
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Reservation> add(@RequestBody RestaurantVO restaurantVO) {
        logger.info(String.format("restaurant-service add() invoked: %s for %s", restaurantService.getClass().getName(), restaurantVO.getName()));
        System.out.println(restaurantVO);
        Reservation restaurant = new Reservation(null, null, null, null);
        BeanUtils.copyProperties(restaurantVO, restaurant);
        try {
            restaurantService.add(restaurant);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Exception raised add Restaurant REST Call {0}", ex);
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Fallback method
     *
     * @param input
     * @return
     */
    public ResponseEntity<Entity> defaultRestaurant(String input) {
        logger.warning("Fallback method for restaurant-service is being used.");
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    /**
     * Fallback method
     *
     * @param input
     * @return
     */
    public ResponseEntity<Collection<Reservation>> defaultRestaurants(String input) {
        logger.warning("Fallback method for user-service is being used.");
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
