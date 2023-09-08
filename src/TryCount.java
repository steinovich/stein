public class TryCount {
    private int tryCount;
    private String name;
    public TryCount(int tryCount,String name){
        this.tryCount=tryCount;
        this.name=name;
    }

    public int getTryCount() {
        return tryCount;

    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }
    public void decrease(){
        tryCount--;
    }
}
