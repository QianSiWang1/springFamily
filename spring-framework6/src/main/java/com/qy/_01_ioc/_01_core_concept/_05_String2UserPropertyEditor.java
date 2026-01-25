package com.qy._01_ioc._01_core_concept;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

/**
 * @Author qy
 * @Date 2026/1/17
 */
public class _05_String2UserPropertyEditor extends PropertyEditorSupport implements PropertyEditor {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        ConvertUser user= new ConvertUser();
        user.setName(text);
        this.setValue(user);
    }
}