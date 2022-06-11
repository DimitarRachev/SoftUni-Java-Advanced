package examPreparation.javaAdvancedExam19February2022;


import java.util.*;

public class p01FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> vowels = new ArrayDeque<>();
        ArrayDeque<String> consonants = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> vowels.offer(e));
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(consonants::offer);
        FoodHolder foodHolder = new FoodHolder(new String[]{"pear", "flour", "pork", "olive"});

        while (!consonants.isEmpty()) {
            String vowel = vowels.poll();
            vowels.offer(vowel);
            String consonant = consonants.pop();
            foodHolder.checkFood(vowel, consonant);
        }

        List<Food> found = foodHolder.getFoundFoods();

        System.out.println("Words found: " + found.size());
        found.forEach(System.out::println);
    }

    static class FoodHolder {
        List<Food> foods =new ArrayList<>();

        public FoodHolder(String[] foods ) {
            for (String food : foods) {
                this.foods.add(new Food(food));
            }
        }

            public void checkFood (String vowel, String consonant){
                for (Food food : foods) {
                    food.checkChar(vowel);
                    food.checkChar(consonant);
                }
            }

            public List<Food> getFoundFoods () {
                List<Food> found = new ArrayList<>();
                for (Food food : foods) {
                    if (food.isFound()) {
                        found.add(food);
                    }
                }
                return found;
            }
        }

        static class Food {
             String name;
             String nameForCheck;

            public Food(String name) {
                this.name = name;
                this.nameForCheck = name;
            }

            public void checkChar(String chara) {
                nameForCheck = nameForCheck.replace(chara, "");
            }

            public boolean isFound() {
                return nameForCheck.length() == 0;
            }

            @Override
            public String toString() {
                return name;
            }
        }
    }
