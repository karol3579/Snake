import java.awt.*;

public abstract class GameObject {
    protected int x,y,width,height;
    protected ID id;

    public GameObject(int x,int y,ID id,int width,int height){
        this.x=x;
        this.y=y;
        this.id=id;
        this.width=width;
        this.height=height;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    public ID getId() {
            return id;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
