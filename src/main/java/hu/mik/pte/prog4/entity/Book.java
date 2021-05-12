package hu.mik.pte.prog4.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Long id;
    private String ISBN;
    private String title;
    private String author;
    private String publisher;
    private String genre;
    private int page;
    private int progress;
    private boolean completed;
    private Integer rating;
    private String addedBy;
}
