import java.util.*;

public class MonsterCreation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask the user to create the first monster
        System.out.println("creating Monster 1:");
        Monster parent1 = createMonster(input);

        // Ask the user to create the second monster
        System.out.println("\ncreating Monster 2:");
        Monster parent2 = createMonster(input);

        // Create a baby monster by combining traits from the parents
        Monster babyMonster = Monster.createBabyMonster(parent1, parent2);

        // Display information about the created monsters
        displayMonsterInfo("Monster 1", parent1);
        displayMonsterInfo("Monster 2", parent2);
        displayMonsterInfo("Baby Monster", babyMonster);
    }

    // Helper method to create a monster by asking the user questions
    private static Monster createMonster(Scanner scanner) {
        System.out.print("eye Color: ");
        String eyeColor = scanner.nextLine();

        System.out.print("feather Color: ");
        String featherColor = scanner.nextLine();

        System.out.print("magical Abilities: ");
        String magicalAbilities = scanner.nextLine();

        System.out.print("size: ");
        String size = scanner.nextLine();

        System.out.print("strength: ");
        String strength = scanner.nextLine();

        System.out.print("durability: ");
        String durability = scanner.nextLine();

        System.out.print("weakness: ");
        String weakness = scanner.nextLine();

        System.out.print("aggression Level: ");
        String aggressionLevel = scanner.nextLine();

        // Create and return a new monster
        return new Monster(eyeColor, featherColor, magicalAbilities, size, strength, durability, weakness, aggressionLevel);
    }

    // Helper method to display information about a monster
    private static void displayMonsterInfo(String monsterName, Monster monster) {
        System.out.println("\n" + monsterName + " Information:");
        System.out.println("eye Color: " + monster.getEyeColor());
        System.out.println("feather Color: " + monster.getFeatherColor());
        System.out.println("magical Abilities: " + monster.getMagicalAbilities());
        System.out.println("size: " + monster.getSize());
        System.out.println("strength: " + monster.getStrength());
        System.out.println("durability: " + monster.getDurability());
        System.out.println("weakness: " + monster.getWeakness());
        System.out.println("aggression Level: " + monster.getAggressionLevel());
    }
}

class Monster {
    private String eyeColor;
    private String featherColor;
    private String magicalAbilities;
    private String size;
    private String strength;
    private String durability;
    private String weakness;
    private String aggressionLevel;

    // Constructor
    public Monster(String eyeColor, String featherColor, String magicalAbilities, String size,
                   String strength, String durability, String weakness, String aggressionLevel) {
        this.eyeColor = eyeColor;
        this.featherColor = featherColor;
        this.magicalAbilities = magicalAbilities;
        this.size = size;
        this.strength = strength;
        this.durability = durability;
        this.weakness = weakness;
        this.aggressionLevel = aggressionLevel;
    }

    // Getters for traits
    public String getEyeColor() {
        return eyeColor;
    }

    public String getFeatherColor() {
        return featherColor;
    }

    public String getMagicalAbilities() {
        return magicalAbilities;
    }

    public String getSize() {
        return size;
    }

    public String getStrength() {
        return strength;
    }

    public String getDurability() {
        return durability;
    }

    public String getWeakness() {
        return weakness;
    }

    public String getAggressionLevel() {
        return aggressionLevel;
    }

    // Method to create a baby monster by combining traits from two parent monsters
    public static Monster createBabyMonster(Monster parent1, Monster parent2) {
        Random random = new Random();

        // Randomly select traits from parents
        String eyeColor = random.nextBoolean() ? parent1.getEyeColor() : parent2.getEyeColor();
        String featherColor = random.nextBoolean() ? parent1.getFeatherColor() : parent2.getFeatherColor();
        String magicalAbilities = random.nextBoolean() ? parent1.getMagicalAbilities() : parent2.getMagicalAbilities();
        String size = random.nextBoolean() ? parent1.getSize() : parent2.getSize();
        String strength = random.nextBoolean() ? parent1.getStrength() : parent2.getStrength();
        String durability = random.nextBoolean() ? parent1.getDurability() : parent2.getDurability();
        String weakness = random.nextBoolean() ? parent1.getWeakness() : parent2.getWeakness();
        String aggressionLevel = random.nextBoolean() ? parent1.getAggressionLevel() : parent2.getAggressionLevel();

        // Create and return a new baby monster
        return new Monster(eyeColor, featherColor, magicalAbilities, size, strength, durability, weakness, aggressionLevel);
    }
}