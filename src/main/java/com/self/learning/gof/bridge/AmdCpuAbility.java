package com.self.learning.gof.bridge;

public class AmdCpuAbility implements CpuAbility {
    @Override
    public String ability() {
        return "CPU性能一般";
    }
}
