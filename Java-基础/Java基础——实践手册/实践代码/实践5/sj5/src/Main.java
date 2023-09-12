import com.blacol.bank.util.ActionUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
    private static void doSave(Scanner scanner){
        System.out.println("请输入存款金额：");
        BigDecimal num = scanner.nextBigDecimal();
        //当用户输入的金额超出两位小数，使用下取整变为两位
        num=num.setScale(2, RoundingMode.FLOOR);
        BigDecimal save = ActionUtil.save(num);
        System.out.println("余额为："+save);
    }
    private static void doWithdrawal(Scanner scanner){
        System.out.println("余额："+ActionUtil.getBalance());
        System.out.println("请输入取款金额：");
        BigDecimal num = scanner.nextBigDecimal();
        num=num.setScale(2, RoundingMode.FLOOR);
        BigDecimal withdrawal = ActionUtil.withdrawal(num);
        System.out.println("余额为："+withdrawal);
    }
    public static void main(String[] args) {
        Boolean stop=false;
        System.out.println("""
                   1.存款
                   2.取款
                   3.查询余额
                   4.导出操作日期
                   5.退出
                   """);
        while (!stop){
            Scanner scanner=new Scanner(System.in);
            int i = scanner.nextInt();
            switch (i){
                case 1->{
                    doSave(scanner);
                }
                case 2->{
                    doWithdrawal(scanner);
                }
                case 3-> System.out.println("余额："+ActionUtil.getBalance());

                case 4-> ActionUtil.printLog();
                case 5-> stop=true;
                default -> System.out.println("请输入正确的编号！");
            }
        }
    }
}