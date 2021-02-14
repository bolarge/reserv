package com.peyspec.reserv.reservation.domain.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sourabh Sharma
 */
public class Reservation extends BaseEntity<String> {

    private List<Table> tables = new ArrayList<>();
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

    /**
     *
     * @param name
     * @param id
     * @param address
     * @param tables
     */
    public Reservation(String name, String id, String address, List<Table> tables) {
        super(id, name);
        this.address = address;
        this.tables = tables;
    }

    /**
     *
     * @param tables
     */
    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    /**
     *
     * @return
     */
    public List<Table> getTables() {
        return tables;
    }

    /**
     * Overridden toString() method that return String presentation of the
     * Object
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("{id: %s, name: %s, address: %s, tables: %s}", this.getId(),
                this.getName(), this.getAddress(), this.getTables());
    }
}
