package com.hym.datastructure.algorithm.greedy;

import java.util.*;

public class HuffmanTree {
    /**
     * 创建哈夫曼树
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> Node createTree(List<Node<T>> list) {
        if (list == null) {
            return null;
        }
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i < list.size(); i++) {
            queue.add(list.get(i));
        }
        while (queue.size() > 1) {
            Node left = queue.poll();
            Node right = queue.poll();
            Node node = new Node(left.pow + right.pow, left, right);
            queue.add(node);
        }
        return queue.poll();
    }

    /**
     * 获取哈夫曼编码（编码这里使用字符串表示）
     *
     * @param node
     * @param <T>
     * @return
     */
    public static <T> Map<T, String> getCode(Node<T> node) {
        if (node == null) {
            return null;
        }
        Map<T, String> map = new HashMap<>();
        if (node.left != null && node.left != null) {
            List<String> codes = new ArrayList<>();
            traverse(node, map, codes);
        } else {
            map.put(node.item, "0");
        }
        return map;
    }

    private static <T> void traverse(Node<T> node, Map<T, String> map, List<String> codes) {
        if (node.left == null && node.right == null) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < codes.size(); i++) {
                builder.append(codes.get(i));
            }
            map.put(node.item, builder.toString());
        }
        //左子树
        if (node.left != null) {
            codes.add("0");
            traverse(node.left, map, codes);
            codes.remove(codes.size() - 1);
        }
        //右子树
        if (node.right != null) {
            codes.add("1");
            traverse(node.right, map, codes);
            codes.remove(codes.size() - 1);
        }
    }

    /**
     * 根据哈夫曼编码，解析出字符串
     *
     * @param map
     * @param codeStr
     * @param <T>
     * @return
     */
    public static <T> String reCode(Map<T, String> map, String codeStr) {
        if (map == null) {
            return "";
        }
        //将key和value倒过来
        Map<String, T> map2 = new HashMap<>();
        for (T key : map.keySet()) {
            map2.put(map.get(key), key);
        }
        StringBuilder builder = new StringBuilder();
        while (codeStr.length() > 0) {
            for (String key : map2.keySet()) {
                if (codeStr.startsWith(key)) {
                    builder.append(map2.get(key));
                    codeStr = codeStr.replaceFirst(key, "");
                    break;
                }
            }
        }
        return builder.toString();
    }


    public static class Node<T> implements Comparable<Node> {
        T item;
        int pow;
        Node<T> left;
        Node<T> right;

        public Node() {
        }

        public Node(T item, int pow) {
            this.item = item;
            this.pow = pow;
        }

        public Node(int pow, Node<T> left, Node<T> right) {
            this.pow = pow;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            return pow - o.pow;
        }
    }
}
