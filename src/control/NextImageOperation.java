package control;

import view.ui.ImageDisplay;

public class NextImageOperation implements Command{

    private final ImageDisplay display;

    public NextImageOperation(ImageDisplay display) {
        this.display = display;
    }
    
    @Override
    public boolean isEnabled() {
        return display.getImage().getNext() != null;
    }

    @Override
    public void execute() {
        display.setImage(display.getImage().getNext());
    }
    
}
