package com.doerksen.utilities;

/**
 * A simple class to format messages in the style of log4j
 */
public class MessageFormatter {

    /**
     * Facade over the slf4j message formatter so strings can be prettified easily.
     *
     * e.g. MessageFormatter.format("Look at this {} string!", "cool");
     * e.g. MessageFormatter.format("Look {} {} {} {}!", "at", "this", "amazing", "string");
     * @param input
     * @param args
     * @return
     */
    public static String format(String input, Object... args) {
        return org.slf4j.helpers.MessageFormatter.arrayFormat(input, args).getMessage();
    }
}
