package com.activemesa.behavioral.command;

import dev.mccue.guava.collect.Lists;

import java.util.Collections;
import java.util.List;

class BankAccount {
    private int balance;
    private int overdraftLimit = -500;

    public void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited " + amount + ", balance is now " + balance);
    }

    public boolean withdraw(int amount) {
        if (balance - amount >= overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrew " + amount
            + ", balance is now " + balance);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                '}';
    }
}

interface Command {
    void call();
    void undo();
}

class BankAccountCommand implements Command {
    private BankAccount account;
    private boolean succeeded;

    @Override
    public void call() {
        switch (action) {
            case DEPOSIT:
                succeeded = true;
                account.deposit(amount);
                break;
            case WITHDRAW:
                succeeded = account.withdraw(amount);
                break;
        }
    }

    @Override
    public void undo() {
        if (!succeeded) {
            return;
        } else {
            switch (action) {
                case DEPOSIT:
                    account.withdraw(amount);
                    break;
                case WITHDRAW:
                    account.deposit(amount);
                    break;
            }
        }
    }

    public enum Action {
        DEPOSIT, WITHDRAW
    }

    private Action action;
    private int amount;

    public BankAccountCommand(BankAccount account, Action action, int amount) {
        this.account = account;
        this.action = action;
        this.amount = amount;
    }
}

class CommandDemo {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        System.out.println(ba);

        List<BankAccountCommand> commands = List.of(
                new BankAccountCommand(ba, BankAccountCommand.Action.DEPOSIT, 100),
                new BankAccountCommand(ba, BankAccountCommand.Action.WITHDRAW, 1000)
        );

        for (BankAccountCommand c : commands) {
            c.call();
            System.out.println(ba);
        }

        for (Command c : Lists.reverse(commands)) {
            c.undo();
            System.out.println(ba);
        }
    }
}