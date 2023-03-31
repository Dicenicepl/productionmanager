package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "orders")
public class AppOrder {

    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )

    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "Product_Name",nullable = false)
    private String productName;
    @Column(name = "Description",nullable = false)
    private String description;
    @Column(name = "Product_Owner",nullable = false)
    private String productOwner;
    @Column(name = "Product_Added",nullable = false)
    private LocalDate timeAdded;
    @Column(name = "Approximate_Delivery_Time",nullable = false)
    private LocalDate approximateDeliveryTime;

    public AppOrder(String productName, String description, String productOwner) {
        this.productName = productName;
        this.description = description;
        this.productOwner = productOwner;
        this.timeAdded = LocalDate.now();
        this.approximateDeliveryTime = LocalDate.now().plusDays(5);
    }
}
