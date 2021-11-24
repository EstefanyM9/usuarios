/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuatroa.retouno.retouno.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


/**
 *
 * @author Esteffany Meneses
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name= "user", indexes = @Index(name = "indx_email", columnList = "user_email", unique = true))
public class User implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@NonNull
@Column(name = "user_email", length = 50, nullable = false)
private String email;

@Column(name = "user_password", length = 50, nullable = false)
private String password;

@Column(name = "user_name", length = 80, nullable = false)
private String name;


   public User(String email, String password, String no_definido) {
        this.email = email;
        this.password = password;
        this.name = "NO DEFINIDO";
    }
    
}
