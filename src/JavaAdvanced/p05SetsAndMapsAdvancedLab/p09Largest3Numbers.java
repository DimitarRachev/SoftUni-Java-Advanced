package JavaAdvanced.p05SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p09Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1ST
//        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//
//        nums = Arrays.stream(nums).sorted().toArray();
//
//        int j = nums.length - 1;
//        for (int i = 0; i < 3; i++) {
//            System.out.print(nums[j--] + " ");
//        }

        //2ND
//                List<Integer> nums = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
//                nums.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(e -> System.out.print(e + " "));


        //3D
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).sorted(Comparator.reverseOrder()).limit(3).forEach(e -> System.out.print(e + " "));

    }
}
