package com.SpaceNews.reportsfeed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReportsController {

    @Autowired
    private ReportsService reportsService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/reports")
    public String getReports(Model model) throws Exception {
        List<report> reports = reportsService.getReports();
        for (report art : reports) {
            System.out.println("Report Title: " + art.getTitle());
            System.out.println("Report Image URL: " + art.getImageUrl());
        }
        model.addAttribute("reports", reports);
        return "reports";
    }
}
