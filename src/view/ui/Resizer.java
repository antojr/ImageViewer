package view.ui;

public class Resizer {
    
    private final int width, height;

    public Resizer(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public Size resize(int width, int height) {
        double wRatio = 1.0D * this.width / width;
        double hRatio = 1.0D * this.height / height;
        return hRatio < wRatio ? 
                new Size((int) (width * hRatio),  (int) (height * hRatio)) : 
                new Size((int) (width * wRatio),  (int) (height * wRatio));
    }
    
}
