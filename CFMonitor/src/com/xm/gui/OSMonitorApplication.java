package com.xm.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//主程序：1.必须继承javafx的Application类 2.必须覆写start()
public class OSMonitorApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //1.加载主程序(获取资源)
        //法1：静态方法加载：
        // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //法2 getClass()获取他自己的类加载器  getResource()获取资源
        FXMLLoader loader = new FXMLLoader(getClass().getResource("os_monitor_tab.fxml"));

        //2.真正的加载
        Parent root = loader.load();

        //页面框显示主程序处理
        OSMonitorController controller = loader.getController();
        controller.setPrimaryStage(primaryStage);

        //创建一个Scene 场景
        Scene scene = new Scene(root, 800, 600);

        //设置标题
        primaryStage.setTitle("OS_Monitor");

        //将scene添加到stage
        primaryStage.setScene(scene);

        primaryStage.setOnCloseRequest((e) -> controller.shutdown());

        //展示
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
