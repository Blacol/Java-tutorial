package com.blacol.bank.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActionUtil {
    private static BigDecimal balance=new BigDecimal("0").setScale(2, RoundingMode.FLOOR);//余额
    private static List<String> actionLog=new ArrayList<>();//List是一种集合类，它与数组类似。关于集合会在第19课中讲到。

    /**
     * 存钱操作
     * @param num 存款金额
     * @return 操作后的余额
     */
    public static BigDecimal save(BigDecimal num){
        balance=balance.add(num);
        Date time=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StringBuilder sb=new StringBuilder();
        //该部分按照 存入日期/操作人/操作/操作金额/余额 的格式生成操作记录。
        //日期需要格式化固分为两部分，一部分是存入日期，另一部分是/操作人/操作/操作金额/余额
        String part2=String.format("/用户/存入/%.2f/%.2f",num,balance);
        sb.append(simpleDateFormat.format(time)).append(part2);
        actionLog.add(sb.toString());//向操作日志集合中插入数据。
        return balance;
    }

    /**
     * 取款操作
     * @param num 取出的金额
     * @return 操作后的余额
     */
    public static BigDecimal withdrawal(BigDecimal num){
        if (balance.compareTo(num)>=0){
            //这里判断一下余额是否充足，充足的时候才会取出。
            balance=balance.subtract(num);
            Date time=new Date();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            StringBuilder sb=new StringBuilder();
            String part2=String.format("/用户/取出/%.2f/%.2f",num,balance);
            sb.append(simpleDateFormat.format(time)).append(part2);
            actionLog.add(sb.toString());
        }else{
            Date time=new Date();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            StringBuilder sb=new StringBuilder();
            String part2=String.format("/用户/取出/%.2f/(余额不足)",num);
            sb.append(simpleDateFormat.format(time)).append(part2);
            System.out.println("余额不足！");
        }
        return balance;
    }
    public static BigDecimal getBalance(){
        return balance;
    }
    public static void printLog(){
        if(actionLog.size()>0){
            Date time=new Date();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            StringBuilder builder=new StringBuilder("截止到");
            builder.append(simpleDateFormat.format(time)).append("的操作记录").append("txt");
            File f=new File(builder.toString());
            try {
                Writer writer=new FileWriter(f);
                writer.write("存入日期/操作人/操作/操作金额/余额\n");//输出记录表标题
                for (String log:actionLog){
                    writer.write(log+"\n");
                }
                writer.close();
                System.out.println("操作记录导出成功!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("没有任何操作记录！");
        }

    }
}
