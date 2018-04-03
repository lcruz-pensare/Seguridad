package com.pensareluis.Holamundo.controller;

import com.pensareluis.Holamundo.constant.ViewConstant;
import com.pensareluis.Holamundo.model.UserCredential;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author Jorge Álvarez
 * @version 1.0 - 2018/03/26
 */
@Controller
public class LoginController {

    private static final Log LOG = LogFactory.getLog(LoginController.class);

    @GetMapping("/login")
    public String showLoginForm(Model model,
                                @RequestParam(name = "error", required = false) String error,
                                @RequestParam(name = "logout", required = false) String logout) {
        LOG.info("METHOD:showLoginForm --- PARAMS: error=" + error + ",    logout: " + logout);
        model.addAttribute("userCredentials", new UserCredential());
        model.addAttribute("error", error);
        LOG.info("Returninng to login view");
        return ViewConstant.LOGIN;
    }

    @GetMapping({"/loginsuccess","/"})
    public String loginCheck() {
        LOG.info("Returninng to contacs view");
        return "redirect:/contacts/showcontacts";

    }
}
