package com.talha.nexora.entity;

import java.time.Instant;
import java.util.List;

import com.talha.nexora.enums.ProjectStatus;
import com.talha.nexora.enums.Technology;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data 
@Getter 
@Setter 
@Entity 
@Table (name = "projects")
public class Project {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @Column (nullable = false)
    private String name;

    @Column (nullable = true)
    private String description;

    @Column (nullable = false)
    private String sourceUrl;

    @Column (nullable = false)
    @Enumerated (EnumType.STRING)
    private Technology technology;

    @Column (nullable = false)
    private Boolean dockerFile;

    @Column (nullable = true)
    private String subdomain;

    @Column (nullable = false)
    @Enumerated (EnumType.STRING)
    private ProjectStatus status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "project_dependencies", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "dependency_id"))
    private List<Dependencies> dependencies;

    @Column (nullable = false)
    private Instant createdAt;

    @Column (nullable = false)
    private Instant updatedAt;

    @Column (nullable = true)
    private Long desiredReplicas;

    @Column (nullable = true)
    private Long minReplicas;

    @Column (nullable = true)
    private Long maxReplicas;
}
