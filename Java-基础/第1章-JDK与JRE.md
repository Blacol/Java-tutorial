[TOC]

# JDK与JRE
## 本章任务：
- [ ] 了解JDK和JRE
- [ ] 安装Java 17
## Java开发工具包介绍
Java开发工具包总共有两个部分：
1. JDK（Java Development Kits）
2. JRE（Java Runtime Environment）

JDK中文翻译叫Java开发工具组件，我们开发时使用的是JDK进行开发，同时Java也代指的是JDK。而JRE中文翻译叫Java运行环境，运行Java程序需要依赖这个。**单纯的JRE是不能开发程序的。** 因此我们需要下载JDK。同时由于JDK当中包含了JRE，所以不需要额外安装JRE。

## JDK的安装

1. 下载JDK 17
    进入网址：https://www.oracle.com/cn/java/technologies/downloads/#jdk17-windows
    我们选择`x64 Installer`

   Java 17没有32位版本，这就是为什么建议读者使用64位操作系统。

2. 下载完成后，双击Installer然后修改安装路径等待安装成功即可。（需要记住安装位置）

3. 右键此电脑，选择“属性”->“高级系统设置”->“环境变量”

4. 在下面的系统变量处点击“新建”输入变量名为“JAVA_HOME”（最好全部大写，不这样做的话一些软件会找不到环境变量）

5. 在变量值处将JDK的安装路径填入然后点击确定，再在系统变量处找到path变量，双击

6. 点击右侧的新建然后输入“%JAVA_HOME%/bin”然后点击确定，再点击下面的确定。

7. 按Win+R键，在运行窗口中输入cmd

8. 在弹出的窗口中输入下面两条指令

   ```bash
   java
   javac
   ```

   两条指令执行后的结果都不是“xxx不是可执行的程序”这句话就代表成功了，否则需要将Java彻底删掉然后重新执行1-6步。

   其中，`java`指令用以运行程序，`javac`指令用以编译程序。
   
   