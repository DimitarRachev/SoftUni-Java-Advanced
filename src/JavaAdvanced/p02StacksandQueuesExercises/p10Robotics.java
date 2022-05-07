package JavaAdvanced.p02StacksandQueuesExercises;

import java.util.*;

public class p10Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Robot> robots = new ArrayList<>();
        String[] robo = scanner.nextLine().split(";");
        setRobots(robo, robots);

        int[] startTime = Arrays.stream(scanner.nextLine().split(":")).mapToInt(Integer::parseInt).toArray();
        int currentTime = startTime[2] + startTime[1] * 60 + startTime[0] * 3600;

        ArrayDeque<String> products = new ArrayDeque<>();
        String line;
        //get products from console
        while (!"End".equals(line = scanner.nextLine())) {
            products.offer(line);
        }


        while (!products.isEmpty()) {
            String currentProduct = products.poll();
            currentTime++;
            boolean isProductTaken = false;
            for (Robot robot : robots) {
                if (robot.isAvailable() && !isProductTaken) {
                    robot.takeJob(currentProduct, currentTime);
                    isProductTaken = true;
                } else {
                    robot.doJob();
                }
            }
            if (!isProductTaken) {
                products.offer(currentProduct);
            }
        }
    }

    private static void setRobots(String[] robo, List<Robot> robots) {
        for (String s : robo) {
            String name = s.split("-")[0];
            int speed = Integer.parseInt(s.split("-")[1]);
            Robot robot = new Robot(name, speed);
            robots.add(robot);
        }
    }

    static class Robot {
        String name;
        int speed;
        ArrayDeque<Integer> workingState = new ArrayDeque<>();

        public Robot(String name, int speed) {
            this.name = name;
            this.speed = speed;
        }

        public boolean isAvailable() {
            return workingState.isEmpty();
        }

        public void takeJob(String currentProduct, int currentTime) {
            for (int i = 0; i < speed -1; i++) {
                workingState.push(1);
            }
            String time = convertTime(currentTime);
            System.out.printf("%s - %s [%s]%n", this.name, currentProduct, time);
        }

        private String convertTime(int currentTime) {
            int hours = currentTime / 3600;
            currentTime = currentTime % 3600;
            int min = currentTime / 60;
            int sec = currentTime % 60;
//            while (min >= 60) {
//                min -= 60;
//                hours++;
//            }
            while (hours >= 24) {
                hours -= 24;
            }

            return String.format("%02d:%02d:%02d", hours, min, sec);
        }

        public void doJob() {
            if (!workingState.isEmpty()) {
                workingState.pop();
            }
        }
    }
}
