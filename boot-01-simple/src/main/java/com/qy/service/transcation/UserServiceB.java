package com.qy.service.transcation;

public interface UserServiceB {
    void updateUserNameB();

    void asyncWithoutTransactionNoException();

    void asyncWithoutTransactionException();

    void asyncWithTransactionNoException();

    void asyncWithTransactionException();

    void asyncInvokeMethodC();
}
