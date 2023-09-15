package com.activemesa.behavioral.nullobject;

interface Log {
    void info(String msg);

    void warn(String msg);
}

class ConsoleLog implements Log {

    @Override
    public void info(String msg) {
        System.out.println(msg);
    }

    @Override
    public void warn(String msg) {
        System.out.println("WARNING: " + msg);
    }
}

class BankAccount {
    private Log log;
    private int balance;

    public BankAccount(Log log) {
        this.log = log;
    }

    public void deposit(int amount) {
        balance += amount;

        if (log != null)
            log.info("Deposited " + amount);
    }
}

final class NullLog implements Log {

    @Override
    public void info(String msg) {

    }

    @Override
    public void warn(String msg) {

    }
}

class NullObjectDemo {
    public static void main(String[] args) {
        Log log = new NullLog();
        BankAccount account = new BankAccount(log);

        account.deposit(100);
    }
}
