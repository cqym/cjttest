package com.chanjet.qm.common.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.chanjet.qm.beans.Node;
import com.chanjet.qm.util.DotNetToJavaStringHelper;
import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;

/**
 */
public class Tree {
    private int treeID;
    private String name;
    private Node node;

    public int getTreeID() {
        return treeID;
    }

    public void setTreeID(int value) {
        treeID = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node value) {
        node = value;
    }

    public boolean addNode(Node node) {
        if (node.getPID() == null) {
            if (getNode() != null) {
                return false;
            }
            this.setNode(node);
            this.setTreeID(node.getID());
            this.setName(node.getName());
            return true;
        } else {
            return getNode().addChild(node);
        }
    }

    public Node find(int id) {
        return this.getNode().find(id);
    }

    public Node find(String value) {
        return this.getNode().find(value);
    }

    public String getFinalValue(int id) {
        Node node = this.getNode().find(id);
        if (node == null) {
            return "";
        }
        return node.getName();
    }

    public String getValue(int id) {
        List<Node> path = new ArrayList<Node>();
        if (this.getNode().findPath(path, id) == null) {
            return "";
        }

        //path.Reverse().Skip(1).Select(n = > n.getName()).toArray()
        Collections.reverse(path);
        List<String> names = FluentIterable.from(path).skip(1).transform(new Function<Node,String>(){
            @Override
            public String apply(Node node){
                return node.getName();
            }
        }).toList();

        return StringUtils.join(names," . ");
    }

    public String specifiedValueOrGetValue(String specifiedValue, Integer id) {
        if(id == null){
            return specifiedValue;
        }

        if (!DotNetToJavaStringHelper.isNullOrEmpty(specifiedValue)) {
            return specifiedValue;
        }
        return getValue(id.intValue());
    }

    public JsTree getJsTree() {
        JsTree tempVar = new JsTree();
        tempVar.setRoot(this.getNode().getJsTreeNode());
        JsTree jsTree = tempVar;
        return jsTree;
    }

    public UITree getUITree() {
        UITree tempVar = new UITree();
        tempVar.setRoot(this.getNode().getUITreeNode());
        UITree uiTree = tempVar;
        int deepth = 0;
        deepth = this.getNode().getMaxDeepth(deepth);
        uiTree.setDeepth(deepth);

        return uiTree;
    }
}
