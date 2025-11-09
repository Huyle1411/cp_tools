package util;

import java.util.*;
import java.util.stream.*;

public class Debug {
    public static final boolean DEBUG = true; // set false before submission

    public static void debug(Object... args) {
        if (!DEBUG)
            return;

        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        int line = stack.length > 2 ? stack[2].getLineNumber() : -1;

        String prefix = "\033[1;35m" + line + ": [";
        String msg = Arrays.stream(args).map(Debug::toString).collect(Collectors.joining(" "));
        System.err.println(prefix + msg + "]\033[0m");
    }

    public static void debugArray(String name, Object arr) {
        if (!DEBUG)
            return;
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        int line = stack.length > 2 ? stack[2].getLineNumber() : -1;
        System.err.println("\033[1;35m" + line + ": [" + name + " = " + arrayToString(arr) + "]\033[0m");
    }

    private static String toString(Object o) {
        if (o == null)
            return "null";

        if (o.getClass().isArray())
            return arrayToString(o);
        if (o instanceof Collection<?> c)
            return c.stream().map(Debug::toString).collect(Collectors.joining(",", "{", "}"));
        if (o instanceof Map<?, ?> m)
            return m.entrySet().stream().map(e -> toString(e.getKey()) + "=" + toString(e.getValue())).collect(Collectors.joining(",", "{", "}"));
        if (o instanceof Map.Entry<?, ?> e)
            return toString(e.getKey()) + "=" + toString(e.getValue());
        if (o instanceof Object[] objs)
            return Arrays.stream(objs).map(Debug::toString).collect(Collectors.joining(",", "{", "}"));
        return o.toString();
    }

    private static String arrayToString(Object arr) {
        if (arr instanceof int[] a)
            return Arrays.toString(a);
        if (arr instanceof long[] a)
            return Arrays.toString(a);
        if (arr instanceof double[] a)
            return Arrays.toString(a);
        if (arr instanceof boolean[] a)
            return Arrays.toString(a);
        if (arr instanceof char[] a)
            return Arrays.toString(a);
        if (arr instanceof Object[] a)
            return Arrays.toString(a);
        return arr.toString();
    }
}
