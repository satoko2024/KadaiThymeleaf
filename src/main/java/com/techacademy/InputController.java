package com.techacademy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.context.MessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Locale;

@Controller
public class InputController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/input")
    public String getInput(@RequestParam(value = "previous", required = false) String previous, Model model, Locale locale) {
        model.addAttribute("previous", previous);
        model.addAttribute("title", messageSource.getMessage("label.title", null, locale));
        model.addAttribute("inputTitle", messageSource.getMessage("label.inputTitle", null, locale));
        model.addAttribute("inputMessage", messageSource.getMessage("label.inputMessage", null, locale));
        return "input";
    }
}