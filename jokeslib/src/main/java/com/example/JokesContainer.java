package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class JokesContainer {

    private ArrayList<String> mJokes;

    public JokesContainer() {
        mJokes = new ArrayList<String>(Arrays.asList("test", "joke"));
        mJokes.add("An older man walks into a bar wearing a stovepipe hat, a waistcoat and a phony beard. He sits down at a bar and orders a drink. As the bartender sets it down, he asks, \"Going to a party?\"\n" +
                "\n" +
                "\"Yeah, a costume party,\" the man answers, \"I'm supposed to come dressed as my love life.\"\n" +
                "\n" +
                "\"But you look like Abe Lincoln,\" protests the bartender.\n" +
                "\n" +
                "\"That's right. My last four scores were seven years ago.\"");
        mJokes.add("Wife wakes up in the middle of the night and sees her husband not in bed next to her. " +
                "She goes downstairs to look for him and sobbing over a cup of coffee\n" +
                "The wife asks him \"What's wrong?\"" + "\n"
                + "The husband replies \"Remember when we were teenagers and your father caught us having sex in the car?\n" +
                "\"Then he put a shotgun in my face and if I didn't marry you i would spend the next 20 years of my life in prison.\"" + "\n"
                + "The wife says \"Oh, of course I do\"" +
                "\n" + "\n" + "\"Well, I would've gotten out today.\"");

        mJokes.add("The last time we changed from daylight saving time, a preacher friend posted," + "\n" +
                "\"For those who habitually show up 15 minutes late to church," + "\n" +
                "allow me to remind you that tonight is the night you set your clock back 45 minutes.\"");
    }
        // TODO: Get simply a joke String from this method, and create the JokeBean in an Endpoint method
    public String getJoke() {
       // JokeBean jokeBean = new JokeBean();
        Random RNG = new Random();

        int randomChooser = RNG.nextInt(mJokes.size());
       // jokeBean.setJoke(mJokes.get(randomChooser));

       //return jokeBean;
        return mJokes.get(randomChooser);
    }

}
