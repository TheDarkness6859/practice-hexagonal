package com.Test.demo.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLRestriction;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "coders")
@SQLRestriction("active = true")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clan_id", nullable = false)
    private ClanEntity clan;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "coders_categories",
            joinColumns = @JoinColumn(name = "coder_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<CategoryEntity> categories;

    private Boolean active;

}
