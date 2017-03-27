package com.chanjet.qm.common.tree;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.chanjet.qm.beans.Node;
import com.chanjet.qm.service.basic.tree.TreeService;
import com.chanjet.qm.util.DotNetToJavaStringHelper;
import com.chanjet.qm.util.SpringContextHolder;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 */
public class TreeHelper {

    private static TreeService treeService = SpringContextHolder.getBean("treeService");

    private static Cache<Integer, Tree> cachedTree = CacheBuilder.newBuilder().maximumSize(10).build();
    private static Cache<Integer, List<Node>> cachedFloatNodes = CacheBuilder.newBuilder().maximumSize(10).build();
    private static Cache<Integer, UITree> cachedUITree = CacheBuilder.newBuilder().maximumSize(10).build();
    //MvcHtmlString
    private static Cache<Integer,String> cachedTreeJSON = CacheBuilder.newBuilder().maximumSize(10).build();


    public static void clearCache(int treeID) {
        cachedTree.invalidate(treeID);
        cachedFloatNodes.invalidate(treeID);
        cachedUITree.invalidate(treeID);
        cachedTreeJSON.invalidate(treeID);
    }

    public static Tree getTree(final int treeID) {

        try {
            return cachedTree.get(treeID, new Callable<Tree>() {
                @Override
                public Tree call() {
                    return treeService.getTree(treeID);
                }
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

//    public static List<Node> getFlatNodes(final int treeID) {
//
//        try {
//            return cachedFloatNodes.get(treeID, new Callable<List<Node>>() {
//                @Override
//                public List<Node> call() {
//                    return treeService.getFlatNodes(treeID);
//                }
//            });
//        } catch (ExecutionException e) {
////            ExceptionLogger.log(e);
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public static UITree getUITree(final int treeID) {
//
//        try {
//            return cachedUITree.get(treeID, new Callable<UITree>() {
//                @Override
//                public UITree call() {
//                    return treeService.getUITree(treeID);
//                }
//            });
//        } catch (ExecutionException e) {
////            ExceptionLogger.log(e);
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public static String getTreeJSON(final int treeID) {
//
//        try {
//            return cachedTreeJSON.get(treeID, new Callable<String>() {
//                @Override
//                public String call() {
//                    UITree uiTree = treeService.getUITree(treeID);
//                    Gson gson = new Gson();
//                    String strJson = gson.toJson(uiTree);
//                    return strJson;
//                }
//            });
//        } catch (ExecutionException e) {
////            ExceptionLogger.log(e);
//            e.printStackTrace();
//            return null;
//        }
//    }

    public static String getValue(int treeID, int id) {
        Tree tree = getTree(treeID);
        if (tree == null) {
            return "";
        }
        return tree.getValue(id);
    }

    public static String getFinalValue(int treeID, int id) {
        Tree tree = getTree(treeID);
        if (tree == null) {
            return "";
        }
        return tree.getFinalValue(id);
    }

    public static boolean contains(int treeID, Iterable<Integer> part) {
        if (part == null) {
            return true;
        }
        Tree tree = getTree(treeID);
        for (int item : part) {
            if (tree.find(item) == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean contains(int treeID, Integer item) {
        if (item == null) {
            return true;
        }
        Tree tree = getTree(treeID);
        if (tree.find(item) == null) {
            return false;
        }
        return true;
    }

    public static Node find(int treeID, Integer nodeID) {
        if (nodeID == null) {
            return null;
        }
        Tree tree = getTree(treeID);
        return tree.find(nodeID);
    }

    public static Node find(int treeID, String value) {
        if (DotNetToJavaStringHelper.isNullOrEmpty(value)) {
            return null;
        }
        Tree tree = getTree(treeID);
        return tree.find(value);
    }
}
