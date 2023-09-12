import com.blacol.score.entity.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static void check(int course){
        ArrayList<Student> students = FileRead.readFile("项目数据.csv");
        ArrayList<Integer> course_score=new ArrayList<>();
        for (Student s:students){
            //将每个学生的某一科目学习成绩取出放入列表中
            course_score.add(s.getScores()[course-1]);
        }
        //找出最大值、最小值、平均值
        int max=course_score.get(0);
        String maxStudentName=students.get(0).getName();
        int min=course_score.get(0);
        String minStudentName=students.get(0).getName();
        int sum=course_score.get(0);
        for (int i1=1;i1<course_score.size();i1++){
            sum+=course_score.get(i1);//计算所有成绩和
            if(course_score.get(i1)>max){
                max=course_score.get(i1);
                maxStudentName=students.get(i1).getName();
            }
            if(course_score.get(i1)<min){
                min=course_score.get(i1);
                minStudentName=students.get(i1).getName();
            }
        }
        double average= (double) sum /course_score.size();
        String result= """
                成绩分析如下：
                最高分为：%s（%s分）
                最低分为：%s（%s分）
                平均分：%.2f
                """;
        System.out.printf(result,maxStudentName,max,minStudentName,min,average);

    }
    public static void main(String[] args) {
        System.out.println("请选择要查询的成绩：\n");
        System.out.println("1.数学 2.语文 3.英语 4.物理 5.化学 6.生物 7.信息技术");
        Scanner scanner=new Scanner(System.in);
        int course=scanner.nextInt();
        check(course);
    }
}