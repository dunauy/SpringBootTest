package rocks.mylink.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dunauy on 2/27/16.
 *
 * Test RestController annotation. RestController combines @Controller and  @ResponseBody,
 * so it returns data instead of a view.
 */

@RestController
public class HelloController implements BaseController {

    @RequestMapping("/")
    public String index(){
        return "Hello Spring Boot";
    }

}
