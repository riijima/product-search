package com.example.demo.web.user;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * ユーザコントローラ
 * @author border
 *
 */
@Controller
@RequestMapping("/user")
@SessionAttributes("userForm")
public class UserController {
    /**
     * ロガー.
     */
    private Log log = LogFactory.getLog(getClass());

    /**
     * ユーザサービス
     */
    @Autowired
    private UserService userService;

    @ModelAttribute("userForm")
    public UserForm setupUserInputForm() {
        return new UserForm();
    }

    @GetMapping("/input")
    public String input(UserForm userForm, Model model) {
        log.debug("input:" + userForm.toString());
        return "user/input";
    }

    @PostMapping("/input")
    public String inputBack(UserForm userForm, Model model) {
        log.debug("inputBack:" + userForm.toString());
        return "user/input";
    }

    @PostMapping("/confirm")
    public String confirm(@ModelAttribute @Validated UserForm userForm, BindingResult bindingResult, Model model) {
        log.debug("confirm:" + userForm.toString());
        if (bindingResult.hasErrors()) {
            return "user/input";
        }
        return "user/confirm";
    }

    @PostMapping("/save")
    public String save(UserForm userForm, SessionStatus sessionStatus, RedirectAttributes attributes) {
        log.debug("save:" + userForm.toString());
        User user = new User();
        BeanUtils.copyProperties(userForm, user);
        userService.save(user);
        sessionStatus.setComplete();
        return "redirect:/user/saveComplete";
    }

    @GetMapping("/saveComplete")
    public String complete() {
        return "user/saved";
    }
}
