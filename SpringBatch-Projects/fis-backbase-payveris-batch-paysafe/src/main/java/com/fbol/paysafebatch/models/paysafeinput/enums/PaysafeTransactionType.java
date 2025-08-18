package com.fbol.paysafebatch.models.paysafeinput.enums;

import java.util.HashMap;
import java.util.Map;

public enum PaysafeTransactionType {
    ON_US("ON US"),
    BP_PIN("BP PIN"),
    RETURN_BILL_PAY("RETURN BILL PAY"),
    EXT_TRANSFER("EXT TRANSFER"),
    RETURN_TRANSFER("RETURN TRANSFER"),
    PIN("PIN"),
    RETURN_PIN("RETURN PIN");

    public final String label;

    private PaysafeTransactionType(String label) {
        this.label = label;
    }

    private static final Map<String, PaysafeTransactionType> BY_LABEL = new HashMap<>();
    static {
        for (PaysafeTransactionType code: values()) {
            BY_LABEL.put(code.label, code);
        }
    }
    public static PaysafeTransactionType valueOfLabel(String label){
        return BY_LABEL.get(label);
    }

    @Override
    public String toString() {
        return this.label;
    }
}
