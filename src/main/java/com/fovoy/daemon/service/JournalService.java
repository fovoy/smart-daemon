package com.fovoy.daemon.service;

import com.fovoy.daemon.model.Journal;

/**
 * Created by zxz.zhang on 16/8/9.
 */
public interface JournalService {

    void save(Journal journal);

    void remove(Journal journal);
}
