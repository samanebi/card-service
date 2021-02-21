package com.cardservice.demo.enums;

import java.util.HashMap;
import java.util.Map;

public enum CardOperation {

    ADD(1),
    LIST(2),
    DELETE(3);


    private static final Map<Integer, CardOperation> BY_STATE = new HashMap<>();

    static {
        for (CardOperation e: values()) {
            BY_STATE.put(e.state, e);
        }
    }


    private Integer state;
    CardOperation(int state) {
        this.state = state;
    }


    public static CardOperation valueOfLabel(String label) {
        return BY_STATE.get(label);
    }
}
