package de.singer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReaderTest {

    @Test
    public void read() {
        List<String> lines = new ArrayList<>();
        lines.add("(+ 23 52)");
        lines.add("");
        lines.add("(* 2.5 0.3)");
        Reader reader = new Reader();
        List<String> read = reader.read(lines);
        assertEquals(2, read.size());
    }

}