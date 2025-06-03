package mindustry.logic;

import java.io.*;
import java.util.*;

final class VarWriter {
    public static void write(LVar[] vars, String path) {
        write(Arrays.asList(vars), path);
    }

    public static void write(Iterable<LVar> vars, String path) {
        try (Formatter f = new Formatter(new BufferedOutputStream(new FileOutputStream(new File(path))))) {
            for (LVar var : vars) {
                f.format("%s%n", var.name);
            }
        }
        catch (Throwable e) {
            throw new RuntimeException("Could not write variables!", e);
        }
    }
}
