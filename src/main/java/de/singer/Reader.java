package de.singer;

import java.util.ArrayList;
import java.util.List;

public class Reader {
    public List<String> read(List<String> lines) {
        List<String> result = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        for (String line : lines) {
            if (line.isEmpty()) {
                if (!tmp.isEmpty()) {
                    result.add(String.join(" ", tmp));
                    tmp = new ArrayList<>();
                }
            } else {
                tmp.add(line);
            }
        }
        result.add(String.join(" ", tmp));
        return result;
    }
}
