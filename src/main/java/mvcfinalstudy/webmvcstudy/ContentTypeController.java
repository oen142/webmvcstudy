package mvcfinalstudy.webmvcstudy;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.PushBuilder;

@Controller
public class ContentTypeController {

    @RequestMapping(value = "/content", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE,
            params = "a",
            headers = HttpHeaders.FROM)
    @ResponseBody
    public String content() {
        return "hellos";
    }
    @GetHelloMapping
    @ResponseBody
    public String ttt() {
        return "ttt";
    }

    @PostMapping("/sss")
    @ResponseBody
    public String sss() {
        return "sss";
    }


    @GetMapping("/events/{id}")
    @ResponseBody
    public String events(@PathVariable Long id){
        return "events" + id;
    }

  /*  @PostMapping(value = "/events/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE , produces =MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String createEvents(@PathVariable Long id){
        return "events" + id;
    }*/




}
