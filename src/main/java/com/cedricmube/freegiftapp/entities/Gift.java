package com.cedricmube.freegiftapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "GIFT")
public class Gift {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", updatable = false)
  private Long id;

  @NotNull
  @Column(name = "NAME", nullable = false, length = 100)
  private String name;

  @Lob
  @NotNull
  @Column(name = "STATE", nullable = false)
  private String state;

  @Column(name = "DIMENSION", length = 100)
  private String dimension;

  @Column(name = "WEIGHT", precision = 8, scale = 2)
  private BigDecimal weight;

  @Lob
  @NotNull
  @Column(name = "DESCRIPTION", nullable = false)
  private String description;

  @Column(name = "PHOTO", nullable = false)
  private String photo;

  @Column(name = "AVAILABILITY", nullable = false)
  private LocalDate availability;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "USER_ID", nullable = false)
  private User user;

  @OneToMany(mappedBy = "gift", cascade = CascadeType.PERSIST, orphanRemoval = true)
  private Set<Transaction> transactions = new LinkedHashSet<>();

}