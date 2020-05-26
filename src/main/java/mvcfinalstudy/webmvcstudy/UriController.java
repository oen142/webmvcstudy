package mvcfinalstudy.webmvcstudy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("event")
public class UriController {

    @GetMapping("/events/form/name")
    public String eventsFormName(Model model) {
        Event newEvent = new Event();
        newEvent.setLimit(50L);
        model.addAttribute("event", newEvent);
        return "events/form-name";
    }
//<input type="text" name="limit" th:filed="*{limit}">

    @PostMapping("/events/form/name")
    public String eventsFormNameSubmit(@Validated @ModelAttribute Event event
            , BindingResult bindingResult
            , SessionStatus sessionStatus) {
        if (bindingResult.hasErrors()) {
            return "form-name";
        }
        return "redirect:/events/from/limit";

    }

    @GetMapping("/events/form/limit")
    public String eventsFormLimit(@ModelAttribute Event event, Model model) {
        model.addAttribute("event", event);
        return "events/form-limit";
    }

    @PostMapping("/events/form/limit")
    public String eventsFormLimitSubmit(@Validated @ModelAttribute Event event
            , BindingResult bindingResult
            , SessionStatus sessionStatus
            , RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            return "form-limit";
        }
        sessionStatus.setComplete();
        attributes.addAttribute("name" , event.getName());
        attributes.addFlashAttribute("newEvent" , event);
        return "redirect:/events/from/limit";

    }

    @GetMapping("/events/list")
    public String getEvents(Model model, @SessionAttribute("visitTime") LocalDateTime visitTime) {
        System.out.println(visitTime);
        Event event = new Event();
        event.setName("spring");
        event.setLimit(10L);

        Event newEvent = (Event)model.asMap().get("newEvent");
        List<Event> eventList = new ArrayList<>();
        eventList.add(event);

        model.addAttribute(eventList);
        return "/events/list";

    }

}
