package com.epam.martseniuk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Roman_Martseniuk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    private String username;
    private String password;
    private String serialNumber;
}

