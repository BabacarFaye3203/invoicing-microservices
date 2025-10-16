package com.babacar.app.constants;

import java.util.Set;

public class ProductCategoryConstants {
    ProductCategoryConstants(){};
    public static final String BEAUTY = "BEAUTY";
    public static final String MULTIMEDIA="MULTIMEDIA";
    public static final String VESTIMENTAIRE = "VESTIMENTAIRE";
    public static final String ALIMENTAIRE = "ALIMENTAIRE";
    public static final String SPORT = "SPORT";
    public static final String VALID_PRODUCT_CATEGORIES = "MULTIMEDIA|BEAUTY|VESTIMENTAIRE|ALIMENTAIRE|SPORT";
    public static final Set<String> VALID_ALL_CATEGORIES=Set.of(BEAUTY,VESTIMENTAIRE,ALIMENTAIRE,SPORT);


}
