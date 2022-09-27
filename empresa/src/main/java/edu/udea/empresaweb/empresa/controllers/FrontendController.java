package edu.udea.empresaweb.empresa.controllers;



import edu.udea.empresaweb.empresa.services.EnterpriseService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class FrontendController {

    EnterpriseService enterpriseService;

    public FrontendController(EnterpriseService enterpriseService){
        this.enterpriseService = enterpriseService;
    }

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal){

        if (principal != null){
            model.addAttribute("user", principal.getClaims());
            System.out.println("User info:" + principal.getClass());
        }

        return "home";
    }


    @GetMapping("/enterprises")
    public String viewPageEnterprise(Model model){
        model.addAttribute("listEnterprises", enterpriseService.getAllEnterprises());
        return "index0";
    }
}
