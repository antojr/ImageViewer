package application;

import control.Command;
import control.NextImageOperation;
import control.PrevImageOperation;
import javax.swing.JOptionPane;
import model.Image;
import view.persistence.FileImageLoader;
import view.swing.SwingFrame;
import view.ui.ImageDisplay;

public class SwingApp {

    public static void main(String[] args) {
        Image image = null;
        try {
            image = new FileImageLoader(args[0]).load();
        } catch (NullPointerException e){JOptionPane.showMessageDialog(null,"La direccion es incorrecta");}
        new SwingApp().start(image);
    }

    private void start(Image image) 
    {
        SwingFrame frame = new SwingFrame();
        frame.getDisplay().setImage(image);
        frame.register(createOperations(frame.getDisplay()));
        frame.start();       
    }

    private Command[] createOperations(final ImageDisplay display) {
        Command[] commands = new Command[2];
        commands[SwingFrame.NEXT] = new NextImageOperation(display);
        commands[SwingFrame.PREV] = new PrevImageOperation(display);
        return commands;
    }
    
}
