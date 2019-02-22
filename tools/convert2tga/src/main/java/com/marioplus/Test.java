package com.marioplus;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.util.EntityUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class Test extends JFrame implements ActionListener {
    private static final String COMMAND_OPEN = "open";
    private static final String url = "https://s4.aconvert.com/convert/convert-batch-win.php";

    JButton jb = new JButton("选择文件夹");

    public static void main(String[] args) {
        new Test();

    }

    private Test() {
        jb.setActionCommand("open");
        //建立容器使用边界布局
        this.getContentPane().add(jb);
        jb.addActionListener(this);
        this.setSize(333, 288);
        this.setLocation(0, 0);
        //显示窗口true
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals(COMMAND_OPEN)) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            //显示打开的文件对话框
            fileChooser.showOpenDialog(this);
            //返回路径名
            String dir = fileChooser.getSelectedFile().getAbsolutePath();
            execute(dir);

            //JOptionPane弹出对话框类，显示绝对路径名
            JOptionPane.showMessageDialog(this, dir, "标题", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void execute(String dir) {
        File file = new File(dir);
        if (file.exists()) {
            Optional.ofNullable(file.listFiles()).ifPresent(files -> {
                for (File f : files) {
                    if (f.getName().matches("^.+\\.(?:png|jpg)$")) {
                        String tagUrl = "https://s4.aconvert.com/convert/p3r68-cdx67/" + doMultipartFileUpload(f);
                        System.out.println(tagUrl);
                        String filePath = f.getParent() + "\\";
                        String fileName = f.getName().replaceAll("\\.(?:png|jpg)$", ".tga");
                        System.out.println(HttpUtils.create(tagUrl, null).getDownloadResult(filePath, fileName));
                    }
                }
            });
        }
    }

    private String doMultipartFileUpload(File file) {

        HttpEntity entity = MultipartEntityBuilder.create()
                .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                .addBinaryBody("file", file, ContentType.DEFAULT_BINARY, file.getName())
                .addTextBody("targetformat", "tga")
                .addTextBody("imagesize", "option1")
                .addTextBody("customsize", "")
                .addTextBody("code", "83000")
                .addTextBody("filelocation", "local")
                .build();

        return HttpUtils.create(url, entity).doPostData(new ImageData()).map(ImageData::getFilename).orElse("123");
    }

    private void doPost(String url) {

//        HttpUtils.create(url,null).doPostState(new GetStateHandle() {
//            @Override
//            public Boolean apply(HttpResponse httpResponse) {
//                return null;
//            }
//        });
//        HttpEntity entity = new StringEntity("","");

        HttpUtils.create(url,null).doPostData("");
    }
}
