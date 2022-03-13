package com.stackoverflow.backend.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "Question")
@Getter
@Setter
@NoArgsConstructor
public class Question {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="tag")
    private String tag;

    @Column(name="asked_date")
    private Date askedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="askedBy")
    @JsonBackReference
    @JsonIgnore
    private User askedBy;

    @Column(name="answer_count")
    private Integer answerCount;

    @Column(name="vote_count")
    private Integer voteCount;

    @OneToMany(mappedBy = "question",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Answer> answers;

    @OneToMany(mappedBy = "question",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> comments;


}
