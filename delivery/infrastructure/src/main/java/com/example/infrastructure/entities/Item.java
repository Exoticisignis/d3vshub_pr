package com.example.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item extends BaseEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "item_name")
    private String itemName;

    private double price;

    private int quantity;

    private String category;

    @Column(name = "image_url")
    private String imageUrl;

    private String description;

    @Column(name = "allergen_info")
    private String allergenInfo;
    public Item(String value){
        this.itemName = value;
        this.category = value;
        this.imageUrl = value;
        this.description = value;
        this.allergenInfo = value;
        this.quantity = 1;
        this.price = 0;
    }

}
