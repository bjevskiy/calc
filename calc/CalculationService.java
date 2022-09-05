package calc;
// ТЗ Требования: П.6 При вводе римских чисел, ответ должен быть выведен римскими цифрами, соответственно, при вводе арабских - ответ ожидается арабскими.
// ТЗ Требования: П.8 При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций, приложение выбрасывает исключение и завершает свою работу.
// ТЗ Требования: П.9 Результатом операции деления является целое число, остаток отбрасывается.
/* ТЗ Требования: П.10 Результатом работы калькулятора с арабскими числами могут быть отрицательные числа и ноль.
     Результатом работы калькулятора с римскими числами могут быть только положительные числа, если результат работы меньше единицы, выбрасывается исключение */
class CalculationService {
    public static String calculate(Number num1, Number num2, String operator) throws Exception {

        int result;

        switch (operator) {
            case "+":
                result = num1.getValue() + num2.getValue();
                break;
            case "-":
                result = num1.getValue() - num2.getValue();
                break;
            case "*":
                result = num1.getValue() * num2.getValue();
                break;
            case "/":
                result = num1.getValue() / num2.getValue();
                break;
            default:
                throw new Exception("Недопустимый оператор. Доступные операторы: +, -, *, /");
        }
        if (result < 1 && num1.getType() == Number.NumberType.ROMAN) throw new Exception("throws Exception //т.к. в римской системе нет отрицательных чисел");
        if (num1.getType() == Number.NumberType.ROMAN) {
            return ConversionService.intToRoman(result);
        } else return String.valueOf(result);
    }
}
