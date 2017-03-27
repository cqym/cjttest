package com.chanjet.qm.controllers;


import java.util.Date;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chanjet.qm.beans.TempletBean;
import com.chanjet.qm.beans.TestCaseBean;
import com.chanjet.qm.common.tree.Tree;
import com.chanjet.qm.common.tree.TreeHelper;
import com.chanjet.qm.service.ITestCaseService;
import com.chanjet.qm.util.JsonUtils;


@Controller
@RequestMapping(value = "/testcase")
public class TestCaseController {

    @Resource
    private ITestCaseService testCaseService;




    @RequestMapping(value = "/add")
    public String add(ModelMap modeMap) {
    
        modeMap.addAttribute("action", "create");
        modeMap.addAttribute("case", new TestCaseBean());
        return "/template/editcase";
    }

   

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid TestCaseBean newTestCase, RedirectAttributes redirectAttributes) throws Exception {

        newTestCase.setUserId(966L);
        newTestCase.setCreateDate(new Date());
        newTestCase.setUpdateDate(new Date());
        testCaseService.addCase(newTestCase);
        redirectAttributes.addFlashAttribute("message", "新建用例成功");
        return "redirect:/Template/list";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model) throws Exception {
        model.addAttribute("case", testCaseService.getCaseById(id));
        model.addAttribute("action", "update");
        return "/template/editcase";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("module") TestCaseBean testCase, RedirectAttributes redirectAttributes) throws Exception {
        testCaseService.addCase(testCase);
        redirectAttributes.addFlashAttribute("message", "更新任务成功");
        return "redirect:/module/";
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) throws Exception {
        testCaseService.delCase(id);
        redirectAttributes.addFlashAttribute("message", "删除用例成功");
        return "redirect:/module/";
    }


    @RequestMapping(value = "tree")
    @ResponseBody
    public String showTree() {
        Tree tree = TreeHelper.getTree(1);
        if (tree != null) {
            return JsonUtils.getJson(tree);
        }
        return "NULL";

    }


}

//	 /*  @RequestMapping(value = "select", method = RequestMethod.GET)
//        public String select(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
//	            @RequestParam(value = "page.size", defaultValue = "5") int pageSize,
//	            @RequestParam(value = "sortType", defaultValue = "auto") String sortType, Model model,
//	            ServletRequest request) {
//	        Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
//	        Long userId = getCurrentUserId();
//
//	        Page<TempletBean> modules = templetService.getUserModule(searchParams, pageNumber, pageSize, sortType);
//
//	        model.addAttribute("modules", modules);
//	        model.addAttribute("sortType", sortType);
//	       // model.addAttribute("sortTypes", sortTypes);
//	        // 将搜索条件编码成字符串，用于排序，分页的URL
//	        model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));
//
//	        return "module/moduleSelectList";
//	    }
//
//	    @RequestMapping(value = "create", method = RequestMethod.GET)
//	    public String createForm(Model model) {
//	        model.addAttribute("module", new TempletBean());
//	        model.addAttribute("action", "create");
//	        return "module/moduleForm";
//	    }
//
//	    @RequestMapping(value = "create", method = RequestMethod.POST)
//	    public String create(@Valid TempletBean newModule, RedirectAttributes redirectAttributes) {
//
//	        newModule.setUserId(966L);
//	        newModule.setCreateDate(new Date());
//	        newModule.setUpdateDate(new Date());
//	        templetService.saveModule(newModule);
//	        redirectAttributes.addFlashAttribute("message", "创建任务成功");
//	        return "redirect:/module/";
//	    }
//
//
//}
