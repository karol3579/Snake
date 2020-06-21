import java.awt.*;
import java.util.Random;


public class Snake extends GameObject {
    Handler handler;

    //movement
    public static boolean right=false;
    public static boolean left=false;
    public static boolean up=true;
    public static boolean down=false;

    //snake location
    public static int[] currentSnakeX = new int[900];
    public static int[] currentSnakeY = new int[900];
    public static int z=2; //index of movement array

    Random random = new Random();
    SnakeEvents snakeEvents= new SnakeEvents();

    public Snake(int x, int y, ID id, int width, int height,Handler handler) {
        super(x, y, id, width, height);
        this.handler=handler;
    }

    @Override
    public void tick() {

            if (right == true) x = x + width;
            if (left == true) x = x - width;
            if (up == true) y = y - width;
            if (down == true) y = y + width;
            currentSnakeX[z]=x;
            currentSnakeY[z]=y;
            z++;

        snakeEvents.wallCollsion(x,y);
        snakeEvents.collision(this,handler,width,height);
        snakeEvents.spawnTail(currentSnakeX,currentSnakeY,z,width,height,handler);


    }
    @Override
    public void render(Graphics g){
        g.setColor(Color.green);
        g.fillRect(x,y,width,height);

    }

    @Override
    public Rectangle getBounds() { return new Rectangle(x,y,width,height); }

}
