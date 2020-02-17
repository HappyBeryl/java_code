package com.xm.gui;

import com.xm.osm.FileScanner;
import com.xm.osm.FileTreeNode;
import com.xm.osm.OSResource;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tab;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import javax.xml.soap.Text;
import java.awt.*;
import java.io.File;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class OSMonitorController {
    //声明Tap页控件id 作为Controller的属性
   @FXML private LineChart cpuChart;  //注解 要有 和fxml文件名字一致
   @FXML private TreeTableView<FileTreeNode> fileStat;
   @FXML private Text osType;

   //展示页面
    private Stage primaryStage = null;

    //给目录加图片
    private final Image image = new Image(
            getClass().getClassLoader().getResourceAsStream("Folder.png"));

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    //定时器任务
    private TimerTask timerTask = null;
    //定时器线程，执行定时任务
    private Timer timer = new Timer();
    public void handleCPUSelectionChanged(Event event) {

        //得到标签
        Tab tab = (Tab) event.getTarget();
        //标签选中时，做这一系列的事情
        if (tab.isSelected()) {

            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    //调用逻辑方法
                    OSResource.XYPair[] xypairs = OSResource.getCpuPercetage();

                    //构造XYChart添加数据
                    XYChart.Series series = new XYChart.Series();
                    for (OSResource.XYPair xypair : xypairs) {
                        //拿出自己的坐标点传给Data
                        XYChart.Data data = new XYChart.Data(xypair.getX(), xypair.getY());
                        //放到series进行保存
                        series.getData().add(data);
                    }

                    //将渲染逻辑切换到主线程执行
                    Platform.runLater(
                            () -> {
                                //处理历史数据
                                if (cpuChart.getData().size() > 0) {
                                    cpuChart.getData().remove(0); //从0开始把所有东西移除
                                }

                                //数据添加到LineChart
                                cpuChart.getData().add(series);

                            }
                    );
                }
            };
            //开始执行定时器任务，第二个参数0表示任务安排好之后，立即执行一次，第三个参数表示执行
            //时间单位是ms
            timer.schedule(timerTask, 0, 1000);
        } else {
            if (timerTask != null) {
                timerTask.cancel();
                timerTask = null;
            }
        }

    }

    //关闭线程
    public void shutdown() {
        if (timer != null) {
           timer.cancel();
        }
    }


    public void handleSelectFile(ActionEvent actionEvent) {
        System.out.println("Button action");

        fileStat.setRoot(null);

        //目录选择
        DirectoryChooser directoryChooser = new DirectoryChooser();

        //弹出对话框 File保存文件
        File file = directoryChooser.showDialog(primaryStage);

        //渲染文件统计
        FileTreeNode rootNode = new FileTreeNode();
        rootNode.setFile(file);
        rootNode.setFilename(file.getName());
        //扫描目录
        FileScanner.scannerDirectory(rootNode);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                FileTreeNode rootNode = new FileTreeNode();
                rootNode.setFile(file);
                rootNode.setFilename(file.getName());

                FileScanner.scannerDirectory(rootNode);

                //把rootNode转化为TreeItem 根节点
                TreeItem rootItem = new TreeItem(rootNode);

                //设置树允许自动展开
                rootItem.setExpanded(true);
                //子节点转换
                fillTreeItem(rootNode, rootItem);

                //渲染在主线程执行
                Platform.runLater(
                        ()-> {
                            fileStat.setRoot(rootItem);
                        }
                );
            }
        });
        //执行完立即释放资源
        thread.setDaemon(true);
        thread.start();
    }

    //子目录转换
    private void fillTreeItem(FileTreeNode rootNode, TreeItem rootItem)
    {
        //获取子节点
        List<FileTreeNode> childs = rootNode.getChildren();
        //遍历子节点
        for(FileTreeNode node: childs){
            TreeItem item = new TreeItem(node);

            if (node.getChildren().size() > 0){
                item.setGraphic(new ImageView(image));
            }
            rootItem.getChildren().add(item);

            // 递归调用，转换子目录
            fillTreeItem(node, item);
        }
    }




}
