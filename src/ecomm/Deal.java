package ecomm;

import java.time.LocalDateTime;

public class Deal {

    private Integer price;
    private Integer quantity;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Deal(Integer price, Integer quantity, LocalDateTime startTime, LocalDateTime endTime) {
        this.price = price;
        this.quantity = quantity;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
