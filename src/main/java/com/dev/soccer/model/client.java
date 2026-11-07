package com.dev.soccer.model;

import com.dev.soccer.model.enums.client_type;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id ;

    public client_type client_type;

    public String name;

    public String phone1;

    public String phone2;

    public String address;

    public String cpf_cnpj;

    public String mail;

    @CreationTimestamp
    public LocalDateTime init_date;

    public LocalDateTime cancel_date;
}
