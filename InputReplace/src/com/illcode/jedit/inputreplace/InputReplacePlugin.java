package com.illcode.jedit.inputreplace;

import org.gjt.sp.jedit.EditPlugin;
import org.gjt.sp.jedit.bsh.Interpreter;
import org.gjt.sp.jedit.jEdit;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public final class InputReplacePlugin extends EditPlugin
{
    public static final String NAME = "inputreplace";

    static int maxLength = 3;

    private static Interpreter intr;
    private static Path functionsPath, tablePath;

    public static void inputReplace() {

    }

    public static void reloadResources() {
        intr = new Interpreter();
    }

    public static void editTable() {
        jEdit.openFile(jEdit.getActiveView(), tablePath.toString());
    }

    public static void editUserFunctions() {
        jEdit.openFile(jEdit.getActiveView(), functionsPath.toString());
    }

    public void start() {
        ensureResourcesPresent();
        reloadResources();
    }

    private void ensureResourcesPresent() {
        Path pluginHome = getPluginHome().toPath();
        functionsPath = pluginHome.resolve("input-replace-functions.bsh");
        tablePath = pluginHome.resolve("input-replace-table.txt");
        try {
            if (!Files.exists(functionsPath)) {
                String defaultFunctions = Utils.getStringResource("/resources/input-replace-functions-default.bsh");
                Files.write(functionsPath, defaultFunctions.getBytes(StandardCharsets.UTF_8));
            }
            if (!Files.exists(tablePath)) {
                String defaultTable = Utils.getStringResource("/resources/input-replace-table-default.txt");
                Files.write(tablePath, defaultTable.getBytes(StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
