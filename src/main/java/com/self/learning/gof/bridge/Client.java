package com.self.learning.gof.bridge;

public class Client {

    public static void main(String[] args) {
        CpuAbility ability = new IntelCpuAbility();
        AbstractComputer computer = new IBMComputer(ability);
        computer.checkCpuAbility();

        CpuAbility ability1 = new AmdCpuAbility();
        AbstractComputer computer1 = new LenovoComputer(ability1);
        computer1.checkCpuAbility();
    }
}
