public class Vector{
  private int d;
  private double[] data;
  
  public Vector(int d){
    this.d = d;
    data = new double[d];
  }
  
  public Vector(double... a){
    this.d = a.length;
    data = new double[d];
    for(int i=0;i<d;i++){
      data[i] = a[i];
    }
  }
  
  public int dimension(){
    return d;
  }
  
  public double dot(Vector that){
    if(that.d != d) throw new IllegaArgumentException("argument wrong");
    double sum = 0.0;
    for(int i=0;i<d;i++){
      sum += data[i]*that.data[i];
    }
    return sum;
  }
  
  public double magnitude(){
    return Math.sqrt(this.dot(this));
  }
  
  public Vector plus(Vector that){
    Vector ret = new Vector(d);
    for(int i=0;i<d;i++){
      ret.data[i] = data[i] + that.data[i];
    }
    return ret;
  }
  
  public Vector minus(Vector that){
    Vector ret = new Vector(d);
    for(int i=0;i<d;i++){
      ret.data[i] = data[i] - that.data[i];
    }
    return ret;
  }
  
  public double distanceTo(Vector that){
    return  this.minus(that).magnitude();
  }
  
  public Vector scale(double alpha){
    Vector ret = new Vector(d);
    for(int i=0;i<d;i++){
      ret.data[i] = alpha * data[i];
    }
    return ret;
  }
  
  public String toString(){
    StringBuilder sb = new StringBuilder();
    for(int i=0;i<d;i++){
      sb.append(data[i] + " ");
    }
    return sb.toString();
  }
  
  public static void main(String[] args) {
        double[] xdata = { 1.0, 2.0, 3.0, 4.0 };
        double[] ydata = { 5.0, 2.0, 4.0, 1.0 };
        Vector x = new Vector(xdata);
        Vector y = new Vector(ydata);

        System.out.println("   x       = " + x);
        System.out.println("   y       = " + y);

        Vector z = x.plus(y);
        System.out.println("   z       = " + z);

        z = z.scale(10.0);
        System.out.println("   z       = " + z);

        System.out.println("  |x|      = " + x.magnitude());
        System.out.println(" <x, y>    = " + x.dot(y));
        System.out.println("dist(x, y) = " + x.distanceTo(y));
        //StdOut.println("dir(x)     = " + x.direction());
    }
}
