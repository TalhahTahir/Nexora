package com.talha.nexora.entity;

import java.time.Instant;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import com.talha.nexora.enums.UserRole;

@Data 
@Getter 
@Setter 
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false, unique = true)
    private String email;

    @Column (nullable = false)
    private String password;
    
    @Enumerated(EnumType.STRING)
    @Column (nullable = false)
    private UserRole role;

    @Column (nullable = false)
    private Instant createdAt;

    @Column (nullable = false)
    private Instant updatedAt;
    
}
