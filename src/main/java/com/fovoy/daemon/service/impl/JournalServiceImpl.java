package com.fovoy.daemon.service.impl;

import com.fovoy.daemon.dao.JournalDao;
import com.fovoy.daemon.model.Journal;
import com.fovoy.daemon.service.JournalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zxz.zhang on 16/8/9.
 */
@Service("journalService")
public class JournalServiceImpl implements JournalService {


    @Resource
    private JournalDao journalDao;


    @Override
    public void save(Journal journal) {
        journalDao.save(journal);
    }

    @Override
    public void remove(Journal journal) {
        journalDao.remove(journal);
    }
}
