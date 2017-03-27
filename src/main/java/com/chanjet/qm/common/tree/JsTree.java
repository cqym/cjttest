package com.chanjet.qm.common.tree;

/**
 */
public class JsTree {

    private JsTreeNode root;

    public JsTreeNode getRoot() {
        return root;
    }

    public void setRoot(JsTreeNode root) {
        this.root = root;
    }

    public final Tree GetTree() {
        Tree tempVar = new Tree();
        tempVar.setTreeID(getRoot().getMetadata().getid());
        tempVar.setName(getRoot().getData());
        tempVar.setNode(getRoot().getTreeNode(null));
        Tree tree = tempVar;
        return tree;
    }
}
