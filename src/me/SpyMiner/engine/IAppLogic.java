package me.spyminer.engine;

import me.spyminer.engine.graph.Render;
import me.spyminer.engine.scene.Scene;

public interface IAppLogic {

    void cleanup();

    void init(Window window, Scene scene, Render render);

    void input(Window window, Scene scene, long diffTimeMillis);

    void update(Window window, Scene scene, long diffTimeMillis);
}