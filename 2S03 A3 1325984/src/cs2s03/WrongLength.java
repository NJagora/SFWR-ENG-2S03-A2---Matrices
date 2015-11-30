package cs2s03;

class WrongLength extends Throwable {
    private int len_ex;
    private int len_real;
    private String name;

    public WrongLength(int len_ex, int len_real, String name) {
        this.len_ex = len_ex;
        this.len_real = len_real;
        this.name = name;
    }

    public String FormatError() {
        return "Incorrect array size. Expected array size " + this.len_ex + " in " + this.name + ". Actual size: " + this.len_real;
    }
}