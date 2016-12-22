public class Point
{
  
  private double x;
  private double y;
  public Point()
  {
    x=0;
    y=0;
  }
  public Point(double x, double y)
  {
    this();
    setx(x);
    sety(y);
    
  }
  public double getx()
  {
    return x;
  }
  public double gety()
  {
    return y;
  }
  public void setx(double a)
  {
    x=a;
  }
  
  
  public void sety(double b)
  { 
    y=b;
  }
  public double distanceTo( Point p )
  {
    double distanceTo;
    distanceTo=Math.sqrt(Math.pow(Math.abs(this.x-p.x),2)+Math.pow(Math.abs(this.y-p.y),2));
    return distanceTo;
  }
  public double distanceTo(double x, double y)
  {
    Point temp = new Point(x,y);
    return this.distanceTo(temp);
  }
  public double distanceTo()
  {
   Point temp = new Point(0,0);
    return this.distanceTo(temp);
  }
  public String toString()
  {
    return "x: " + this.getx() + ", y: " + this.gety();
  }
  public boolean equals(Object o)
  {
    if (!( o instanceof Point))
      return false;
    else
    {
      Point objPoint = (Point) o; 
      if (x==(objPoint.x)&&y==(objPoint.y))
        return true;
      else 
        return false;
    }
  }
}

