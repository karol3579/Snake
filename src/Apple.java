import java.awt.*;

public class Apple extends GameObject{

    Handler handler;

    public Apple(int x, int y, ID id, int width, int height,Handler handler) {
        super(x, y, id, width, height);
        this.handler=handler;

    }


    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x,y,width,height);
    }

    @Override
    public Rectangle getBounds() { return new Rectangle(x,y,width,height);
    }
}
