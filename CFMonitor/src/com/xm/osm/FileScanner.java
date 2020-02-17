package com.xm.osm;

import java.io.File;

/*
统计扫描文件及文件夹个数
文件目录扫描
 */
public class FileScanner {
    public static void scannerDirectory(FileTreeNode node){  //指定目录节点
        // 获取当前目录的子目录或文件列表
        File[] files = node.getFile().listFiles();
        if (files == null) {
            return;
        }

        // 遍历子目录或者文件
        for (File file : files) {
            FileTreeNode child = new FileTreeNode();
            child.setFile(file);
            child.setFilename(file.getName());

            if (file.isDirectory()) {
                // 继续统计子目录
                scannerDirectory(child);
            } else {
                // 如果是普通文件，计算文件大小
                child.setTotallength(file.length());
            }
            node.setTotallength(node.getTotallength() + child.getTotallength());
            node.addChildNode(child);
        }
    }
}
