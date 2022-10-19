package me.SpyMiner.engine;

import me.SpyMiner.game.*;

public interface IGameLogic
{
    void init() throws Exception; 

    void input(Window window);

    void update(float interval);

    void render(Window window, Mesh mesh);
    
    void cleanup();
}