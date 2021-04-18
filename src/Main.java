import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {
    private static BufferedReader br;
    private static Unit player = null;
    //private static Unit monster = null;
    private static BattleField battleField = null;


    public static void main(String[] args) {
        battleField = new BattleField();
        br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите имя игрока:");
          try {
            player = new Hero(br.readLine(), 100, 100, 10, 0, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Игрок " + player + " готов к битве!");
//        Unit monster = createMonster();
//        System.out.println("Monster " + monster + " is ready to fight!");

        printMenu();
        try {
            makeChoice(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void makeChoice(String str) throws IOException{

        switch (str) {
            case "1":
                System.out.println("Хотите восстановить здоровье на 50 единиц за 10 монет(y/n)?");
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.nextLine();
                switch (choice) {
                    case "y": {
                        if (player.getGold() >= 10) {
                            player.setGold(player.getGold() - 10);
                            player.setHealth(player.getHealth() + 50);
                            System.out.println("У вас теперь " + player.getHealth() + " единиц здоровья");
                        } else System.out.println("Недостаточно золота");
                    }
                    break;
                }
                printMenu();
                makeChoice(br.readLine());
                break;
            case "2":
            case "y":
                startFight();
                break;
            case "3":
                System.out.println("Game Over!");
                System.exit(0);
                break;
            case "n":
                printMenu();
                makeChoice(br.readLine());
                break;

            default:
                System.out.println("Неверная команда");
                printMenu();
                makeChoice(br.readLine());
                break;

        }
    }

    private static void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Покупка лечения");
        System.out.println("2. Битва с монстрами");
        System.out.println("3. Выход");
    }

    private static Unit createMonster() {

        int random = (int) (Math.random() * 10);

        if (random % 2 == 0) return new Goblin(
                "Goblin",
                50,
                40,
                10,
                100,
                20
        );
        else return new Skeleton(
                "Skeleton",
                25,
                30,
                20,
                100,
                10
        );
    }

    private static void startFight() {
        if(battleField.fight(player, createMonster())) {
            System.out.println("Вы победили!");
            System.out.println("Продолжаем поход(y) или идем домой в город(n)?");
            try {
                makeChoice(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else {
            System.exit(0);
        }


    }


}
