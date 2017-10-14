package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class JokesContainer {

    private ArrayList<String> mJokes;

    public JokesContainer() {
        mJokes = new ArrayList<String>(Arrays.asList("My friend thinks he is smart. He told me an onion is the only food that makes you cry, so I threw a coconut at his face. "));
        mJokes.add("What happens to a frog's car when it breaks down?It gets toad away. ");
        mJokes.add("A teacher asked her students to use the word 'beans' in a sentence. 'My father grows beans,' said one girl. 'My mother cooks beans,' said a boy. A third student spoke up, 'We are all human beans.'");

        mJokes.add("The last time we changed from daylight saving time, a preacher friend posted," + "\n" +
                "\"For those who habitually show up 15 minutes late to church," + "\n" +
                "allow me to remind you that tonight is the night you set your clock back 45 minutes.\"");
        mJokes.add("Q: Why was six scared of seven?
A: Because seven 'ate' nine.");
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
