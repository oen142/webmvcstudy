package mvcfinalstudy.webmvcstudy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UriController {

    @GetMapping("/eventsUri/{id}")
    @ResponseBody
    public Event getEvents(@PathVariable Long id , @MatrixVariable String name){
        Event event = new Event();
    //    event.setId(id);
        event.setName(name);
        return event;

    }
    //요청 매개변수

    @PostMapping("/eventsss")
    public String getEventsMage(@Validated @ModelAttribute Event event , BindingResult bindingResult ){
       // Event event = new Event();
        if(bindingResult.hasErrors()){
            System.out.println("=======================");
            bindingResult.getAllErrors().forEach(c->{
                System.out.println(c.toString());
            });
            System.out.println("=======================");
            return "events/form";
        }else{

            event.setId(event.getId());
            event.setName(event.getName());
            event.setLimit(event.getLimit());
            List<Event> eventList = new ArrayList<>();
            eventList.add(event);
            return "redirect:/events/list";

        }
    }

    @GetMapping("/events/list")
    public String getEvents(Model model){
        Event event = new Event();
        event.setName("spring");

        return "events/list";
    }

    @GetMapping("/events/form")
    public String eventsForm(Model model){

        model.addAttribute("event" , new Event());
        return "events/form";
    }


}
