package com.aut.alij.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.aut.alij.FlappyBirds;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(FlappyBirds.WIDTH, FlappyBirds.HEIGHT);
        }

        @Override
        public ApplicationListener createApplicationListener () {
                return new FlappyBirds();
        }
}