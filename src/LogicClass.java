import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Locale;


public class LogicClass {
    public static void run(){
        boolean isArabic = false;
        String firstNum = "null";
        String secondNum;
        char sign = '\u0000';
        StringBuilder tmp = new StringBuilder();
        String getLine = ReadData.getLine();
        char[] symbols;
        symbols = parsExpression(getLine);
        for (char symbol : symbols) {
            if ((symbol == '+') | (symbol == '-') | (symbol == '*') | (symbol == '/')) {
                sign = symbol;
                firstNum = String.valueOf(tmp);
                tmp.setLength(0);
            } else {
                tmp.append(symbol);
            }
        }
        secondNum = String.valueOf(tmp);
        if (sign == '\u0000'){
            try{
                throw new MyException();
            }catch (MyException ignored){
        }
    }
        int n = 0;
        int m = 0;
        int result = 0;
        if (checkForRim(firstNum, secondNum)){
            n = Integer.parseInt(firstNum);
            m = Integer.parseInt(secondNum);
        }else {
            if (checkForArabic(firstNum, secondNum)){
                n = ArabicNumerals.fromArabic(firstNum);
                m = ArabicNumerals.fromArabic(secondNum);
                isArabic = true;
            }else{
                try{
                    throw new Exception();
                }catch (Exception ignored){}
            }
        }
        if ((n>=1 & n<=10) & (m>=1 & m<=10)){
            if (sign == '+'){
                result = MathExpression.sum(n, m);
            }else {
                if (sign == '-'){
                    result = MathExpression.diff(n, m);
                }else {
                    if (sign == '*'){
                        result = MathExpression.multi(n, m);
                    }else {
                        if (sign == '/'){
                            result = MathExpression.div(n, m);
                        }else{
                            return;
                        }
                    }
                }
            }
            if (isArabic){
                if (result < 0){
                    result = Math.abs(result);
                    System.out.println("-" + ArabicNumerals.toArabic(result));
                }else {
                    System.out.println(ArabicNumerals.toArabic(result));
                }
            }else{
                System.out.println(result);
            }
        }else{
            try{
                throw new Exception();
            }catch (Exception ignored){}
        }
    }
     public static char[] parsExpression(String expression){
        String text = expression.toUpperCase();
        String tmp;
        tmp = text.replaceAll("\\s+", "");
        char[] symbols = new char [tmp.length()];
        for (int i = 0; i < symbols.length; i++){
            symbols[i] = tmp.charAt(i);
        }
        return symbols;
    }
    public static boolean checkForRim(String first, String second){
        boolean firstCheck = false;
        boolean secondCheck = false;
        try{
            Integer.parseInt(first);
            firstCheck = true;
        }catch (NumberFormatException | NullPointerException ignored){
        }
        try{
            Integer.parseInt(second);
            secondCheck = true;
        }catch (NumberFormatException | NullPointerException ignored){
                    }
        return firstCheck & secondCheck;
    }
     public static boolean checkForArabic(String first, String second){
        boolean firstCheck = true;
        boolean secondCheck = false;
        try{
            Integer.parseInt(first);
        }catch  (NumberFormatException ignored){
            firstCheck = false;
        }catch (NullPointerException ignored){
            System.out.println(" Что-то пошло не так, попробуйте ввести другие корректные данные.");
        }
        try{
           Integer.parseInt (second);
        }catch (NumberFormatException ignored){
            secondCheck = true;
        }catch (NullPointerException ignored){
            System.out.println("Что-то пошло не так, попробуйте ввести другие корректные данные.");
        }
        return firstCheck & secondCheck;
    }
}
