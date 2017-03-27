package com.chanjet.qm.common.tree;

import java.util.ArrayList;
import java.util.List;

import com.chanjet.qm.beans.Node;

/**
 */
public class JsTreeNode {

    public static final String OBSOLETE_CSSCLASS = "obsolete";

    private String data;

    private String state;

    private JsTreeMetaData metadata;

    private JsTreeAttr attr;

    private List<JsTreeNode> children;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public JsTreeMetaData getMetadata() {
        return metadata;
    }

    public void setMetadata(JsTreeMetaData metadata) {
        this.metadata = metadata;
    }

    public JsTreeAttr getAttr() {
        return attr;
    }

    public void setAttr(JsTreeAttr attr) {
        this.attr = attr;
    }

    public List<JsTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<JsTreeNode> children) {
        this.children = children;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public final Node getTreeNode(Integer pid) {
        Node tempVar = new Node();
        tempVar.setName(this.getData());
        tempVar.setID(getMetadata().getid());
        tempVar.setObsolete(0);
        tempVar.setPID(pid);
        Node node = tempVar;
        if (this.getAttr() != null && JsTreeNode.OBSOLETE_CSSCLASS.equals(this.getAttr().getKlass())) {
            node.setObsolete(1);
        }
        if (this.getChildren() != null && this.getChildren().size() > 0) {
            for (JsTreeNode child : this.getChildren()) {
                node.addChild(child.getTreeNode(node.getID()));
            }
        }
        return node;
    }

    public final void addChild(JsTreeNode node) {
        if (this.getChildren() == null) {
            this.setChildren(new ArrayList<JsTreeNode>());
        }
        this.getChildren().add(node);
    }
}
