package com.learn.example.patterns;

import java.util.List;
import java.util.stream.Collectors;

public final class ImmutableObjectTest {              // class need to be final

    private String make;                        // Immutable fields no need to be final, private is enough
    private final List<Tyre> tyres;             // need to be final as Tyre is not immutable

    public ImmutableObjectTest(String make, List<Tyre> tyres) {
        this.make = make;                       // can directly assign as String is immutable
        List<Tyre> tyreList = tyres.stream().map(tyre -> new Tyre(tyre.getSize())).collect(Collectors.toList());    // Deep copy needed as Tyre class is not immutable
        this.tyres = tyreList;
    }

    // Should not provide any setters

    public String getMake() {
        return make;                            // Can return immutable type fields directly
    }

    public List<Tyre> getTyres() {              // Deep copy is needed for mutable type fields
        List<Tyre> tyreList = tyres.stream().map(tyre -> new Tyre(tyre.getSize())).collect(Collectors.toList());    // Deep copy needed as Tyre class is not immutable
        return tyreList;
    }
}

class Tyre {

    private int size;

    public Tyre(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
