package emotionalsongs;

public class Loading {

    final static int  length = 30;
    final static int SPEED = 40;

    public static void loading() {
        int i = 0;
        while(i <length) {
            System.out.print("[");
            for (int j = 0; j < i; j++) {
                System.out.print("=");
            }
            for (int j = 0; j < (length - 1) - i; j++) {
                System.out.print(" ");
            }
            try {
                System.out.print("] " + getPercentuale(i) + "%");
                if (i < (length - 1)) {
                    System.out.print("\r");
                    Thread.sleep(SPEED);
                }
                i++;
            } catch (InterruptedException e) {}
        }
        System.out.println();
    }

    private static int getPercentuale(int i) {
        if(i==0){
            return 0;
        }
        else if(i == (length-1)){
            return 100;
        }
        else{
            return (i*100)/length;
        }
    }

}

