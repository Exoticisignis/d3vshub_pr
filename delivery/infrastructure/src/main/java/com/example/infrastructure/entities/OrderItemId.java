package com.example.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class OrderItemId implements Serializable {
    private Long orderId;

    private Long itemId;

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(orderId,  ((OrderItemId) o).orderId) && Objects.equals(itemId,  ((OrderItemId) o).itemId)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, orderId);
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
