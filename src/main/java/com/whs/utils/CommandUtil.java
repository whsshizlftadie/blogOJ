package com.whs.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

// 为了能执行javac编译命令，和java运行指令。
public class CommandUtil {
    private static final int CMD_TIME_OUT=2;
    private static final int DEFAULT_INTERVAL=100;
    public static int run(String cmd, String stdoutFile,
                          String stderrFile) throws IOException, InterruptedException {

        Process process = Runtime.getRuntime().exec(cmd);
        long startTime = System.currentTimeMillis();
        boolean processFinished = false;
        int exitVal;
        //下面处理运行超时
        while(!processFinished){
            if(System.currentTimeMillis()-startTime>=2000){
                process.destroyForcibly();
                return -100;
            }
            try {
                exitVal = process.exitValue();
            } catch (IllegalThreadStateException e) {
                Thread.sleep(DEFAULT_INTERVAL);
                continue;
            }
            processFinished = true;
        }
        System.out.println("执行时长-"+(System.currentTimeMillis()-startTime));

        // 当新的进程跑起来之后, 就需要获取到新进程的输出结果，结果无非有以下几种。
        // 1.要是标准输出中有内容，也就是下边的文件的内容不是空的，给标准输出进行重定向。
        if (stdoutFile != null) {
            // getInputStream 得到的是标准输出，得到里边的内容，为了后边进行重定向。
            InputStream stdoutFrom = process.getInputStream();
            // 可以理解为先弄一个存放标准输出的箱子，将上边的标准输出的内容重定向在这个箱子里。
            FileOutputStream stdoutTo = new FileOutputStream(stdoutFile);
            // 接下来就从新进程这边依次读取每个字节, 写入到 stdoutTo 这个文件里，循环读取。
            while (true) {
                // 从刚的输出中去读
                int ch = stdoutFrom.read();
                if (ch == -1) {
                    break;
                }
                // 给刚那个箱子里边写
                stdoutTo.write(ch);
            }
            // 文件读写完毕, 记得要关闭，否则会导致内存的堆积，进而导致进程挂掉。
            stdoutFrom.close();
            stdoutTo.close();
        }

        // 同上，再针对标准错误进行重定向
        // 要是标准错误文件中有内容，就将输出的内容进行重定向。
        if (stderrFile != null) {
            // getErrorStream 得到的是标准错误
            InputStream stderrFrom = process.getErrorStream();
            // 表示的弄了一个箱子，用来存放标准错误中的内容。
            FileOutputStream stderrTo = new FileOutputStream(stderrFile);
            while (true) {
                int ch = stderrFrom.read();
                if (ch == -1) {
                    break;
                }
                stderrTo.write(ch);
            }
            // 操作完文件，进行文件的关闭。
            stderrFrom.close();
            stderrTo.close();
        }
        // 等待新的进程的结束，在结束退出码。就是等待刚创建的run进程的结束才获取退出码的

        process.waitFor();// 等待一下，等新的进程运行结束
        return process.exitValue();
    }

//    public static void main(String[] args) {
//        // 下边来进行调用。
//        try {
//            // run方法的返回值是int型的，0表示进程成功结束，-1表示的是错误。
//            int ret = CommandUtil.run("javac", "./stdout.txt", "./stderr.txt");
//            System.out.println(ret);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
