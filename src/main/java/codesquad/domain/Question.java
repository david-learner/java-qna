package codesquad.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Question {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String title;

    private String contents;

    private String tag;


    public Question() {
    }

    public Question(User user, String title, String contents) {
        writer = user.getUserId();
        this.title = title;
        this.contents = contents;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Long getId() {
        return id;
    }

    public String getWriter() {
        return writer;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public String getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return writer + " " + title + " " + contents;
    }

    public boolean isMatchedWriter(String userId) {
        return writer.equals(userId);
    }

    public boolean update(Question updateQuestion) {
        if (updateQuestion.title == null) {
            return false;
        }

        this.title = updateQuestion.title;
        this.contents = updateQuestion.contents;

        return true;
    }
}
