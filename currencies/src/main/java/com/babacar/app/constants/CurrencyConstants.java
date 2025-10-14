package com.babacar.app.constants;

import java.util.Set;

public class CurrencyConstants {
    CurrencyConstants(){};

    public static  final String FCFA="FCFA";
    public static final String EUR="EUR";
    public static final String USA="USA";
    public static final String VALID_CURRENCY="FCFA|USA|EUR";
    public static final Set<String> VALID_CURRENCY_FOR_ALL=Set.of(FCFA,USA,EUR);
}
