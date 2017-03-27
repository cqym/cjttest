package com.chanjet.qm.service.basic.tree;


import com.chanjet.qm.common.tree.JsTree;
import com.chanjet.qm.common.tree.Tree;

/**
 *
 */
public interface TreeService {

//    List<Tree> getTrees();
    Tree getTree(Integer treeID);
//    List<Node> getFlatNodes(int treeID);
    JsTree getJsTree(Integer treeID);
//    UITree getUITree(int treeID);
//    void saveTree(Tree tree);
}
