/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author fabian
 */
@Controller
public class IndexController {
    
    @RequestMapping()
    public String index(Model model) {
        model.addAttribute("Nombreestudiante", "Fabian Chavarria");
        return "index";
    }
    
}
