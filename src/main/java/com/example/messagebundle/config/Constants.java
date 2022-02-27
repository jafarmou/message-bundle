package com.example.messagebundle.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Application constants.
 */
public final class Constants {

    //Regex for acceptable logins
    public static final String LOGIN_REGEX = "^[_'.@A-Za-z0-9-]*$";

    public static final String SYSTEM_ACCOUNT = "system";
    public static final String OWNER = "مالک";

    private Constants() {
    }

    private static final List<Locale> LOCALES = Arrays.asList(
            new Locale("en"),
            new Locale("fa"),
            new Locale("fr"));

    public static List<Locale> getLocales() {
        return new ArrayList<>(LOCALES);
    }

}
