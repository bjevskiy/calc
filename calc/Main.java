package calc;

import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        calc(input);
    }

    public static String calc (String input) {
        try {
            String result = CalculationService.calculate(InputService.parse(input).getFirstOperand(), InputService.parse(input).getSecondOperand(), InputService.parse(input).getOperator());
            System.out.println(result);
            return result;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}

