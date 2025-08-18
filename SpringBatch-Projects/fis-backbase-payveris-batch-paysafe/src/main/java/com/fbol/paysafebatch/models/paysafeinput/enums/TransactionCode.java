package com.fbol.paysafebatch.models.paysafeinput.enums;

import java.util.HashMap;
import java.util.Map;

public enum TransactionCode {
    CR("CR"),
    DB("DB"); // stands for credit and debit

    private final String label;

    private TransactionCode(String label){
        this.label = label;
    }

    private static final Map<String, TransactionCode> BY_LABEL = new HashMap<>();
    static {
        for (TransactionCode code: values()) {
            BY_LABEL.put(code.label, code);
        }
    }
    public static TransactionCode valueOfLabel(String label){
        return BY_LABEL.get(label);
    }

    @Override
    public String toString() {
        return this.label;
    }
}
