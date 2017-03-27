package com.chanjet.qm.controllers;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chanjet.qm.service.ITempletService;


@Controller
@RequestMapping(value = "/sciptconfig")
public class SciptConfigController {

    @Resource
    private ITempletService templetService;

    

    @RequestMapping(value = "/view")
    public String view(ModelMap modeMap) {

        modeMap.addAttribute("caseId",11 );
        return "/template/sciptconfig";
    }


}
