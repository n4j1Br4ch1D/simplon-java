package com.shos.shos.utils;

import lombok.AllArgsConstructor;
import org.apache.commons.lang3.EnumUtils;
import java.beans.PropertyEditorSupport;

@AllArgsConstructor
public class EnumConverter extends PropertyEditorSupport {
    private Class type;

    public void setAsText(String text) {
        setValue(EnumUtils.getEnum(type, text.toUpperCase()));
    }
}