package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class JokesContainer {

    private ArrayList<String> mJokes;

    public JokesContainer() {
        mJokes = new ArrayList<String>(Arrays.asList("Why did the pirate skip the R rated movie? It had too much booty"));
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
        mJokes.add("DEA officer stops at a ranch in Texas, and talks with an old rancher.." +
                " He tells the rancher, \"I need to inspect your ranch for ill*gally grown dr*gs.\"" +
                " The rancher says, \"Okay , but do not go in that field over there,\" as he points out the location." +
                " The DEA officer verbally explodes saying, \"Mister, I have the authority of the Federal Government with me.\"" +
                " Reaching into his rear pants pocket, he removes his badge and proudly displays it to the rancher." +
                " \"See this badge? This badge means I am allowed to go wherever I wish.... On any land.. No questions asked or answers given." +
                " Have I made myself clear? Do you understand? \" The rancher nods politely, apologizes, and goes about his chores." +
                " A short time later, the old rancher hears loud screams and sees the DEA officer running for his life chased by the rancher's big Santa Gertrudis Bull..." +
                " With every step the bull is gaining ground on the officer, and it seems likely that he'll get gored before he reaches safety." +
                " The officer is clearly terrified. The rancher throws down his tools, runs to the fence and yells at the top of his lungs... \"Your badge... Show him your badge!\"");
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
