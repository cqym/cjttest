package com.chanjet.qm.service.basic.tree;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chanjet.qm.beans.Node;
import com.chanjet.qm.common.tree.JsTree;
import com.chanjet.qm.common.tree.Tree;
import com.chanjet.qm.mapper.NodeMapper;

/**
 */
@Service("treeService")
public class TreeServiceImpl implements TreeService{

    @Resource
    private NodeMapper nodeMapper;
//    @Resource
//    private SequenceService sequenceService;


//    @Override
//    public List<Tree> getTrees() {
//
//
//
//
//        return treeRepository.getTrees();
//    }

    @Override
    public Tree getTree(Integer treeID) {
        if(null == treeID) {
            Tree tree = new Tree();
            Node tempVar = new Node();
            tempVar.setID(0);
            tempVar.setName("");
            tree.addNode(tempVar);
            return tree;
        } else {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("TreeID", treeID);

            List<Node> list = nodeMapper.getNodesByTreeID(paramMap);
            Tree tree = new Tree();

            for (Node node : list) {
                tree.addNode(node);
            }

            return tree;
        }
    }
//
//    @Override
//    public List<Node> getFlatNodes(int treeID) {
//        List<Node> nodes = new ArrayList<Node>();
//        Tree tree = getNodesByTreeID(treeID);
//        tree.getNode().getFlot(nodes);
//        nodes.remove(0);
//        return nodes;
//    }
//
    @Override
    public JsTree getJsTree(Integer treeID) {
        Tree tree = getTree(treeID);
        if(tree == null) {
            return null;
        }
        return tree.getJsTree();
    }
//
//    @Override
//    public UITree getUITree(int treeID) {
//        Tree tree = getNodesByTreeID(treeID);
//        if(tree == null) {
//            return null;
//        }
//        return tree.getUITree();
//    }
//
//    @Override
//    public void saveTree(Tree tree) {
//        setNodeID(tree.getNode());
//        tree.setTreeID(tree.getNode().getID());
//        tree.setName(tree.getNode().getName());
//        treeRepository.saveTree(tree);
//    }
//
//    private void setNodeID(Node node) {
//        if(node.getID() == 0) {
//            node.setID(sequenceService.next(SequenceID.Noah_Foundation_Tree));
//        }
//        if(null != node.getChildren()) {
//            int orderID = 0;
//            for (Node child : node.getChildren()) {
//                child.setPID(node.getID());
//                setNodeID(child);
//                child.setOrderID(orderID++);
//            }
//        }
//    }
}
