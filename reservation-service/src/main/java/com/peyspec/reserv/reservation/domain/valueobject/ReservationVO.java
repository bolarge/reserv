package com.peyspec.reserv.reservation.domain.valueobject;

import com.peyspec.reserv.reservation.domain.entity.Table;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bolaji Salau
 */
public class ReservationVO {

    private List<Table> tables = new ArrayList<>();
    private String name;
    private String id;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ReservationVO() { }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public List<Table> getTables() {
        return tables;
    }

    @Override
    public String toString() {
        return String.format("{id: %s, name: %s, address: %s, tables: %s}", this.getId(),
                this.getName(), this.getAddress(), this.getTables());
    }
}
