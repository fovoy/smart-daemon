package com.fovoy.daemon.dao;

import com.fovoy.daemon.model.Journal;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by zxz.zhang on 16/8/9.
 */
@Repository
public interface JournalDao {


    /**
     * 保持资金流水
     */
    void save(@Param("journal") Journal journal);


    /**remove
     * 删除资金流水
     */
    void remove(@Param("journal") Journal journal);
}
