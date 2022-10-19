package me.SpyMiner.game;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glViewport;
import org.lwjgl.*;
import org.lwjgl.BufferUtils.*;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.MemoryUtil.*;
import java.nio.FloatBuffer;
import org.lwjgl.system.MemoryStack;
import java.nio.IntBuffer;
import javax.vecmath.*;
import me.SpyMiner.engine.IGameLogic;
import me.SpyMiner.engine.Window;
import me.SpyMiner.game.ShaderProgram;
import java.nio.FloatBuffer;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;
import org.lwjgl.system.MemoryUtil;

public class DummyGame implements IGameLogic {

    private int direction = 0;

    private float color = 0.0f;

    private final Renderer renderer;
    private final ShaderProgram shaderProgram;

    private Vector3f colour;
    public Mesh mesh;

    float[] vertices = new float[]{
            0.0f,  0.5f, 0.0f,
            -0.5f, -0.5f, 0.0f,
            0.5f, -0.5f, 0.0f
        };

    public DummyGame() throws Exception{
        renderer = new Renderer();
        shaderProgram = new ShaderProgram();
    }

    @Override
    public void init() throws Exception {
        cleanup();
        renderer.init();
        float[] positions = new float[]{
                -0.5f,  0.5f, 0.0f,
                -0.5f, -0.5f, 0.0f,
                0.5f, -0.5f, 0.0f,
                0.5f,  0.5f, 0.0f,
            };
        int[] indices = new int[]{
                0, 1, 3, 3, 1, 2,
            };
        mesh = new Mesh(positions, indices);
    }

    @Override
    public void input(Window window) {
        if ( window.isKeyPressed(GLFW_KEY_UP) ) {
            direction = 1;
        } else if ( window.isKeyPressed(GLFW_KEY_DOWN) ) {
            direction = -1;
        } else {
            direction = 0;
        }
    }

    @Override
    public void update(float interval) {
        color += direction * 0.01f;
        if (color > 1) {
            color = 1.0f;
        } else if ( color < 0 ) {
            color = 0.0f;
        }
    }

    @Override
    public void render(Window window, Mesh mesh) {
        renderer.clear();

        if ( window.isResized() ) {
            glViewport(0, 0, window.getWidth(), window.getHeight());
            window.setResized(false);
        }

        shaderProgram.bind();

        glBindVertexArray(mesh.getVaoID());
        glEnableVertexAttribArray(0);

        glDrawElements(GL_TRIANGLES, mesh.getVertexCount(), GL_UNSIGNED_INT, 0);

        glDisableVertexAttribArray(0);
        glBindVertexArray(0);

        shaderProgram.unbind();
    }

    public void cleanup() {
        if (shaderProgram != null) {
            shaderProgram.cleanup();
        }
        mesh.cleanUp();
    }

}
