package com.pensareluis.Holamundo.controller;

import com.pensareluis.Holamundo.constant.ViewConstant;
import com.pensareluis.Holamundo.impl.UserService;
import com.pensareluis.Holamundo.model.ContactModel;
import com.pensareluis.Holamundo.services.ContactService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Jorge Álvarez
 * @version 1.0 - 2018/03/26
 */
@Controller
@RequestMapping("/contacts")
public class ContactController {
    private static final Log LOG = LogFactory.getLog(ContactController.class);
    Authentication auth;

    @Autowired
    @Qualifier("userServices")
    private UserService userService;

    @Autowired
    @Qualifier("contactServiceImpl")
    private ContactService contactService;

    @GetMapping("/cancel")
    public String cancel(){
        return "redirect:/contacts/showcontacts";
    }


    @GetMapping("/contactform")
    private String redireccontactForm(@RequestParam(name="id", required=false) int id,
                                      Model model){
        ContactModel contact = new ContactModel();
        if (id!=0){
            LOG.info("ID ES: "+ id);
            contact = contactService.findContactModelBy(id);
        }
        model.addAttribute("contactModel", contact);
        return ViewConstant.CONTACT_FORM;
    }

    @GetMapping("/showcontacts")
    public ModelAndView showContacts(){
        ModelAndView mov = new ModelAndView(ViewConstant.CONTACTS);
        mov.addObject("contacts",contactService.listAllContacts());
        return mov;
    }


    @PostMapping("/addcontact")
    public String addContact(@ModelAttribute(name="contactModel") ContactModel contactModel
    ,Model model){
        LOG.info("METHOD:addContact --- PARAMS:"+ contactModel.toString());

        if(null!=contactService.addContact(contactModel)) {
            model.addAttribute("result",1);
            return "redirect:/contacts/showcontacts";
        }
        else
        {
            model.addAttribute("result",0);
        }
        contactService.addContact(contactModel);
        model.addAttribute("result",1);
        return ViewConstant.CONTACTS;

    }
    @GetMapping("/removecontact")
    public ModelAndView removeContact(@RequestParam(name="id",required = true)int id){
        contactService.removeContact(id);
        return showContacts();
    }





}
