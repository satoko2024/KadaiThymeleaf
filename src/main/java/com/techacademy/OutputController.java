package com.techacademy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.context.MessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Locale;

@Controller
public class OutputController {
    @Autowired
    private MessageSource messageSource;

    @PostMapping("/output")
    public String postOutput(@RequestParam("value") String value, Model model, Locale locale) {
        model.addAttribute("value", value);
        model.addAttribute("title", messageSource.getMessage("label.title", null, locale));
        model.addAttribute("outputTitle", messageSource.getMessage("label.outputTitle", null, locale));
        model.addAttribute("outputMessage", messageSource.getMessage("label.outputMessage", null, locale));
        model.addAttribute("backLink", messageSource.getMessage("label.backLink", null, locale));
        return "output";
    }
}