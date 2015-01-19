package model;

public interface Image {
    public Bitmap getBitmap();
    public Image getNext();
    public Image getPrev();
    public void setNext(Image next);
    public void setPrev(Image prev);
}
