public class Lock {
    private boolean locked;

    public Lock(){
       locked = true;
    }

    void close(){
        locked = true;
    }

    void open(){
        locked = false;
    }

    boolean isLocked(){
        return locked;
    }

    public String toString(){
        if(locked){
            return "Lock is closed";
        }
        else{
            return "Lock is open";
        }
    }


}