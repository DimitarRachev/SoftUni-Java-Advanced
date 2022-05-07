package JavaAdvanced.p11DefiningClassesLab.p03BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, BankAccount> accountsMap = new HashMap<>();
        String line;
        while (!"End".equals(line = scanner.nextLine())) {
            String[] input = line.split("\\s+");
            String command = input[0];
            if (command.equals("Create")) {
                createAccount(accountsMap);
            } else if (command.equals("Deposit")) {
                depositInAccount(accountsMap, input);
            } else if (command.equals("SetInterest")) {
                double newInterestRate = Double.parseDouble(input[1]);
                BankAccount.setInterestRate(newInterestRate);
            } else if (command.equals("GetInterest")) {
                printInterest(accountsMap, input);
            }
        }
    }

    private static void printInterest(Map<Integer, BankAccount> accountMap, String[] input) {
        int accId = Integer.parseInt(input[1]);
        double value = Double.parseDouble(input[2]);
        if (!accountMap.containsKey(accId)) {
            System.out.println("Account does not exist");
        } else {
            System.out.printf("%.2f%n", accountMap.get(accId).getInterest(value));
        }
    }

    private static void depositInAccount(Map<Integer, BankAccount> accountMap, String[] input) {
        int accId = Integer.parseInt(input[1]);
        double value = Double.parseDouble(input[2]);
        if (!accountMap.containsKey(accId)) {
            System.out.println("Account does not exist");
        } else {
            accountMap.get(accId).Deposit(value);
            System.out.printf("Deposited %.0f to ID%d%n", value, accId);
        }
    }

    private static void createAccount(Map<Integer, BankAccount> accountMap) {
        BankAccount account = new BankAccount();
        accountMap.put(account.getId(), account);
        System.out.printf("Account ID%d created%n", account.getId());
    }
}
