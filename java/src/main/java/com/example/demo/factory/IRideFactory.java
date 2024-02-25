package com.example.demo.factory;

import com.example.demo.strategy.IRideSelectionStrategy;

public interface IRideFactory {
    public IRideSelectionStrategy createSelectionStrategy(String selectionStrategy);
}
