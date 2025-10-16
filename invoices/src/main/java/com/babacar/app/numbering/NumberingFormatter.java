package com.babacar.app.numbering;


import com.babacar.app.constants.NumberPrefixConstant;

import java.time.LocalDate;
import java.time.ZoneId;

public interface NumberingFormatter {
    static String getFormattedNumber(String lang, Integer number){
        int year = LocalDate.now(ZoneId.of("Africa/Casablanca")).getYear();
         return NumberPrefixConstant.INVOICE_PREFIX + year + "-" + number;
    }
}
