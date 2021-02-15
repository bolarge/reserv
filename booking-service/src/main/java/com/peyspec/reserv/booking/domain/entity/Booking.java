package com.peyspec.reserv.booking.domain.entity;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Bolaji Salau
 */
public class Booking extends BaseEntity<String> {

    private String reservationId;
    private String userId;
    private LocalDate date;
    private LocalTime time;
    private String tableId;

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String restaurantId) {
        this.reservationId = restaurantId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Booking(String id, String name, String reservationId, String tableId, String userId, LocalDate date, LocalTime time) {
        super(id, name);
        this.reservationId = reservationId;
        this.tableId = tableId;
        this.userId = userId;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return new StringBuilder("{id: ").append(id).append(", name: ")
                .append(name).append(", userId: ").append(userId)
                .append(", reservationId: ").append(reservationId)
                .append(", tableId: ").append(tableId)
                .append(", date: ").append(date).append(", time: ").append(time).append("}").toString();
    }
}
