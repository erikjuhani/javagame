package com.a1502999.game;

import com.a1502999.game.entity.mob.Player;
import com.a1502999.game.graphics.Screen;
import com.a1502999.game.input.Keyboard;
import com.a1502999.game.level.Level;
import com.a1502999.game.level.RandomLevel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

// Game is subclass of canvas
// Canvas is a rentagle that you can modify
public class Game extends Canvas implements Runnable{
    private static final long serialVersionUID = 1L;

    public static int width = 300;
    public static int height = width / 16 * 9;
    public static int scale = 3;
    public static String title = "Game";

    // program process
    private Thread thread;
    private JFrame frame;
    private Keyboard key;
    private Level level;
    private Player player;
    private boolean running = false;

    private Screen screen;

    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    // Converting image object into an array of integers
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

    public Game() {
        Dimension size = new Dimension(width * scale, height * scale);

        // Canvas method setPreferredSize, because Game class extends Canvas
        // Preferred Canvas Size
        setPreferredSize(size);

        screen = new Screen(width, height);
        frame = new JFrame();
        key = new Keyboard();
        level = new RandomLevel(64, 64);
        player = new Player(key);

        addKeyListener(key);

    }

    // synchronized, because we want memory consistence
    // no overlaps on commands to thread;
    // this = Game Class
    public synchronized void start() {
        running = true;
        thread = new Thread(this, "Display");
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Game loop
    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        int frames = 0;
        int updates = 0;
        requestFocus();

        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                update();
                updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(updates + " ups, " + frames + " fps");
                frame.setTitle(title + "    |   " + updates + " ups, " + frames + " fps");
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    // Restricts to certain amount of frames
    // int x = 0, y = 0;

    public void update() {

        key.update();
        player.update();
       /* int movement = 0;
        if (key.shift) movement = 1;

        if (key.up) y = y - 1 -movement;
        if (key.down) y = y + 1 +movement;
        if (key.left) x = x - 1 -movement;
        if (key.right) x = x + 1 +movement;*/
    }

    // No restrictions, just render
    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        screen.clear();
        int xScroll = player.x - screen.width / 2;
        int yScroll = player.y - screen.height / 2;
        level.render(xScroll, yScroll, screen);
        player.render(screen);

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = screen.pixels[i];
        }

        // Creates a link between graphics and the buffer
        Graphics g = bs.getDrawGraphics();

        // Graphics that you want to display to buffer will go between this and dispose()

        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        // Dispose "used" graphics that you don't need anymore
        g.dispose();
        bs.show();
    }

    // Static means no relation to rest of the class
    public static void main(String[] args) {
        Game game = new Game();
        game.frame.setResizable(false);
        game.frame.setTitle(Game.title);

        // Add Game / Canvas class component to frame;
        game.frame.add(game);

        // Set the size;
        game.frame.pack();

        // Press close button, ends application, remove the process
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Center the window
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);

        game.start();
    }

}
