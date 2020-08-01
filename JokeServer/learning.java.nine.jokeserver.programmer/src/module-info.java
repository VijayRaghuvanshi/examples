module learning.java.nine.jokeserver.programmer {
    requires learning.java.nine.jokeserver;
    requires java.sql;
  //  exports learning.java.nine.jokeserver.programmer;

    provides learning.java.nine.jokeserver.JokeServer
            with learning.java.nine.jokeserver.programmer.ProgrammerJokeServer;
}