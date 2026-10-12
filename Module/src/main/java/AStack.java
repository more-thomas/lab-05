import java.util.Arrays;
public class AStack {
    String[] dat;
    int tot;

    public AStack(String[] dat, int tot){

        this.dat = dat;
        this.tot = tot;

    }

    public static AStack empty_stack(){
        return new AStack(new String[0], 0);
    }

    public void push(String val) {
        if (tot == dat.length) {
            int newSize;

            if (dat.length == 0) {
                newSize = 1;
            } else {
                newSize = dat.length * 2;
            }

            String[] newDat = new String[newSize];

            for (int i = 0; i < tot; i++) {
                newDat[i] = dat[i];
            }

            dat = newDat;
        }

        dat[tot] = val;
        tot += 1;
    }

    public String pop(){
        switch(tot){
            case 0: throw new ArrayIndexOutOfBoundsException("You can't pop an empty stack");
        }
        tot -= 1;
        String result = dat[tot];
        dat[tot] = null;
        return result;
    }

    public String peek() {
        switch(tot) {
            case 0: throw new ArrayIndexOutOfBoundsException("Cannot peek at an empty stack.");
        }

        return dat[tot - 1];
    }
    public int size(){
        switch(tot){
            case 0: return 0;
        }
        return tot;
    }

    public boolean is_empty(){
        switch(tot){
            case 0: return true;
        }
        return false;
    }




}
