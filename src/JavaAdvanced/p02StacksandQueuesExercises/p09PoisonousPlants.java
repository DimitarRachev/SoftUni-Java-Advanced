package JavaAdvanced.p02StacksandQueuesExercises;

import java.util.*;

public class p09PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        List<Integer> plants = new ArrayList<>();
//        int n = Integer.parseInt(scanner.nextLine());
//        int[] pesticide = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//        for (int i = 0; i < n; i++) {
//            plants.add(pesticide[i]);
//        }
//
//        int dayCounter = 0;
//        while (true) {
//            dayCounter++;
//            boolean haveDeaths = false;
//            for (int i = plants.size() - 1; i > 0; i--) {
//                if (plants.get(i) > plants.get(i -1)) {
//                    plants.remove(i);
//                    haveDeaths = true;
//               }
//            }
//            if (!haveDeaths) {
//                break;
//            }
//        }
//        System.out.println(dayCounter - 1);

        Deque<Integer> plants = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        int[] pesticide = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = n - 1; i >= 0; i--) {
            plants.offer(pesticide[i]);
        }
        int day =-1;
        boolean haveDead = false;
        do {
            haveDead = false;
            for (int i = plants.size()-1; i > 0; i--) {
                int temp = plants.poll();
                int left = plants.peek();
                if (temp > left) {
                    haveDead = true;
                } else {
                    plants.offer(temp);
                }
            }
            plants.offer(plants.pop());
            day++;
        } while (haveDead);
        System.out.println(day);

    }
}

