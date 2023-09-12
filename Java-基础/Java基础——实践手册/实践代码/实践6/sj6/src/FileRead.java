import com.blacol.score.entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileRead {
    public static ArrayList<Student> readFile(String fileName) {
        File f=new File(fileName);
        try {
            BufferedReader reader=new BufferedReader(new FileReader(f));
            String str="";
            ArrayList<Student> studentList=new ArrayList<>();
            reader.readLine();//读出标题行并忽略
            while (true){
                str = reader.readLine();
                if (str==null)
                    break;
                //将成绩数据从文件中取出然后封装为对象。最后存入集合中
                String[] splits = str.split(",");
                Student student = new Student();
                student.setName(splits[0]);
                int[] score_list=new int[7];
                //将获取到的字符串类型的分数转换为整数型分数存入对象中。
                for(int i=1;i<splits.length;i++){
                    score_list[i-1]=Integer.parseInt(splits[i]);
                }
                student.setScores(score_list);
                studentList.add(student);
            }
            return studentList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
