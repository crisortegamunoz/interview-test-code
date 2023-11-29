package com.cristianortega.interview.codetest.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "phone")
@Getter
@Setter
@NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_phone", nullable = false)
    private Integer id;
    @Column(name = "number", nullable = false)
    private String number;
    @Column(name = "city_code", nullable = false)
    private String cityCode;
    @Column(name = "country_code", nullable = false)
    private String countryCode;
    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private User user;

}
