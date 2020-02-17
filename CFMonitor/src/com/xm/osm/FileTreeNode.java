package com.xm.osm;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
    递归统计文件及文件夹的个数
 */
public class FileTreeNode {
    private String filename; //文件名
    private long totallength; //文件的总长度
    private File file; //记录系统文件对象

    private List<FileTreeNode> children = new ArrayList<>();


    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public long getTotallength() {
        return totallength;
    }

    public void setTotallength(long totallength) {
        this.totallength = totallength;
    }

    public List<FileTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<FileTreeNode> children) {
        this.children = children;
    }

    public void addChildNode(FileTreeNode node) {
        this.children.add(node);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
