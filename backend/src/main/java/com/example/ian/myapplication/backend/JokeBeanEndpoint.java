package com.example.ian.myapplication.backend;

import com.example.JokesContainer;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.logging.Logger;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokeBeanApi",
        version = "v2",
        resource = "jokeBean",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.ian.example.com",
                ownerName = "backend.myapplication.ian.example.com",
                packagePath = ""
        )
)
public class JokeBeanEndpoint {

    private static final Logger logger = Logger.getLogger(JokeBeanEndpoint.class.getName());

    /**
     * This method gets the <code>JokeBean</code> object associated with the specified <code>id</code>.
     *
     * @param id The id of the object to be returned.
     * @return The <code>JokeBean</code> associated with <code>id</code>.
     */
    @ApiMethod(name = "getJoke")
    public JokeBean getJoke(@Named("id") int id) {
        // TODO: Should return a simple jokeBean
        logger.info("Calling getJoke method");
        //JokeBean jokeBean = getJokeBean();
        return getJokeBean();
    }

    /**
     * This inserts a new <code>JokeBean</code> object.
     *
     * @param jokeBean The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "insertJokeBean")
    public JokeBean insertJokeBean(JokeBean jokeBean) {
        // TODO: Implement this function
        logger.info("Calling insertJokeBean method");
        return jokeBean;
    }

    private JokeBean getJokeBean() {
        String joke;
        JokeBean jokeBean = new JokeBean();
        JokesContainer jokesContainer = new JokesContainer();
        joke = jokesContainer.getJoke();
        jokeBean.setJoke(joke);

        return jokeBean;
    }
}