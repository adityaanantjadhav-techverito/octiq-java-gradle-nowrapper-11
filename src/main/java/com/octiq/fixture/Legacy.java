package com.octiq.fixture;

import java.util.List;

public class Legacy {
    public String describe(List<String> items) {
        var joined = String.join(",", items);
        return joined.isBlank() ? "empty" : joined;
    }
}
