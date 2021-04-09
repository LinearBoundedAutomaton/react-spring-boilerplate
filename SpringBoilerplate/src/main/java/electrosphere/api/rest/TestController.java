package electrosphere.api.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lba
 */
@RestController
public class TestController {
    @RequestMapping(value = "/api/test", method=RequestMethod.GET)
    public String printTest(){
        return "test";
    }
}
