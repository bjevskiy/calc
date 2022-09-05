package calc;

import java.util.Locale;

// ТЗ Требования: П.1 Данные передаются в одну строку...
// ТЗ Требования: П.5 Калькулятор умеет работать только с арабскими или римскими цифрами одновременно...
// ТЗ Требования: П.7 При вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.
// ТЗ Требования: П.8 При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций, приложение выбрасывает исключение и завершает свою работу.
class InputService {
    public static Input parse(String data) {
        try {
            data = data.toUpperCase();
            String[] inputArray = data.split(" ");
            if (inputArray.length != 3) throw new Exception("throws Exception //т.к. формат математической операции не удовлетворяет заданию либо строка не является математической операцией");
            Number firstOperand = ConversionService.stringToNumber(inputArray[0]);
            Number secondOperand = ConversionService.stringToNumber(inputArray[2]);
            checkType(inputArray[0], secondOperand.getType());
            String operator = inputArray[1];
            if (operator.length()>1) throw new Exception("Неверный оператор");
            return new Input(firstOperand,secondOperand,operator);
        } catch(Exception e){
            System.out.println(e.getMessage());

            return null;
        }
    }

    static Number checkType(String symbol, Number.NumberType type) throws Exception {

        Number verify = ConversionService.stringToNumber(symbol);
        if (verify.getType() != type) {
            throw new Exception("throws Exception //т.к. используются одновременно разные системы счисления ");
        }

        return null;
    }
}