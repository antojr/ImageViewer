package control;

public interface Command {
    public boolean isEnabled();    
    public void execute();
}
