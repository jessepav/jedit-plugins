package com.illcode.jedit.inputreplace;

import org.gjt.sp.jedit.AbstractOptionPane;

public class InputReplaceOptionPane extends AbstractOptionPane
{
    private OptionPanel optionPanel;

    public InputReplaceOptionPane(String internalName) {
        super(InputReplacePlugin.NAME);
    }

    protected void _init() {
        optionPanel = new OptionPanel();
        addComponent(optionPanel);
    }

    protected void _save() {
    }
}
