package com.sbs.sbb.answer;

import com.sbs.sbb.comment.Comment;
import com.sbs.sbb.question.Question;
import com.sbs.sbb.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity // answer 테이블
public class Answer {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Integer id;

    @Column(columnDefinition = "TEXT") // TEXT
    private String content;

    private LocalDateTime createDate;

    // private Integer questionId;
    @ManyToOne
    private Question question;
    // question_id 라는 칼럼이 생김
    @ManyToOne
    private SiteUser author;

    private LocalDateTime modifyDate;

    @ManyToMany
    Set<SiteUser> voter;

    @OneToMany(mappedBy = "answer")
    private List<Comment> commentList;
}