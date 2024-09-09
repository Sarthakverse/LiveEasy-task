package com.sarthak.liveeasytask.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "loads")
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "load_id_generator")
    @SequenceGenerator(name = "load_id_generator", sequenceName = "load_id_seq", allocationSize = 1)
    private Long loadId;

    @Column(name = "loading_point", nullable = false)
    @NotBlank(message = "Loading point is required")
    private String loadingPoint;

    @Column(name = "unloading_point", nullable = false)
    @NotBlank(message = "Unloading point is required")
    private String unloadingPoint;

    @Column(name = "product_type", nullable = false)
    @NotBlank(message = "Product type is required")
    private String productType;

    @Column(name = "truck_type", nullable = false)
    @NotBlank(message = "Truck type is required")
    private String truckType;

    @Column(name = "no_of_trucks", nullable = false)
    @NotNull(message = "Number of trucks is required")
    private Integer noOfTrucks;  // Changed to Integer for validation

    @Column(nullable = false)
    @NotNull(message = "Weight is required")
    private Double weight;  // Changed to Double for validation

    @Column
    private String comment;

    @Column(name = "shipper_id", nullable = false)
    @NotNull(message = "Shipper id is required")
    private UUID shipperId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = false)
    @NotNull(message = "Date is required")
    private Date date;
}
