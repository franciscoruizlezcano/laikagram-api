package com.laika.application.shared.infrastructure.web.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public final class IndexController {
    @RequestMapping("/")
    public RedirectView index() {
        return new RedirectView("/swagger-ui.html");
    }
}
