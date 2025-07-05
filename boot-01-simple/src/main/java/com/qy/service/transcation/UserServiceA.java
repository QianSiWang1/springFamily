package com.qy.service.transcation;

public interface UserServiceA {

    void updateUserNameAWithOutTransaction();

    void updateUserNameAWithTransaction();

    void updateUserNameBinAWithOutTransaction();

    void updateUserNameBinAWithTransaction();

    void asyncBAndAException();

    void asyncBExceptionAndAException();

    void asyncBTransactionAndAException();

    void asyncBTransactionExceptionAndA();

    void asyncBTransactionExceptionAndAException();

    void asyncBAndBInvokeMethodC();
}
