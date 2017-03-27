package com.chanjet.qm.beans;

import java.util.ArrayList;
import java.util.List;

import com.chanjet.qm.common.tree.JsTreeAttr;
import com.chanjet.qm.common.tree.JsTreeMetaData;
import com.chanjet.qm.common.tree.JsTreeNode;

/**
 */
public class Node {
    private Integer treeID;
    private int iD;
    private Integer pID;
    private int orderID;
    private String name;
    private int obsolete;
    private int deepth;
    private List<Node> children;

    public int getID() {
        return iD;
    }

    public void setID(int value) {
        iD = value;
    }

    public Integer getPID() {
        return pID;
    }

    public void setPID(Integer value) {
        pID = value;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int value) {
        orderID = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public int getObsolete() {
        return obsolete;
    }

    public void setObsolete(int value) {
        obsolete = value;
    }

    public int getDeepth() {
        return deepth;
    }

    public void setDeepth(int value) {
        deepth = value;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> value) {
        children = value;
    }

    public Integer getTreeID() {
        return treeID;
    }

    public void setTreeID(Integer treeID) {
        this.treeID = treeID;
    }

    public Node find(int id) {
        if (this.getID() == id) {
            return this;
        }
        if (this.getChildren() != null) {
            for (Node child : this.getChildren()) {
                Node node = child.find(id);
                if (node != null) {
                    return node;
                }
            }
        }
        return null;
    }

    public Node find(String name) {
        if (this.getName().equals(name)) {
            return this;
        }
        if (this.getChildren() != null) {
            for (Node child : this.getChildren()) {
                Node node = child.find(name);
                if (node != null) {
                    return node;
                }
            }
        }
        return null;
    }

    public Node findPath(List<Node> path, int id) {
        if (this.getID() == id) {
            path.add(this);
            return this;
        }
        if (this.getChildren() != null) {
            for (Node child : this.getChildren()) {
                Node node = child.findPath(path, id);
                if (node != null) {
                    path.add(this);
                    return node;
                }
            }
        }
        return null;
    }

    public void getFlot(List<Node> list) {
        list.add(this);
        if (this.getChildren() != null) {
            for (Node child : this.getChildren()) {
                child.getFlot(list);
            }
        }
    }

    public boolean addChild(Node node) {
        if (node.getPID().equals(this.getID())) {
            if (getChildren() == null) {
                setChildren(new ArrayList<Node>());
            }
            node.setDeepth(this.getDeepth() + 1);
            getChildren().add(node);
            return true;
        } else {
            if (getChildren() != null) {
                for (Node child : getChildren()) {
                    if (child.addChild(node)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public JsTreeNode getJsTreeNode() {
        JsTreeNode tempVar = new JsTreeNode();
        tempVar.setData(this.getName());

        JsTreeMetaData jsTreeMetaData = new JsTreeMetaData();
        jsTreeMetaData.setid(this.getID());
        tempVar.setMetadata(jsTreeMetaData);
        JsTreeNode jsNode = tempVar;
        if (this.getObsolete() != 0) {
            JsTreeAttr tempVar2 = new JsTreeAttr();
            tempVar2.setKlass(JsTreeNode.OBSOLETE_CSSCLASS);
            jsNode.setAttr(tempVar2);
        }
        if (this.getChildren() != null && this.getChildren().size() > 0) {
            for (Node child : this.getChildren()) {
                jsNode.addChild(child.getJsTreeNode());
            }
        }
        return jsNode;
    }

    public Object[] getUITreeNode() {
        if (this.getChildren() != null && this.getChildren().size() > 0) {
            Object[] node = new Object[4];
            node[0] = this.getID();
            node[1] = this.getName();
            node[2] = this.getObsolete();
            Object[] children = new Object[this.getChildren().size()];
            for (int i = 0; i < this.getChildren().size(); i++) {
                children[i] = this.getChildren().get(i).getUITreeNode();
            }
            node[3] = children;
            return node;
        } else {
            Object[] node = new Object[3];
            node[0] = this.getID();
            node[1] = this.getName();
            node[2] = this.getObsolete();
            return node;
        }
    }

    public int getMaxDeepth(int deepth) {

        int maxDeepth = deepth;
        int tmpDeepth;

        if (this.getDeepth() > deepth) {
            maxDeepth = this.getDeepth();
        }
        if (this.getChildren() != null) {
            for (Node child : this.getChildren()) {
                tmpDeepth = child.getMaxDeepth(maxDeepth);
                if(tmpDeepth > maxDeepth) {
                    maxDeepth = tmpDeepth;
                }
            }
        }

        return maxDeepth;
    }
}
