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
@Table(name = "\"MEDIAFILE\"")
public class Mediafile {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"ID\"", updatable = false)
  private Long id;

  @Column(name = "\"FILE_IDENTIFIER\"", nullable = false)
  private String fileIdentifier;

  @NotNull
  @Column(name = "\"FILE_NAME\"", nullable = false)
  private String fileName;

  @Lob
  @NotNull
  @Column(name = "\"MIME_TYPE\"", nullable = false)
  private String mimeType;

  @NotNull
  @Column(name = "\"SIZE\"", nullable = false)
  private Integer size;

  @NotNull
  @Column(name = "\"UPLOAD_DATE\"", nullable = false)
  private Instant uploadDate;

  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "\"MESSAGE_ID\"")
  private Message message;

}