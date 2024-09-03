package com.workintech.s18d4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "address", schema = "fsweb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private long id;

        @Column(name = "city")
        private String city;

        @Column(name = "street")
        private String street;

        @Column(name = "no")
        private String no;

        @Column(name = "country")
        private String country;

        @Column(name = "description")
        private String description;

        @OneToMany(mappedBy = "address", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
        private Customer customer;

}
