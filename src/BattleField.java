public class BattleField {
    boolean isWon;
    public boolean fight(Unit hero, Unit monster) {

        // Runnable runnable = () -> {

            int turn = 1;
            boolean isFightEnded = false;
            while (!isFightEnded) {
                System.out.println("----Ход: " + turn + "----");

                if (turn++ % 2 != 0) {
                    isFightEnded = makeHit(monster, hero);
                } else {
                    isFightEnded = makeHit(hero, monster);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        //};

//        Thread thread = new Thread(runnable);
//        thread.start();
        return isWon;
    }

    public Boolean makeHit(Unit defender, Unit attacker) {

        int hit = attacker.attack();

        int defenderHealth = defender.getHealth() - hit;
        if (hit != 0) {
            System.out.println(String.format("%s Нанес удар в %d единиц!", attacker.getName(), hit));
            System.out.println(String.format("У %s осталось %d единиц здоровья...", defender.getName(), defenderHealth));
        } else {

            System.out.println(String.format("%s промахнулся!", attacker.getName()));
        }
        if (defenderHealth <= 0 && defender instanceof Hero) {

            System.out.println("Извините, вы пали в бою...");

            isWon=false;
            return true;
        } else if(defenderHealth <= 0) {
            //Если здоровья больше нет и защищающийся это монстр, то мы забираем от монстра его опыт и золото
            System.out.println(String.format("Враг повержен! Вы получаете %d опыт и %d золота", defender.getXp(), defender.getGold()));
            attacker.setXp(attacker.getXp() + defender.getXp());
            attacker.setGold(attacker.getGold() + defender.getGold());
            isWon=true;
            return true;
        } else {
            //если защищающийся не повержен, то мы устанавливаем ему новый уровень здоровья
            defender.setHealth(defenderHealth);
            return false;
        }
    }
}
