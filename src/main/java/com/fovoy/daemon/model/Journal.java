package com.fovoy.daemon.model;

import com.fovoy.daemon.model.Type.AccountType;
import com.fovoy.daemon.model.Type.JournalType;
import sun.dc.pr.PRError;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by zxz.zhang on 16/8/9.
 */
public class Journal {
    private long id;
    private String transactionId;
    private BigDecimal amount;
    private Timestamp updateTime;
    private Timestamp createTime;
    private AccountType journalType;
    private JournalType accountType;

    public Journal(BigDecimal amount, Timestamp updateTime, Timestamp createTime, AccountType journalType, JournalType accountType) {
        this.amount = amount;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.journalType = journalType;
        this.accountType = accountType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public AccountType getJournalType() {
        return journalType;
    }

    public void setJournalType(AccountType journalType) {
        this.journalType = journalType;
    }

    public JournalType getAccountType() {
        return accountType;
    }

    public void setAccountType(JournalType accountType) {
        this.accountType = accountType;
    }
}
