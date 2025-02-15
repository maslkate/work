
package example1;
 

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



 class computer {
    private String name;
    private String processor;
    
    public computer(String name, String processor) {
        this.name = name;
        this.processor = processor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void showSvoistva() {
        System.out.println("Название: " + name + ", Процессор: " + processor);
    }
}
 class GameComputer extends computer {
    private int OperMember; // В Гб
    private static int count = 0; //Количество созданных компов

    public GameComputer(String name, String processer, int opmember) {
        super(name, processer);
        this.OperMember = opmember;
        count++;
    }

    public int getOperMember() {
        return OperMember;
    }

    public void setOperMember(int opmember) {
        this.OperMember = opmember;
    }

    public static int getcount() {
        return count;
    }

    @Override
    public void showSvoistva() {
        super.showSvoistva();
        System.out.println("Оперативная память: " + OperMember + " Гб");
    }
}

class OfficeComputer extends computer {
    private int ObMember; // В Гб хранилище памяти
    private static int Count = 0;

    public OfficeComputer(String name, String processer, int obmember) {
        super(name, processer);
        this.ObMember = obmember;
        Count++;
    }

    public int getObMember() {
        return ObMember;
    }

    public void setObMember(int obmember) {
        this.ObMember = obmember;
    }

    public static int getCount() {
        return Count;
    }

    @Override
    public void showSvoistva() {
        super.showSvoistva();
        System.out.println("Объем хранения: " + ObMember + " Гб");
    }
}
public class Example1 {
    
     

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<computer> computers = new ArrayList<>();
        computers.add(new GameComputer("Игровой PC 1", "Intel i9", 32));
        computers.add(new GameComputer("Игровой PC 2", "Intel i5", 64));
        computers.add(new GameComputer("Игровой PC 3", "Intel i11", 128));
        computers.add(new OfficeComputer("Офисный PC 1", "Intel i5", 512));
        computers.add(new OfficeComputer("Офисный PC 2", "Intel i7", 1024));
        computers.add(new OfficeComputer("Офисный PC 3", "Intel i3", 128));
        
        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Отобразить свойства объектов");
            System.out.println("2. Изменить свойства объектов");
            System.out.println("3. Вычислить наибольшую оперативную память");
            System.out.println("4. Выход из программы");
            System.out.print("Выберите пункт меню: ");
            int vibor = scanner.nextInt();
            
            switch (vibor) {
                case 1:
                    for (computer comp : computers) {
                        comp.showSvoistva();
                    }
                    break;

                case 2:
                    System.out.print("Введите номер компьютера (1 - Игровой, 2 - Офисный): ");
                    int num = scanner.nextInt();
                    
                    if (num == 1) {
                        System.out.print("Введите номер игрового компьютера (1-3): ");
                        int numIC = scanner.nextInt();
                        System.out.print("Введите новую оперативную память: ");
                        int newOpMember = scanner.nextInt();
                        ((GameComputer) computers.get(numIC-1)).setOperMember(newOpMember);
                    } else if (num == 2) {
                        System.out.print("Введите номер офисного компьютера (1-3): ");
                        int numOC = scanner.nextInt();
                        System.out.print("Введите новый объем хранения: ");
                        int newOb = scanner.nextInt();
                        ((OfficeComputer) computers.get(numOC+2)).setObMember(newOb);
                    }
                    break;


                case 3:
                    int maxOpMember = 0;
                    for (computer comp : computers) {
                        if (comp instanceof GameComputer) {
                            maxOpMember = Math.max(maxOpMember, ((GameComputer) comp).getOperMember());
                        }
                    }
                    System.out.println("Наибольшая оперативная память: " + maxOpMember + " Гб");
                    break;



                case 4:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Некорректный выбор, пожалуйста, выберите снова.");
            }
        }
    }
}
    






 
   


