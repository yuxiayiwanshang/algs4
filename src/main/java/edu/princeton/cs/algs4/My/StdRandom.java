import java.util.Random;

public final class StdRandom{
  private static Random random;
  private static long seed;
  
  static {
    seed = System.currentTimeMills();
    random = new Random(seed);
  }
  
  private StdRandom(){
  }
  
  public static double uniform(){
    return random.nextDouble();
  }
  
  public static int uniform(int n){
    if(n<=0) throw new IllegalArgumentException("argument must be positive");
    return random.nextInt(n);
  }
  
  public static int uniform(int lo,int hi){
    if(lo>=hi || hi-lo >=Integer.MAX_VALUE) throw new IllegalArgumentException("argument is wrong");
    return lo + random.nextInt(hi-lo);
  }
  
  public static double uniform(double lo,double hi){
    return lo+ random.nextDouble()*(hi-lo);
  }
  
  public static boolean bernoulli(double p){
    return random.nextDouble() < p;
  }
  
  
  
  
}
