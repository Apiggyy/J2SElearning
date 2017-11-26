package com.self.learning.gof.bridge;

public class LenovoComputer extends AbstractComputer {

    public LenovoComputer(CpuAbility cpuAbility) {
        super(cpuAbility);
    }

    @Override
    public void checkCpuAbility() {
        System.out.println("联想笔记本" + super.getCpuAbility().ability());
    }
}
