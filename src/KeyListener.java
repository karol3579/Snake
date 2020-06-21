
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    private Handler handler;

    public KeyListener(Handler handler) {
        this.handler=handler;

    }

    public void keyPressed(KeyEvent e){
        int key=e.getKeyCode();

        for(int i=0;i<handler.object.size();i++)
        {
                //key event for player 1
                if(key == KeyEvent.VK_W) {
                    Snake.up=true;
                    Snake.down=false;
                    Snake.left=false;
                    Snake.right=false;
                }
                if(key == KeyEvent.VK_S) {
                    Snake.up=false;
                    Snake.down=true;
                    Snake.left=false;
                    Snake.right=false;
                }
                if(key == KeyEvent.VK_A) {
                    Snake.up=false;
                    Snake.down=false;
                    Snake.left=true;
                    Snake.right=false;
                }
                if(key == KeyEvent.VK_D) {
                    Snake.up=false;
                    Snake.down=false;
                    Snake.left=false;
                    Snake.right=true;
                }
        }
    }
}
