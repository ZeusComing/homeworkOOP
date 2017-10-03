public class Vector3D {
    private double pointX;
    private double pointY;
    private double pointZ;

    public Vector3D(double pointX, double pointY, double pointZ) {
        this.pointX = pointX;
        this.pointY = pointY;
        this.pointZ = pointZ;
    }

    public Vector3D() {
    }

    public Vector3D plusVector3D(Vector3D Vector3D) {
        Vector3D resultVector3D = new Vector3D();
        resultVector3D.pointX = this.pointX + Vector3D.pointX;
        resultVector3D.pointY = this.pointY + Vector3D.pointY;
        resultVector3D.pointZ = this.pointZ + Vector3D.pointZ;
        return resultVector3D;
    }

    public double scalarMultiply(Vector3D Vector3D) {
        double result;
        result = this.pointX*Vector3D.pointX + this.pointY*Vector3D.pointY + this.pointZ*Vector3D.pointZ;
        return result;
    }

    public Vector3D multiply(Vector3D Vector3D) {
        Vector3D resultVector3D = new Vector3D();
        resultVector3D.pointX = this.pointY*Vector3D.pointZ - Vector3D.pointY*this.pointZ;
        resultVector3D.pointY = this.pointZ*Vector3D.pointX - Vector3D.pointZ*this.pointX;
        resultVector3D.pointZ = this.pointX*Vector3D.pointY - Vector3D.pointX*this.pointY;
        return resultVector3D;
    }

    @Override
    public String toString() {
        return "Vector3D{" +
                "pointX=" + pointX +
                ", pointY=" + pointY +
                ", pointZ=" + pointZ +
                '}';
    }

}
