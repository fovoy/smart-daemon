package com.fovoy.daemon.model.Type;

/**
 * Created by zxz.zhang on 16/8/9.
 */
public enum JournalType {
    OUT(0), IN(1);
    private int type;

    JournalType(int Type) {
        this.type = type;
    }
}
