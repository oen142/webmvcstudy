package mvcfinalstudy.webmvcstudy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/helslo", method = RequestMethod.GET)
public class SampleController {

    @RequestMapping(value = "/**", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @RequestMapping({"/{name:[a-z]+]}}", "/sample*"})
    @ResponseBody
    public String multi(@PathVariable("name") String name) {
        return "sss"+ name;
    }
}
