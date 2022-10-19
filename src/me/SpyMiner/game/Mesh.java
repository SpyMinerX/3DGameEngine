package me.SpyMiner.game;

import java.nio.FloatBuffer;
import me.SpyMiner.engine.utils.Buffers;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;
import org.lwjgl.system.MemoryUtil;

public class Mesh {

    private int vaoID;
    private int vboID;
    private int indexID;
    private int vertexCount;

    public Mesh(float[] positions, int[] indices) {           
        vertexCount = indices.length;

        vaoID = glGenVertexArrays();
        glBindVertexArray(vaoID);

        vboID = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboID);
        glBufferData(GL_ARRAY_BUFFER, Buffers.createFloatBuffer(positions), GL_STATIC_DRAW);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);

        indexID = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, indexID);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Buffers.createIntBuffer(indices), GL_STATIC_DRAW);

        glBindVertexArray(0);
    }

    public int getVertexCount() {
        return vertexCount;
    }
    
    public int getVaoID()
    {
    return vaoID;
    }

    public void cleanUp() {
        glDisableVertexAttribArray(0);

        glBindBuffer(GL_ARRAY_BUFFER, 0);
        glDeleteBuffers(vboID);
        glDeleteBuffers(indexID);

        glBindVertexArray(0);
        glDeleteVertexArrays(vaoID);
    }
}