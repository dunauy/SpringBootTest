package rocks.mylink.example.model.bookmarks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by ibenito on 7/5/16.
 */
@Entity
public class Bookmark {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String uri;

    private String description;

    @JsonIgnore
    @ManyToOne
    private Account account;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
