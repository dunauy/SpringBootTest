package rocks.mylink.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import rocks.mylink.example.common.CommonResponse;

/**
 * Base definition for all controllers
 */
public interface BaseController {

    @RequestMapping("check")
    @ResponseBody
    default String checkController() {
        return CommonResponse.CHECK_RESPONSE;
    }
}
