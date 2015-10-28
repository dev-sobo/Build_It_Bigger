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

    }

    public JokeBean getJokeBean() {
        JokeBean jokeBean = new JokeBean();
        Random RNG = new Random();

        int randomChooser = RNG.nextInt(mJokes.size() + 1);
        jokeBean.setJoke(mJokes.get(randomChooser));

        return  jokeBean;
    }

}
