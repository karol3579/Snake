import java.awt.*;

public class Tail extends GameObject{

    private int index;
    Handler handler;
    public Tail(int x, int y, ID id, int width, int height,int index,Handler handler) {
        super(x, y, id, width, height);
        this.index=index;
        this.handler=handler;
    }


    @Override
    public void tick() {

            x=Snake.currentSnakeX[Snake.z-index];
            y=Snake.currentSnakeY[Snake.z-index];

    }


    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x,y,width,height);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,width,height);
    }
}
