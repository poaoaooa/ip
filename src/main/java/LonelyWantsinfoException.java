public class LonelyWantsinfoException extends LonelyExceptions {
    private String type;
    public LonelyWantsinfoException(String msg) {
        super();
        this.type = msg;
    }

    @Override
    public String toString() {
        return super.toString() + " The description of a "+ this.type + " does not fit. ｡･ﾟﾟ･(>д<)･ﾟﾟ･｡";
    }
}