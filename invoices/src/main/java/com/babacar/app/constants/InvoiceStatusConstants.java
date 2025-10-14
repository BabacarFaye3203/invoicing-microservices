package com.babacar.app.constants;

import java.util.Set;

public class InvoiceStatusConstants {
    private InvoiceStatusConstants() {}
    public static final String DRAFT = "DRAFT";
    public static final String ALL = "ALL";
    public static final String APPROVED = "APPROVED";
    public static final String UNPAID = "UNPAID";
    public static final String OVERDUE = "OVERDUE";
    public static final String PAID = "PAID";
    public static final String CREDITED = "CREDITED";
    public static final String VALID_INVOICE_CREATION_STATUS = "DRAFT|APPROVED";
    public static final Set<String> FILTER_VALID_STATUS = Set.of(ALL,APPROVED, DRAFT, OVERDUE, UNPAID, PAID);
    public static final Set<String> VALID_INVOICE_STATUS_FOR_ALL = Set.of(ALL,APPROVED, DRAFT, OVERDUE, UNPAID, PAID);
    public static final Set<String> VALID_CUSTOMER_INVOICE_STATUS = Set.of(ALL, DRAFT, OVERDUE, UNPAID, PAID);
}
