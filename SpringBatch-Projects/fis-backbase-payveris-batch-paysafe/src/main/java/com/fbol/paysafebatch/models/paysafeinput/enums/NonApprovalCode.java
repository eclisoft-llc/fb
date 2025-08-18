package com.fbol.paysafebatch.models.paysafeinput.enums;

import java.util.HashMap;
import java.util.Map;

public enum NonApprovalCode {
    InsufficientFunds("01"),
    AccountClosed("02"),
    InvalidAccount("03"),
    UncollectedFunds("04"),
    CouldNotPost("05"); // default catch all error.

    public final String label;

    private NonApprovalCode(String label) {
        this.label = label;
    }

    private static final Map<String, NonApprovalCode> BY_LABEL = new HashMap<>();
    static {
        for (NonApprovalCode code: values()) {
            BY_LABEL.put(code.label, code);
        }
    }
    public static NonApprovalCode valueOfLabel(String label){
        return BY_LABEL.get(label);
    }

    @Override
    public String toString() {
        return this.label;
    }
}
