import com.blacol.zoo.entity.Animal;
import com.blacol.zoo.entity.Cat;
import com.blacol.zoo.entity.Dog;
import com.blacol.zoo.entity.Fox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("你要听哪个动物的叫声呢？我们提供狗：dog、猫：cat、狐狸：fox。\n输入对应的单词即可听取声音");
        Scanner scanner=new Scanner(System.in);
        String animal = scanner.next();
        switch (animal){
            case "dog","Dog","DOG"->{
                Dog dog=new Dog();
                dog.call();
            }
            case "cat","Cat","CAT"->{
                Cat cat=new Cat();
                cat.call();
            }
            case "fox","Fox","FOX"->{
                Fox fox=new Fox();
                fox.call();
            }
            default -> {
                Animal animal1=new Animal();
                animal1.call();
            }
        }
    }
}