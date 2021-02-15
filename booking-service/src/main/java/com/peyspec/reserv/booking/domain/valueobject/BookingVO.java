package com.peyspec.reserv.booking.domain.valueobject;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Bolaji Salau
 */
public class BookingVO {

    private String name;
    private String id;
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

    public String getRestaurantId() {
        return reservationId;
    }

    public void setRestaurantId(String restaurantId) {
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

    public BookingVO() {
    }

    public BookingVO(String id, String name, String reservationId, String tableId, String userId, LocalDate date, LocalTime time) {
        this.id = id;
        this.name = name;
        this.reservationId = reservationId;
        this.userId = userId;
        this.date = date;
        this.time = time;
    }

    @Override
    public String toString() {
        return new StringBuilder("{id: ").append(id).append(", name: ")
                .append(name).append(", userId: ").append(userId)
                .append(", restaurantId: ").append(reservationId)
                .append(", tableId: ").append(tableId)
                .append(", date: ").append(date).append(", time: ").append(time).append("}").toString();
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
}
