package rocks.mylink.example.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import rocks.mylink.example.common.CommonResponse;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ibenito on 5/6/16.
 *
 * Base configuration for all controllers that inherits from BaseController.
 *
 * Checks if the controller has been loaded, and adds all the stuff for test configuration.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public abstract class BaseControllerTest {

    protected MockMvc mvc;
    protected String basePath;

    @Before
    abstract public void setUp() throws Exception;

    @Test
    public void testCheck() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(basePath + "/check").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(CommonResponse.CHECK_RESPONSE));
    }
}
