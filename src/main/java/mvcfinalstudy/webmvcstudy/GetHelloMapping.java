package mvcfinalstudy.webmvcstudy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.GET , value = "/ttt")
public @interface GetHelloMapping {
}