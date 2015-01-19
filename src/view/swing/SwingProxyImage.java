package view.swing;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import model.Bitmap;
import model.Image;

public class SwingProxyImage implements Image{
    
    private final File file;
    private Bitmap bitmap;
    private Image next;
    private Image prev;

    public SwingProxyImage(File file) {
        this.file = file;
    }

    @Override
    public Bitmap getBitmap() {
        if (bitmap == null) bitmap = loadBitmap();
        return bitmap;
    }

    @Override
    public Image getNext() {
        return next;
    }

    @Override
    public void setNext(Image next) {
        this.next = next;
    }

    @Override
    public Image getPrev() {
        return prev;
    }

    @Override
    public void setPrev(Image prev) {
        this.prev = prev;
    }

    private Bitmap loadBitmap() {
        try {
            return new SwingBitmap(ImageIO.read(file));
        } catch (IOException ex) {
            return null;
        }
    }

}
