package com.chanjet.qm.controllers.base;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chanjet.qm.common.tree.JsTree;
import com.chanjet.qm.common.tree.Tree;
import com.chanjet.qm.common.tree.TreeHelper;
import com.chanjet.qm.service.basic.tree.TreeService;
import com.chanjet.qm.util.JsonUtils;
import com.google.gson.Gson;

/**
 */
@Controller
@RequestMapping("/Admin/Tree")
public class TreeController  {

    @Resource
    private TreeService treeService;


    @RequestMapping(value = "tree")
    @ResponseBody
    public String showTree() {
        Tree tree = TreeHelper.getTree(1);
        if (tree != null) {
            return JsonUtils.getJson(tree);
        }
        return "NULL";

    }




//    @RequestMapping("")
//    public String index(ModelMap model) {
//        model.addAttribute("trees", treeService.getTrees());
//        return "/Admin/Tree/Index";
//    }

    @RequestMapping(value = "/Edit/{id}")
    public String edit(@PathVariable int id,ModelMap model) {
        JsTree tree = treeService.getJsTree(id);
        model.addAttribute("tree",tree);
        model.addAttribute("id",id);
        return "/Admin/Tree/Edit";
    }

    @RequestMapping(value = "/Edit")
    public String edit() {
        return "/Admin/Tree/Edit";
    }


    @RequestMapping(value = "/Edit/{id}", method = RequestMethod.POST)
    public @ResponseBody
    String edit(@RequestBody JsTree jsTree)
    {
        Tree tree = jsTree.GetTree();
//        treeService.saveTree(tree);
//        jsTree = treeService.getJsTree(tree.getTreeID());
        TreeHelper.clearCache(tree.getTreeID());

        Gson gson = new Gson();
        return gson.toJson(jsTree);
    }

    @RequestMapping(value = "/Edit", method = RequestMethod.POST)
    public @ResponseBody
    String newTree(@RequestBody JsTree jsTree)
    {
//        Tree tree = jsTree.GetTree();
//        treeService.saveTree(tree);
//        jsTree = treeService.getJsTree(tree.getTreeID());
//        TreeHelper.clearCache(tree.getTreeID());

        Gson gson = new Gson();
        return gson.toJson(jsTree);
    }
//
    @RequestMapping(value = "/Demo")
    public String demo() {
        return "/Admin/Tree/Demo";
    }
}
