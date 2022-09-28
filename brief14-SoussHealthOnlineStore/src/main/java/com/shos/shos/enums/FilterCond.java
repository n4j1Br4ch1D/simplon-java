package com.shos.shos.enums;

public enum FilterCond {
    AND,
    OR;
	
    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
