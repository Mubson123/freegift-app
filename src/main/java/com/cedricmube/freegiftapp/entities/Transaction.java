package com.cedricmube.freegiftapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TRANSACTION")
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", updatable = false)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "GIFT_ID", nullable = false)
  private Gift gift;

  @NotNull
  @Column(name = "NAME", nullable = false)
  private String name;

  @NotNull
  @Column(name = "START_DATE", nullable = false)
  private Instant startDate;

  @NotNull
  @Column(name = "END_DATE", nullable = false)
  private Instant endDate;

  @Lob
  @NotNull
  @Column(name = "STATUS", nullable = false)
  private String status;

  @OneToOne(mappedBy = "transaction", cascade = CascadeType.PERSIST, orphanRemoval = true)
  private Evaluation evaluation;

}