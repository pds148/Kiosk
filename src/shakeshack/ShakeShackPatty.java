package shakeshack;

public class ShakeShackPatty {

    public enum PattyType {
        SINGLE,
        DOUBLE
    }

    private PattyType pattyType;

    public ShakeShackPatty(PattyType pattyType) {
        this.pattyType = pattyType;
    }

    public PattyType getPattyType() {
        return pattyType;
    }

    public void setPattyType(PattyType pattyType) {
        this.pattyType = pattyType;
    }
}

