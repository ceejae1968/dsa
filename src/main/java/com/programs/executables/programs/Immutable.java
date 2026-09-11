package com.programs.executables.programs;


import java.util.Collections;
import java.util.List;

public final class Immutable {
    private final String name;

    public List<String> getAddress() {
        return Collections.unmodifiableList(address);
    }

    private final List<String> address;

    public Immutable(String name, List<String> address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }
}
