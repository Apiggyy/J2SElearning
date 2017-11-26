package com.self.learning.gof.bridge;

public class IBMComputer extends AbstractComputer {

    public IBMComputer(CpuAbility cpuAbility) {
        super(cpuAbility);
    }

    @Override
    public void checkCpuAbility() {
        System.out.println("IBM笔记本" + super.getCpuAbility().ability());
    }
}
