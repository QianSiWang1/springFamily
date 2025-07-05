package com.qy.transaction;

import com.qy.service.transcation.UserServiceA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootTest
@EnableAsync
public class TransactionTest {
    @Autowired
    UserServiceA userServiceA;

    @Test
    public void transactionTest1(){
        userServiceA.updateUserNameAWithOutTransaction();
    }

    @Test
    public void transactionTest2(){
        userServiceA.updateUserNameAWithOutTransaction();
    }

    @Test
    public void transactionTest3(){
        userServiceA.updateUserNameBinAWithOutTransaction();
    }

    @Test
    public void transactionTest4(){
        userServiceA.updateUserNameBinAWithTransaction();
    }

    @Test
    public void transactionTest5(){
        userServiceA.asyncBAndAException();
    }

    @Test
    public void transactionTest6(){
        userServiceA.asyncBExceptionAndAException();
    }

    @Test
    public void transactionTest7(){
        userServiceA.asyncBTransactionExceptionAndA();
    }

    @Test
    public void transactionTest8() throws InterruptedException {
        userServiceA.asyncBAndBInvokeMethodC();
        Thread.sleep(5000);
    }
}
