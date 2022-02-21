package com.carlosdev.personApi.personApi.entities;


import com.carlosdev.personApi.personApi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Enumerated
    @Column(nullable = false)
    public PhoneType type;

    @Column(nullable = false)
    public String number;




}
