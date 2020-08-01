package learning.java.nine.jokeapp;

import learning.java.nine.jokeserver.JokeServer;
//import learning.java.nine.jokeserver.kid.KidJokeServer;
//import learning.java.nine.jokeserver.programmer.ProgrammerJokeServer;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ServiceLoader;


public class Main {

    public static void main(String[] args) {

        LinkedHashMap<String, JokeServer> servers = new LinkedHashMap<>();

//        servers.put("1",new KidJokeServer());
//        servers.put("2",new ProgrammerJokeServer());

        ServiceLoader<JokeServer> loader = ServiceLoader.load(JokeServer.class);
        int key = 1;
        for (JokeServer s:loader){
            servers.put(String.valueOf(key), s);
            key++;
        }
                
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        do {

            servers.forEach((k,v) -> System.out.printf("%s: %s\n", k, v.name()));

            System.out.print("(Q to quit) : ");
            choice = scanner.nextLine().trim().toUpperCase();

            if (servers.containsKey(choice)) {
                System.out.println(servers.get(choice).getJoke() + "\n");
            } else if (!choice.equals("Q")) {
                System.out.println("Sorry, try again. ");
            }

        } while (!choice.equals("Q"));

        System.out.println("Thanks! I hope you laughed!!");
    }
}