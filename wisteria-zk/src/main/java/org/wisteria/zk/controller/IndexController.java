package org.wisteria.zk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @auther Lei.Liu
 * @create
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String  toIndex(Model model) {
        return "zk/index";
    }
}
