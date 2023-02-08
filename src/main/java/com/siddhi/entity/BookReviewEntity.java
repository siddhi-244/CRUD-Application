package com.siddhi.entity;

import javax.persistence.*;

@Entity
@Table(name="book_review")
public class BookReviewEntity {
    @Id
    private String id;

    @Column(name = "book_id")
    private String bookid;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "review")
    private String review;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
