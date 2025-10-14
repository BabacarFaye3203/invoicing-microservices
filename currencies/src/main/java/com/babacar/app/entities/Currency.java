package com.babacar.app.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
 @Table(name = "currency")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "is_active")
    private boolean isActive;
}
