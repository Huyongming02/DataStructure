package com.hym.datastructure.algorithm.greedy;

import org.junit.Test;

import java.util.*;

public class HuffmanTreeTest {

    /**
     * 测试哈夫曼树构建的正确性
     */
    @Test
    public void test1() {
        int size = 10;
        //构建字符节点
        List<HuffmanTree.Node<Character>> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new HuffmanTree.Node<>((char) ('a' + i), new Random().nextInt(size * 100)));
        }
        print(list, " org node:");
        //创建哈夫曼树
        HuffmanTree.Node<Character> root = HuffmanTree.createTree(list);
        //获取哈夫曼编码（这里以字符串表示二进制）
        Map<Character, String> codeMap = HuffmanTree.getCode(root);
        print(codeMap, "node code:");

    }

    /**
     * 验证编码与反编码
     */
    @Test
    public void test2() {
        int size = 20;
        //创建原始的数据
        char[] chars = getChars(size);
        //统计字符出现的频率，构建字符节点
        List<HuffmanTree.Node<Character>> list = getNodes(size, chars);
        print(list, " org node:");
        //创建哈夫曼树
        HuffmanTree.Node<Character> root = HuffmanTree.createTree(list);
        //获取哈夫曼编码（这里以字符串表示二进制）
        Map<Character, String> codeMap = HuffmanTree.getCode(root);
        print(codeMap, "node code:");
        //输出原始数据
        System.out.println("   orgStr:" + new String(chars));
        //编码原始数据
        StringBuilder codeBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            Character ch = chars[i];
            codeBuilder.append(codeMap.get(ch));
        }
        String codeStr = codeBuilder.toString();
        System.out.println("code:" + codeStr);
        //解析编码
        String reCodeStr = HuffmanTree.reCode(codeMap, codeStr);
        System.out.println("recodeStr:" + reCodeStr);
    }

    private List<HuffmanTree.Node<Character>> getNodes(int size, char[] chars) {
        List<HuffmanTree.Node<Character>> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            Integer value = map.get(chars[i]);
            if (value == null) {
                map.put(chars[i], 1);
            } else {
                map.put(chars[i], value + 1);
            }
        }
        for (Character key : map.keySet()) {
            list.add(new HuffmanTree.Node<>(key, map.get(key)));
        }
        return list;
    }

    private char[] getChars(int size) {
        char[] chars = new char[size];
        for (int i = 0; i < size; i++) {
            chars[i] = (char) ('a' + new Random().nextInt(26));
        }
        return chars;
    }

    private static void print(List<HuffmanTree.Node<Character>> list, String s) {
        StringBuilder builder = new StringBuilder();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                builder.append("{" + list.get(i).item + ":" + list.get(i).pow + "},");
            }
        }
        System.out.println(s + builder.toString());
    }

    private static void print(Map<Character, String> codeMap, String s) {
        StringBuilder builder = new StringBuilder();
        if (codeMap != null) {
            for (Character key : codeMap.keySet()) {
                builder.append("{" + key + ":" + codeMap.get(key) + "},");
            }
        }
        System.out.println(s + builder.toString());
    }

}
