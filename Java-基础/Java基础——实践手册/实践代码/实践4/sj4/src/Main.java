import com.blacol.util.NumberUtil;

public class Main {
    public static void main(String[] args) {
        //使用NumberUtil类中的各个方法
        double add_1 = NumberUtil.add(7, 1);
        System.out.println("第一次运算结果："+add_1);
        System.out.println("上一次运算结果："+NumberUtil.last());
        double add_2=NumberUtil.add(1.1,5.5);
        System.out.println("第二次运算结果："+add_2);
        System.out.println("上一次运算结果："+NumberUtil.last());
        double add_3=NumberUtil.add(1.4,3.6,9.5,10,17);
        System.out.println("第三次运算结果："+add_3);
        double subtract=NumberUtil.subtract(9,6,-7,-11);
        double multiply=NumberUtil.multiply(6,3,5,9,10);
        double divide=NumberUtil.divide(155,3,2,4);
        System.out.println(String.format("""
                   减法结果：%g
                   乘法结果：%g
                   除法结果：%g
                   """,subtract,multiply,divide));
    }
}