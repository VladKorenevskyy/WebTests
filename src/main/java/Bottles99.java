import java.util.Locale;

public class Bottles99 {
    /*
    str1 + str2 -> String
    str1.concat(str2)
    StringBuilder.append() --> String.ValueOf(stringBuilder) or String(stringBuilder)  fastest
    StringBuffer.append() --> String(stringBuffer)
    */

    private static final String BOTTLES = " bottles of beer";
    private static final String BOTTLE = " bottle of beer";
    private static final String WALL = " on the wall";
    private static final String NO_MORE = "No more";
    private static final String COMMA_SPACE = ", ";
    private static final String DOT = ".";
    private static final String TAKE = "Take one down and pass it around";
    private static final String GO = "Go to the store and buy some more";
    private static final String NEW_RESULT = "";
    private static final String ENTER = "\n";

    public static String getBottles(int index, String bottles) {
        StringBuilder result = new StringBuilder();

        return String.valueOf(result.append(index).append(bottles));
    }

    public static String getBottles(String noMore, String bottles) {
        StringBuilder result = new StringBuilder();

        return String.valueOf(result.append(noMore).append(bottles));
    }

    public static String getWall(String punctuation) {
        StringBuilder result = new StringBuilder();

        return String.valueOf(result.append(WALL).append(COMMA_SPACE));
    }

    public static String getText(int i, String bottle) {
        StringBuilder result = new StringBuilder();

        result
                .append(TAKE)
                .append(COMMA_SPACE)
                .append(getBottles(i, bottle))
                .append(getWall(DOT))
                .append(getBottles(i, bottle))
                .append(getWall(COMMA_SPACE))
                .append(getBottles(i, bottle))
                .append(DOT)
                .append(ENTER);

        return String.valueOf(result);
    }

    public static String getText() {
        StringBuilder result = new StringBuilder();

        result
                .append(TAKE)
                .append(COMMA_SPACE)
                .append(getBottles(NO_MORE.toLowerCase(), BOTTLES))
                .append(getWall(DOT))
                .append(getBottles(NO_MORE, BOTTLES))
                .append(getWall(COMMA_SPACE))
                .append(getBottles(NO_MORE, BOTTLES))
                .append(DOT)
                .append(ENTER);

        return String.valueOf(result);
    }

    private static String songLyrics() {
        StringBuilder expectedResult = new StringBuilder();

        for (int i = 99; i >=0; i--) {
            if (i == 99) {
                expectedResult
                        .append(getBottles(i, BOTTLES))
                        .append(getWall(COMMA_SPACE))
                        .append(getBottles(i, BOTTLES))
                        .append(DOT)
                        .append(ENTER);
            } else if(i == 0) {
                expectedResult.append(getText());

                expectedResult
                        .append(GO)
                        .append(COMMA_SPACE)
                        .append(getBottles(99, BOTTLES))
                        .append(getWall(DOT));
            }else {
                if(i != 1 ) {
                    expectedResult.append(getText(i, BOTTLES));
                } else if (i == 1) {
                    expectedResult.append(getText(i, BOTTLE));
                }
            }
        }
        return String.valueOf(expectedResult);
    }

    public static void main(String[] args) {
        System.out.println(songLyrics());
    }
}

