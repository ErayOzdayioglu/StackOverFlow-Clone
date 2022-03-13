package com.stackoverflow.backend.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name="Answer")
@Getter
@Setter
public class Answer {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="txt")
    private String text;

    @Column(name="vote_count")
    private Integer voteCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id")
    @JsonBackReference
    private Question question;

    @OneToMany(mappedBy = "answer",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> comments;

    @ManyToOne()
    @JoinColumn(name="user_id")
    @JsonBackReference
    private User user;
}
