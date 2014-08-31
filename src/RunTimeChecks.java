public class RunTimeChecks {

    static String hereAt(int levelUpInTheStack) {
        StackTraceElement ste = Thread.currentThread().getStackTrace()[levelUpInTheStack];
        return ste.toString();
    }

    public static void checkNull(Object toCheck,String message) {
        int levelUpInTheStack = 3;
        if (toCheck == null) {
            throw new NullPointerException(hereAt(levelUpInTheStack) + " error: " + message);
        }
    }
}
