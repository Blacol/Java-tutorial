package com.blacol.manage.core;

import com.blacol.manage.entity.Student;

import java.util.Scanner;

public class StudentCore {
    private Scanner scanner=new Scanner(System.in);
    private Student[] students=new Student[10];//我们先规定只能存10个数据，满了之后会将最后一个数据删除
    public void createStudent(){
        Student student=new Student();//定义一个学生类来存储用户输入的学生信息
        System.out.println("请输入学生的学号：");
        String id = scanner.next();
        student.setId(id);
        System.out.println("请输入学生姓名：");
        String name = scanner.next();
        student.setName(name);
        System.out.println("请输入学生的性别（男生写男，女生写女）：");
        String gender = scanner.next();
        student.setGender(gender.charAt(0));
        System.out.println("请输入学生的班级：");
        String clazz = scanner.next();
        student.setClazz(clazz);
        System.out.println("请输入学生的年龄：");
        int age = scanner.nextInt();
        student.setAge(age);
        for (int i=0;i<students.length;i++){
            if (students[i]==null){
                students[i]=student;
                return;
            }
        }
        students[students.length-1]=student;
    }
    public void updateStudent(String id){
        for (int i=0;i<students.length;i++){
            if (students[i]!=null){
                if (students[i].getId().equals(id)){
                    Student student=students[i];
                    System.out.println("请输入学生的学号：");
                    String queryId = scanner.next();
                    student.setId(queryId);//因为参数表中已经有名为id的变量了，所以改名叫queryId
                    System.out.println("请输入学生姓名：");
                    String name = scanner.next();
                    student.setName(name);
                    System.out.println("请输入学生的性别（男生写男，女生写女）：");
                    String gender = scanner.next();
                    student.setGender(gender.charAt(0));
                    System.out.println("请输入学生的班级：");
                    String clazz = scanner.next();
                    student.setClazz(clazz);
                    System.out.println("请输入学生的年龄：");
                    int age = scanner.nextInt();
                    student.setAge(age);
                    return;
                }
            }
        }
        System.out.printf("没有学号为%s的学生！",id);
    }
    public void deleteStudent(String id){
        for (int i=0;i<students.length;i++){
            if (students[i]!=null){
                if (students[i].getId().equals(id)){
                    students[i]=null;
                    return;
                }
            }
        }
        System.out.printf("没有学号为%s的学生！",id);
    }
    public void checkStudent(String id){
        for (int i=0;i<students.length;i++){
            if (students[i]!=null){
                if (students[i].getId().equals(id)){
                    Student s=students[i];
                    System.out.printf("""
                           学号：%s
                           姓名：%s
                           性别：%c
                           年龄：%d
                           班级：%s
                           """,s.getId(),s.getName(),s.getGender(),s.getAge(),s.getClazz());
                    return;
                }
            }
        }
        System.out.printf("没有学号为%s的学生！",id);
    }
}
