package learning.java.nine.jokeserver;

import java.util.logging.*;
import java.util.List;
import learning.java.nine.jokeserver.internal.Filter;
/**
 * Created by Frank J. Mitropoulos.
 */

public interface JokeServer {
    public int availableJokes();
    public String getJoke();
    public String name();
}

