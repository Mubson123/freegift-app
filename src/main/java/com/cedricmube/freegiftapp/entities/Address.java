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
@Table(name = "ADDRESS")
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", updatable = false)
  private Long id;

  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "CUSTOMER_ID", nullable = false)
  private Customer customer;

  @NotNull
  @Column(name = "STREET", nullable = false, length = 100)
  private String street;

  @NotNull
  @Column(name = "ZIP", nullable = false, length = 50)
  private String zip;

  @NotNull
  @Column(name = "CITY", nullable = false, length = 100)
  private String city;

  @NotNull
  @Column(name = "COUNTRY", nullable = false, length = 100)
  private String country;

  @Column(name = "OTHER_ADDRESS")
  private String otherAddress;

}