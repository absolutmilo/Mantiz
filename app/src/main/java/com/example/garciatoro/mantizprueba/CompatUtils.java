package com.example.garciatoro.mantizprueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;

import java.util.Locale;



public final class CompatUtils {

    private CompatUtils() {
        // Prevent instantiation
    }

    /**
     * Retrieves the primary locale from the specified {@link Configuration}.
     *
     * @param configuration The current {@link Configuration}.
     * @return The primary locale.
     */
    public static Locale getPrimaryLocale(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            final LocaleList locales = configuration.getLocales();
            if (locales.size() > 0) {
                return locales.get(0);
            }
        }
        //noinspection deprecation
        return configuration.locale;
    }
}


