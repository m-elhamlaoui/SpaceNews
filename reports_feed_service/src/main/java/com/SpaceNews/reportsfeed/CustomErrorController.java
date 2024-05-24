package com.SpaceNews.reportsfeed;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Logique personnalisée pour gérer les erreurs
        return "error"; // Assurez-vous d'avoir une page error.html dans votre dossier templates
    }
}
