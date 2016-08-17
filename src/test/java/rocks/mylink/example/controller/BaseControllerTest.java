package rocks.mylink.example.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import rocks.mylink.example.DemoApplication;
import rocks.mylink.example.common.CommonResponse;

import java.nio.charset.Charset;
import java.util.Arrays;

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
@SpringApplicationConfiguration(classes = DemoApplication.class)
//@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public abstract class BaseControllerTest {

    protected MockMvc mvc;
    protected String basePath;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    protected MediaType jsonContentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));


    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream().filter(
                hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().get();

        Assert.assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }


    //void setConverters(HttpMessageConverter<?>[] converters) {}

    @Before
    abstract public void setUp() throws Exception;

    @Test
    public void testCheck() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(basePath + "/check").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(CommonResponse.CHECK_RESPONSE));
    }

    protected String json(Object o) throws Exception {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}
