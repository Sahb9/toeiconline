package vn.myclass.core.persistence.entity;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name = "comment")
public class Comment {
    //iduser mặc định là khóa chính
    @Id
    //tự tăng
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @Column(name = "content")
    private String content;

    @Column(name = "createddate")
    private Timestamp createdDate;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;


    @ManyToOne
    @JoinColumn(name = "listenGuidelineId")
    private ListenGuideline listenGuideline;



    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ListenGuideline getListenGuideline() {
        return listenGuideline;
    }

    public void setListenGuideline(ListenGuideline listenGuideline) {
        this.listenGuideline = listenGuideline;
    }


}
