package view.persistence;

import java.io.File;
import java.util.ArrayList;
import model.Image;
import view.swing.SwingProxyImage;

public class FileImageLoader implements ImageLoader {
    
    private final File file;

    public FileImageLoader(File file) {
        this.file = file;
    }
    
    public FileImageLoader(String filename) {
        this.file = new File(filename);
    }

    @Override
    public Image load() {
        File[] files = discardFiles(file.listFiles());
        Image[] images = link(map(files));
        return images[indexOf(file, files)];
    }

    private int indexOf(File file, File[] files) {
        for (int i = 0; i < files.length; i++)
            if (files[i].equals(file)) return i;
        return 0;
    }

    private Image[] link(Image[] images) {
        linkNext(images);
        linkPrev(images);
        return images;
    }

    private void linkNext(Image[] images) {
        for (int i = 0; i < images.length - 1; i++)
            images[i].setNext(images[i+1]);
    }

    private void linkPrev(Image[] images) {
        for (int i = 1; i < images.length; i++)
            images[i].setPrev(images[i-1]);
    }

    private Image[] map(File[] files) {
        Image[] images = new Image[files.length];
        for (int i = 0; i < files.length; i++)
            images[i] = new SwingProxyImage(files[i]);
        return images;
    }

    private File[] discardFiles(File[] files) {
        int actualLength = files.length;
        int i=0;
        while( i<actualLength ) {
            if(!accept(files[i])){
                files = deleteFile(files,i);
                actualLength--;
            }
            else i++;
        }
        return files;
    }
    
    private boolean accept(File file) {
        final String[] fileExtensions = {"jpeg","JPEG","JPG","jpg","png","PNG"};
        for (String fileExtension : fileExtensions)
            if (file.getName().endsWith(fileExtension)) return true;
        return false;
    }

    private File[] deleteFile(File[] files, int i) {
        ArrayList<File> copyFile = new ArrayList<File>();
        for(int j=0; j<files.length; j++) copyFile.add(files[j]);
        copyFile.remove(i);
        File[] newFile = new File[copyFile.size()];
        for(int k=0; k<copyFile.size(); k++) newFile[k] = copyFile.get(k);
        return newFile;
    }
    
}
