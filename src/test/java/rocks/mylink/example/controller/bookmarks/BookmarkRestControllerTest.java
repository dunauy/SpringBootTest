package rocks.mylink.example.controller.bookmarks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import rocks.mylink.example.controller.BaseControllerTest;
import rocks.mylink.example.model.bookmarks.Account;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ibenito on 5/9/16.
 *
 * Tests Bookmarks controller service.
 *
 * Use cases :
 *  - User not found
 *  - Create user
 *  - Login user
 *  - Create bookmark
 *  - List bookmarks
 *  - Delete bookmark
 *  - Delete user
 */
public class BookmarkRestControllerTest extends BaseControllerTest {

    private Account account;
    private String testUsername = "test123";
    private String testPassword = "password123";

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Override
    public void setUp() throws Exception {
        basePath = "bookmarks";
        mvc = MockMvcBuilders.standaloneSetup(webApplicationContext).build();
    }

    @Test
    public void userNotFound() throws Exception {

    }

    @Test
    public void createUser_noError() throws Exception {
        String userJson = json(new Account(testUsername, testPassword));
        this.mvc.perform(post("/user")
                .contentType(jsonContentType)
                .content(userJson)
        ).andExpect(status().isOk());
    }

    @Test
    public void createUser_alreadyExists() throws Exception {

    }

    @Test
    public void createUser_formError() throws Exception {

    }

    @Test
    public void loginUser() throws Exception {

    }

    @Test
    public void createBookmark() throws Exception {
        String bookmarkJson = "";
        //this.mvc.perform(post);
    }

    @Test
    public void readSingleBookmark() throws Exception {

    }

    @Test
    public void listUserBookmarks() throws Exception {

    }

    @Test
    public void deleteBookmark() throws Exception {

    }

    @Test
    public void deleteUser() throws Exception {

    }
}
