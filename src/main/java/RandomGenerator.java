public class RandomGenerator {
        public static int generateIntFromZeroTo(int to){
            to = to+1;
             int generated = (int) ((Math.random() * (to - 0)) + 0);
            return generated;
        }

}
