package rocks.mylink.example.model.bookmarks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ibenito on 7/5/16.
 */
@Entity
public class Account {

    @Id
    @GeneratedValue
    protected Long id;

    @JsonIgnore
    @Column(nullable = false)
    protected String username;

    @JsonIgnore
    @Column(nullable = false)
    protected String password;

    @OneToMany(mappedBy = "account")
    protected Set<Bookmark> bookmarks = new HashSet<Bookmark>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(Set<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }
}
