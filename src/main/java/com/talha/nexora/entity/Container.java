package com.talha.nexora.entity;

import java.time.Instant;

import com.talha.nexora.enums.ContainerStatus;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
@Entity 
@Table (name = "containers")
public class Container {

    public Container() {
    }
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne 
    @JoinColumn (name = "deployment_id", nullable = true)
    private Deployment deployment;

    @Column (nullable = true)
    private String containerId;

    @Column (nullable = true)
    private String subdomain;

    @Column (nullable = false)
    private Long port;

    @Column (nullable = false)
    private Long internalPort;

    @Column (nullable = false)
    private Long hostPort;

    @Column (nullable = false)
    private String name;

    @Enumerated (EnumType.STRING)
    private ContainerStatus status;

    @Column (nullable = false)
    private Long replicaIndex;

    @Column (nullable = false)
    private Long cpuLimit;

    @Column (nullable = false)
    private Long memoryLimit;

    @Column (nullable = false)
    private Instant createdAt;

    @Column (nullable = true)
    private Instant startedAt;

    @Column (nullable = true)
    private Instant stoppedAt;

}