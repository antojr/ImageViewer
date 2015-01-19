package control;

import view.ui.ImageDisplay;

public class PrevImageOperation implements Command{

    private final ImageDisplay display;

    public PrevImageOperation(ImageDisplay display) {
        this.display = display;
    }
    
    @Override
    public boolean isEnabled() {
        return display.getImage().getPrev() != null;
    }

    @Override
    public void execute() {
        display.setImage(display.getImage().getPrev());
    }
    
}
