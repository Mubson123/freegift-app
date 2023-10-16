package com.cedricmube.freegiftapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"MESSAGE\"")
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"ID\"", updatable = false)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "\"TRANSACTION_ID\"", nullable = false)
  private Transaction transaction;

  @Lob
  @NotNull
  @Column(name = "\"CONTENT\"", nullable = false)
  private String content;

  @NotNull
  @Column(name = "\"SEND_DATE\"", nullable = false)
  private Instant sendDate;

  @OneToMany(mappedBy = "message", cascade = CascadeType.PERSIST, orphanRemoval = true)
  private Set<Mediafile> mediafiles = new LinkedHashSet<>();

}