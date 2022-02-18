package com.personal.test01.algorithm;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @Creater albolt
 * @2020-07-17 15:49
 */

public class BinaryTree {

    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {

        TreeNode node = null;
        if (CollectionUtils.isEmpty(inputList)) {
            return null;
        }

        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    //前序
    public static void perOrderTraveral(TreeNode node) {
        if (node==null) {
            return;
        }
        System.out.println(node.data);
        perOrderTraveral(node.leftChild);
        perOrderTraveral(node.rightChild);
    }

    //无循环前序
    public static void perOrderTraveral2(TreeNode node) {
        System.out.println(node.data);
        Stack<TreeNode> treeNodes = new Stack<>();
        while (node!=null || !CollectionUtils.isEmpty(treeNodes)) {
            if (node.rightChild!=null) {
                treeNodes.push(node.rightChild);
            }
            System.out.println(node.data);
            if (node.leftChild==null && !CollectionUtils.isEmpty(treeNodes)) {
                node = treeNodes.pop();
            } else {
                node = node.leftChild;
            }
        }
    }

    //中序
    public static void inOrderTraveral(TreeNode node) {
        if (node==null) {
            return;
        }
        inOrderTraveral(node.leftChild);
        System.out.println(node.data);
        inOrderTraveral(node.rightChild);
    }

    //后序
    public static void postOrderTraveral(TreeNode node) {
        if (node==null) {
            return;
        }
        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightChild);
        System.out.println(node.data);
    }

    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }

}
