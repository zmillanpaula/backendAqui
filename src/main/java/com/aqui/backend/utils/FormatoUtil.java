package com.aqui.backend.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatoUtil {

    public static String formatearPrecio(double precio) {
        NumberFormat formatoCl = NumberFormat.getInstance(new Locale("es", "CL"));
        formatoCl.setMinimumFractionDigits(0);
        formatoCl.setMaximumFractionDigits(0);
        return formatoCl.format(precio);
    }
    
}
