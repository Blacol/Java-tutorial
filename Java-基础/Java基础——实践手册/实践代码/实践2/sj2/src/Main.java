import com.blacol.manage.core.StudentCore;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentCore studentCore=new StudentCore();
        while (true){
            System.out.println("""
                   请选择功能：
                   1. 创建学生
                   2. 编辑学生
                   3. 查询学生
                   4. 删除学生
                   5. 退出
                   """);
            Scanner scanner=new Scanner(System.in);
            int i = scanner.nextInt();
            switch (i){
                case 1->studentCore.createStudent();
                case 2-> {
                    System.out.println("请输入要编辑的学生ID：");
                    String id = scanner.next();
                    studentCore.updateStudent(id);
                }
                case 3->{
                    System.out.println("请输入要查询的学生ID：");
                    String id = scanner.next();
                    studentCore.checkStudent(id);
                }
                case 4->{
                    System.out.println("请输入要删除的学生ID：");
                    String id = scanner.next();
                    studentCore.deleteStudent(id);
                }
            }
            if (i==5){
                break;
            }
        }
    }
}