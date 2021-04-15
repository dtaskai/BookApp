package hu.mik.pte.prog4.model;

import lombok.*;

@Data
@ToString
@EqualsAndHashCode
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


    public Book(String ISBN, String title, String author, String publisher, String genre, int page, int progress, boolean completed, Integer rating) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.page = page;
        this.progress = progress;
        this.completed = completed;
        this.rating = rating;
    }
}
