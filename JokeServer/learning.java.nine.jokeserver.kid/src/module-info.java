module learning.java.nine.jokeserver.kid {
    requires learning.java.nine.jokeserver;
    //exports learning.java.nine.jokeserver.kid;

    provides learning.java.nine.jokeserver.JokeServer
            with learning.java.nine.jokeserver.kid.KidJokeServer;
}