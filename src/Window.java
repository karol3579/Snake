import javax.swing.*;


public class Window extends JFrame {

    public Window(int width, int height, String title,Main main)  {

        JFrame frame = new JFrame(title);



        frame.setSize(width,height);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(main);

        frame.setVisible(true);

        main.start();
    }



}
