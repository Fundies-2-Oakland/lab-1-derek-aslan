import javax.naming.NameNotFoundException;

public class Vector3D {
    private double x, y, z;
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getZ() {
        return z;
    }
    public String toString() {
        return "(" + Math.round(x*100.0)/100.0 + ", " + Math.round(y*100.0)/100.0 + ", " + Math.round(z*100.0)/100.0 + ")";
    }
    public double getMagnitude() {
        return Math.sqrt(x*x+y*y+z*z);
    }
    public Vector3D normalize() {
        if(getMagnitude() == 0.0) {
            throw new IllegalStateException("Magnitude is 0");
        }
        return new Vector3D(x/this.getMagnitude(),y/this.getMagnitude(),z/this.getMagnitude());
    }
    public Vector3D add(Vector3D other){
        return new Vector3D(this.x + other.getX(), this.y + other.getY(), this.z + other.getZ());
    }
    public Vector3D multiply(Double scalar){
        return new Vector3D(this.x * scalar, this.y * scalar, this.z * scalar);
    }
    public double dotProduct(Vector3D other){
        return this.x * other.getX() + this.y * other.getY() + other.getZ();
    }
    public static double angleBetween(Vector3D firstVector, Vector3D secondVector){
        double radians = Math.acos(firstVector.dotProduct(secondVector)/firstVector.getMagnitude()/secondVector.getMagnitude());
        return radians*360/2/Math.PI;
    }
    public Vector3D crossProduct(Vector3D other){
        return new Vector3D(y * other.getZ() - z * other.getY(), z * other.getX() - x * other.getZ(), x * other.getY() - y * other.getX());
    }
}

