package cdp.backupmanager.controllers;

import cdp.backupmanager.services.MongoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ServerListController {
    @GetMapping("/serverlist")
    public String serverlist(Model model) {
        MongoService ms = new MongoService();
        model.addAttribute("name","qwert");
        model.addAttribute("servercount", ms.getServers());
        return "serverlist";
    }
}
