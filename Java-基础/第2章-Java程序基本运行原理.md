[TOC]
# Java程序基本运行原理

## 本章任务：

- [ ] 理解JVM、JRE、JDK三者之间的关系
- [ ] 掌握通过命令行运行程序的方法

## JVM
Java具有跨平台的特点，这一点得益于JVM的存在。JVM全称叫Java虚拟机。

JVM在任何平台中都有（在一些平台上可能需要安装JRE或者JDK才存在，比如Windows操作系统，以及自带JVM的安卓操作系统。），只要你把Java的编译文件（.class文件）放入到虚拟机中就可以执行，无论虚拟机在哪个平台上。

## JDK、JRE、JVM的关系与Java程序运行基本原理
JDK包含JRE，JRE包含JVM。如下图所示：
![JDK、JRE、JVM的关系](https://s2.loli.net/2022/12/27/DA6dqC7jT1rFpvs.png)

Java的程序运行过程是这样的：
![运行过程](https://s2.loli.net/2022/12/27/pBH1uVqja2fn3kR.png)

1. 程序员手动编写Java代码
2. 交给javac编译
3. 将编译好的`.class`文件交给JVM执行
4. 执行程序

由于计算机只认识二进制编码（0和1），对于程序员用高级编程语言编写的java代码计算机无法处理，因此要变成机器可读的代码，而javac和JVM就是干这个的。javac负责编译，JVM负责执行。
## 案例一、体会Java程序运行过程
在理解了Java程序的运行原理之后可以根据这个案例体会一下运行过程。
1. 在含有非中文路径下建立一个`Hello.java`文件
2. 使用记事本打开，在里面输入下面的代码：
    ```java
    public class Hello{
        public static void main(String[] args){
            System.out.println("Hello");
        }
    }
    ```
    然后保存。
3. 在当前目录下打开命令行，输入下面的指令：
    ```bash
    javac Hello.java
    ```
4. 输入完成后可以看到和`Hello.java`同一目录下有一个叫`Hello.class`的文件，这个文件就是javac编译出来的文件。
5. 再在命令行下输入`java Hello`就会发现控制台打印了一句Hello，这就代表程序被执行了。

第三步就是编译步骤，由javac对`Hello.java`文件进行编译，生成`Hello.class`然后在执行`java`指令后调用JVM将`Hello.class`执行。

对于JVM具体是怎么执行class文件的可以先不用知道。