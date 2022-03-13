package com.stackoverflow.backend.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name="Comment")
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="txt")
    private String text;

    @Column(name="vote_count")
    private Integer voteCount;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne()
    @JoinColumn(name="question_id")
    @JsonBackReference
    private Question question;

    @ManyToOne()
    @JoinColumn(name="answer_id")
    @JsonBackReference
    private Answer answer;

}
