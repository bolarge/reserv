package com.peyspec.reserv.api.service.reservation;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import org.apache.log4j.;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class ReservationServiceAPI {

    private static final Logger LOG = LoggerFactory.getLogger(ReservationServiceAPI.class);

    //@Qualifier("userInfoRestTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    DiscoveryClient client;

    @RequestMapping("/service")
    public List<String> home() {
        return client.getServices();
    }

    @RequestMapping("/reservations/{reservation-id}")
    @HystrixCommand(fallbackMethod = "defaultReservation")
    public ResponseEntity<Reservation> getRestaurant(@PathVariable("reservation-id") int reservationId) {
        MDC.put("reservationId", String.valueOf(reservationId));
        String url = "http://reservation-service/v1/reservations/" + reservationId;
        LOG.debug("GetReservation from URL: {}", url);

        ResponseEntity<Reservation> result = restTemplate.getForEntity(url, Reservation.class);
        LOG.info("GetReservation http-status: {}", result.getStatusCode());
        LOG.debug("GetReservation body: {}", result.getBody());

        return new ResponseEntity<>(result.getBody(), HttpStatus.OK);
    }

    /**
     * Fetch reservation with the specified name. A partial case-insensitive
     * match is supported. So <code>http://.../reservations/rest</code> will find
     * any reservation with upper or lower case 'rest' in their name.
     *
     * @param name
     * @return A non-null, non-empty collection of reservations.
     */
    @HystrixCommand(fallbackMethod = "defaultReservations")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Reservation>> findByName(@RequestParam("name") String name) {
        LOG.info(String.format("api-service findByName() invoked:{} for {} ", "v1/reservations?name=", name));
        MDC.put("reservationId", name);
        String url = "http://reservation-service/v1/reservations?name=".concat(name);
        LOG.debug("GetReservation from URL: {}", url);
        Collection<Reservation> restaurants;
        ResponseEntity<Collection> result = restTemplate.getForEntity(url, Collection.class);
        LOG.info("GetReservation http-status: {}", result.getStatusCode());
        LOG.debug("GetReservation body: {}", result.getBody());

        return new ResponseEntity<>(result.getBody(), HttpStatus.OK);
    }

    /**
     * Fallback method for getRestaurant()
     *
     * @param reservationId
     * @return
     */
    public ResponseEntity<Reservation> defaultReservation(
            @PathVariable int reservationId) {
        return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
    }

    /**
     * Fallback method for findByName()
     *
     * @param input
     * @return
     */
    public ResponseEntity<Collection<Reservation>> defaultReservations(String input) {
        LOG.warn("Fallback method for user-service is being used.");
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}

class Reservation {

    private List<Table> tables = new ArrayList<>();
    private String id;
    private boolean isModified;
    private String name;
    private String address;

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    public Reservation() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isIsModified() {
        return isModified;
    }

    public void setIsModified(boolean isModified) {
        this.isModified = isModified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Reservation(String name, String id, List<Table> tables) {
        this.tables = tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public List<Table> getTables() {
        return tables;
    }
}

class Table {

    private int capacity;

    public Table(String name, BigInteger id, int capacity) {
        this.capacity = capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
