package com.cedricmube.freegiftapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CUSTOMER")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", updatable = false)
  private Long id;

  @NotNull
  @Column(name = "FIRSTNAME", nullable = false, length = 100)
  private String firstname;

  @NotNull
  @Column(name = "LASTNAME", nullable = false, length = 100)
  private String lastname;

  @NotNull
  @Column(name = "USERNAME", nullable = false, length = 100)
  private String username;

  @NotNull
  @Column(name = "BIRTHDATE", nullable = false)
  private LocalDate birthdate;

  @NotNull
  @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
  @Column(name = "\"EMAIL\"", length = 100)
  private String email;

  @NotNull
  @Column(name = "PHONE_NUMBER", nullable = false, length = 50)
  private String phoneNumber;

  @OneToOne(mappedBy = "customer", cascade = CascadeType.PERSIST, orphanRemoval = true)
  private Address address;

  @OneToOne(mappedBy = "customer", cascade = CascadeType.PERSIST, orphanRemoval = true)
  private User user;

}