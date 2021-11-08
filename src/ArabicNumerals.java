public class ArabicNumerals {
    public static int fromArabic(String num) throws NullPointerException{
        return switch (num){
            case ("I") ->1;
            case ("II") ->2;
            case ("III") ->3;
            case ("IV") ->4;
            case ("V") ->5;
            case ("VI") ->6;
            case ("VII") ->7;
            case ("VIII") ->8;
            case ("IX") ->9;
            case ("X") ->10;
            default ->0;
        };
    }
    public static String toArabic(int num){
        return switch (num) {
            case (1) -> "I";
            case (2) -> "II";
            case (3) -> "III";
            case (4) -> "IV";
            case (5) -> "V";
            case (6) -> "VI";
            case (7) -> "VII";
            case (8) -> "VIII";
            case (9) -> "IX";
            case (10) -> "X"; // значения взяла до 10, код можно дописать таким способом до ста
            default -> "0";
        };
    }
}
