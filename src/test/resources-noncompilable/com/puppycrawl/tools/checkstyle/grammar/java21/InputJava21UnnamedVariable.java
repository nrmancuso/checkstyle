//non-compiled with javac: Compilable with Java21
package com.puppycrawl.tools.checkstyle.grammar.java21;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.Queue;

public class InputJava21UnnamedVariable {
    sealed abstract class Ball permits RedBall, BlueBall, GreenBall {
    }

    final class RedBall extends Ball {
    }

    final class BlueBall extends Ball {
    }

    final class GreenBall extends Ball {
    }

    static int count(Iterable<String> orders) {
        int total = 0;
        for (String _ : orders) total++;
        return total;
    }

    static void m1() {
        for (int i = 0, _ = 2; i < 10; i++) {
            System.out.println(i);
        }
    }

    static void m2() {
        Queue<Integer> q = new LinkedList<>();
        while (q.size() >= 3) {
            var x = q.remove();
            var _ = q.remove();
            var _ = q.remove();
        }
    }

    static void m3(String s) {
        try {
            int i = Integer.parseInt(s);
        } catch (NumberFormatException _) {
        } catch (IllegalArgumentException _) {
        }
    }

    static void m4(String path) {
        try (var _ = new FileReader(path, StandardCharsets.UTF_8)) {
        } catch (IOException _) {
        }
    }

    static int m5(Ball ball) {
        return switch (ball) {
            case RedBall _ -> 1;
            case BlueBall _ -> 2;
            case GreenBall _ -> 3;
        };
    }

    record R(Object o) {}
    record S(Object o1, Object o2) {}
    void m6(R r1) {
        switch (r1) {
            case R(var _) -> {}
        }

        R r = new R(null);
        if (r instanceof R _) {}
        if (r instanceof R(_)) {}
        if (r instanceof R(String _)) {}

        S s = new S(null, null);
        if (s instanceof S _) {}
        if (s instanceof S(_, _)) {}
    }

    void m7(Object o) {
        if (o instanceof String _) {}
    }
}
