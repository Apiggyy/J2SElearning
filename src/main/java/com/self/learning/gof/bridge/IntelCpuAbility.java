package com.self.learning.gof.bridge;

public class IntelCpuAbility implements CpuAbility {
    @Override
    public String ability() {
        return "CPU性能强劲";
    }
}
