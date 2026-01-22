public class LonelyExceptions extends RuntimeException {
    public LonelyExceptions() {
        super("OH NOOO!!");
    }

    @Override
    public String toString() {
        return super.toString()+"\n";
    }
}
