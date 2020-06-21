import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Main extends Canvas implements Runnable {


    private boolean running = false;
    private Handler handler;
    private Thread thread;

    private final int objectWidht=32,objectHeight=32;
    public  final int amountOfWidthBlocks=windowWidth/objectWidht,amountOfheightBlocks=windowHeight/objectHeight; //amount of block creating the field
    public static final int windowWidth=32*16,windowHeight=32*12;

    private int timer;
    public static int delay=25;


    public Main() {
        handler = new Handler();

        this.addKeyListener(new KeyListener(handler));
        new Window(windowWidth-16,windowHeight-25,"snake",this);

        initGameObjects();

    }


    public synchronized void start() {
        thread=new Thread(this);
        thread.start();
        running=true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running=false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void run() {
        this.requestFocus();
        long LastTime=System.nanoTime();
        double amountOfTicks=60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta=0;
        long timer = System.currentTimeMillis();
        int frames=0;
        while(running) {
            long now = System.nanoTime();
            delta += (now-LastTime)/ns;
            LastTime=now;
            while(delta >=1 ) {
                tick();
                delta--;
            }
            if(running) {
                render();
                frames++;
            }

            if(System.currentTimeMillis()-timer>1000) {
                timer += 1000;
                System.out.println("FPS:" + frames);
                frames=0;
            }
        }
        stop();
    }

    private void tick(){
        timer++;
        if(timer==delay) {
            timer=0;
            handler.tick();
        }
    }
    private void render() {
        BufferStrategy bs=this.getBufferStrategy();
        if(bs==null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g=bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0,0,windowWidth,windowHeight);

        g.setColor(Color.blue);
        for(int i=1;i<amountOfWidthBlocks;i++) {
            g.drawLine(objectWidht*i, 0, objectWidht*i, windowHeight);
        }
        for(int i=1;i<amountOfheightBlocks;i++){
            g.drawLine(0,objectHeight*i,windowWidth,objectHeight*i);
        }
        handler.render(g);

        g.dispose();
        bs.show();
    }

    private void initGameObjects(){
        Random random= new Random();
        handler.addObject(new Snake(objectWidht*amountOfWidthBlocks/2,objectHeight*amountOfheightBlocks/2,ID.Snake,objectWidht,objectHeight,handler));
        handler.addObject(new Apple( (objectWidht*random.nextInt(amountOfWidthBlocks-1)), (objectHeight*random.nextInt(amountOfheightBlocks-2)),ID.Apple,objectWidht,objectHeight,handler));
    }


    public static void main(String[] args) {
        new Main();

    }
}


