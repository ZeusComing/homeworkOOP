public class Main {
    public static void main(String[] args) {
        Vector3D firstVector3D = new Vector3D(-5, 6, 4);
        Vector3D secondVector3D = new Vector3D(7, 3, -4);
        Vector3D thirdVector3D = new Vector3D(0, -1, 9);
        System.out.println(firstVector3D.plusVector3D(secondVector3D).toString());
        System.out.println(secondVector3D.plusVector3D(thirdVector3D).toString());
        System.out.println(firstVector3D.scalarMultiply(thirdVector3D));
        System.out.println(secondVector3D.scalarMultiply(thirdVector3D));
        System.out.println(firstVector3D.multiply(secondVector3D).toString());
        System.out.println(thirdVector3D.multiply(secondVector3D).toString());
    }
}
