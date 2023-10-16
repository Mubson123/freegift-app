package com.cedricmube.freegiftapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", updatable = false)
  private Long id;

  @NotNull
  @Column(name = "USERNAME", nullable = false, length = 150)
  private String username;

  @NotNull
  @Column(name = "PASSWORD", nullable = false, length = 150)
  private String password;

  @Column(name = "PROFILE_PHOTO", nullable = false)
  private String profilePhoto;

  @NotNull
  @Column(name = "REGISTRATION_DATE", nullable = false)
  private LocalDate registrationDate;

  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "CUSTOMER_ID", nullable = false)
  private Customer customer;

}