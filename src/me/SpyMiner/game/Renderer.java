package me.SpyMiner.game;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;


public class Renderer {

    public Renderer() {        
    }

    public void init() throws Exception { 
        ShaderProgram shaderProgram = new ShaderProgram();
        shaderProgram.createVertexShader(Utils.loadResource("/assets/shader/vertex.vs"));
        shaderProgram.createFragmentShader(Utils.loadResource("/assets/shader/fragment.fs"));
        shaderProgram.link();
    }

    public void clear() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }
}