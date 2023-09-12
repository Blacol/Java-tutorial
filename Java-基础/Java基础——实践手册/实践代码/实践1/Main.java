import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入乘客数量");
        int count=scanner.nextInt();
        System.out.println("请输入里程数");
        double distance=scanner.nextDouble();
        double price=0;
        if(distance<2){
            price=0;
        }else if(distance>=2&&distance<6){
            price=2;
        }else if(distance>=6&&distance<10){
            price=4;
        }else if(distance>=10){
            price=4+(distance-10)*2;
        }
        double cost=0;
        cost=price*count;
        System.out.println("公里数："+distance+"公里");
        System.out.println("乘客数量："+count);
        System.out.println("票价："+price);
        System.out.println("总花费："+cost);
    }
}