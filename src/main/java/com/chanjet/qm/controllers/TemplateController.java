package com.chanjet.qm.controllers;


import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chanjet.qm.beans.TempletBean;
import com.chanjet.qm.common.ViewModelNumberPager;
import com.chanjet.qm.common.tree.Tree;
import com.chanjet.qm.common.tree.TreeHelper;
import com.chanjet.qm.service.ITempletService;
import com.chanjet.qm.util.JsonUtils;


@Controller
@RequestMapping(value = "/Template")
public class TemplateController {

    @Resource
    private ITempletService templetService;

    @RequestMapping(value = "/list")
    public String list(ModelMap modelMap, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {
        int take = 3;
        if (null == page) {
            page = 1;
        }
        int skip = (page - 1) * take;

        int count = 0;
        count= templetService.getAllModuleCount();

        List<TempletBean> modules = templetService.getModuleByPage(skip, take);
//        ModelAndView mv = new ModelAndView();
        modelMap.addAttribute("templates", modules);

        Map<String, Object> params = new HashMap();
        modelMap.addAttribute("page", new ViewModelNumberPager(page, take, count, "/Template/list", params));


        return  "/template/list";
    }

    @RequestMapping(value = "/add")
    public String add(ModelMap modeMap) {

//        List<TempletBean> modules = templetService.getAllModule();
//        ModelAndView mv = new ModelAndView();
        modeMap.addAttribute("action", "create");
        modeMap.addAttribute("templ", new TempletBean());
        return "/template/edit";
    }

    @RequestMapping(value = "/savetemplet.json")
    public String methodsavecodecheckinfo(Model model, HttpServletRequest request,
                                          HttpServletResponse response, HttpSession session) throws UnsupportedEncodingException {
        String allinfo = request.getParameter("allinfo");
        allinfo = java.net.URLDecoder.decode(allinfo, "utf-8");
        HashMap<String, Object> mapinfo = new HashMap<String, Object>();
        // 将json字符串转换成JSONArray
        JSONArray jsonArray = JSONArray.fromObject(allinfo);
        List<Map<String, Object>> mapListJson = (List) jsonArray;
        for (int i = 0; i < mapListJson.size(); i++) {
            mapinfo.put(mapListJson.get(i).get("key").toString(), mapListJson.get(i).get("value"));
        }
        TempletBean templObj = (TempletBean) (JSONArray.toArray(jsonArray, TempletBean.class));
        templObj.setCreateDate(new Date());
        try {
            TempletBean templ = templetService.addModule(templObj);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "redirect:/templ/";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String saveTempl(@Valid TempletBean newModule, RedirectAttributes redirectAttributes) throws Exception {
         
        newModule.setUserId(966L);
        newModule.setCreateDate(new Date());
        newModule.setUpdateDate(new Date());
        templetService.addModule(newModule);
        redirectAttributes.addFlashAttribute("message", "创建任务成功");
        return "redirect:/Template/list";
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model model) throws Exception {
        model.addAttribute("action", "update");
        model.addAttribute("templ", templetService.getModuleById(id));
        return "/template/edit";
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("module") TempletBean module, RedirectAttributes redirectAttributes) throws Exception {
        module.setUpdateDate(new Date());
        templetService.updateModule(module);
        redirectAttributes.addFlashAttribute("message", "更新任务成功");
        return "redirect:/Template/list";
    }
    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) throws Exception {
        templetService.delModule(id);
        redirectAttributes.addFlashAttribute("message", "删除任务成功");
        return  "/template/list";
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
