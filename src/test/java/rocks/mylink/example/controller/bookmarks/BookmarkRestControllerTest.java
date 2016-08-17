package rocks.mylink.example.controller.bookmarks;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import rocks.mylink.example.controller.BaseControllerTest;
import rocks.mylink.example.model.bookmarks.Account;

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
    public void createUser() throws Exception {

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
