import java.util.Random;

public class SnakeEvents {
    public static int applecount=2;
    public static int taillenght=2;
    private int collected=0;
    private Random random = new Random();



    public  void spawnTail(int[] currentSnakeX,int[] currentSnakeY,int z,int width,int height,Handler handler){
        if(applecount>taillenght){
            handler.addObject(new Tail(currentSnakeX[z-2],currentSnakeY[z-2],ID.Tail,width,height,taillenght,handler));
            taillenght++;
        }
    }

    public  void wallCollsion(int x, int y){
        if(x>=Main.windowWidth-32 ||y>=Main.windowHeight-64 || x<0 || y<0){

            System.exit(-1);
        }
    }
    public void speedUp(int collected){
        collected++;
        if(collected==4){
            Main.delay--;
            collected=0;
        }
    }

    public void collision(Snake snake,Handler handler,int width,int height){
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId()==ID.Apple){
                if (snake.getBounds().intersects(tempObject.getBounds())) {

                    handler.removeObject(tempObject);
                    applecount++;
                    handler.addObject(new Apple( (width*random.nextInt(14)), (height*random.nextInt(10)),ID.Apple,snake.width,snake.height,handler));
                    speedUp(collected);
                }

            }  if(tempObject.getId()==ID.Tail){
                if (snake.getBounds().intersects(tempObject.getBounds())) {

                    System.exit(-1);
                }
            }
        }
    }
}
