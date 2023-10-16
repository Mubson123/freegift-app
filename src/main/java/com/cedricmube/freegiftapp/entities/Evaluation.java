package com.cedricmube.freegiftapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"EVALUATION\"")
public class Evaluation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"ID\"", updatable = false)
  private Long id;

  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "\"TRANSACTION_ID\"", nullable = false)
  private Transaction transaction;

  @Lob
  @NotNull
  @Column(name = "\"RATING\"", nullable = false)
  private String rating;

  @Lob
  @NotNull
  @Column(name = "\"DESCRIPTION\"", nullable = false)
  private String description;

}