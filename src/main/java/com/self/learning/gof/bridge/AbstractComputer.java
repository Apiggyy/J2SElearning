package com.self.learning.gof.bridge;

public abstract class AbstractComputer {

    private CpuAbility cpuAbility;

    public AbstractComputer(CpuAbility cpuAbility) {
        this.cpuAbility = cpuAbility;
    }

    public CpuAbility getCpuAbility() {
        return cpuAbility;
    }

    public void setCpuAbility(CpuAbility cpuAbility) {
        this.cpuAbility = cpuAbility;
    }

    public abstract void checkCpuAbility();

}
