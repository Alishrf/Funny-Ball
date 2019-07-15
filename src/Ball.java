public class Ball {
    private double acceleration;
    private double currentX;
    private double currentY;
    private double time;

    public Ball(double acceleration,  double currentX, double currentY, double time) {
        this.acceleration = acceleration;
        this.currentX = currentX;
        this.currentY = currentY;
        this.time = time;
    }

    public double nextY(){
        double y2 = ((0.5) * acceleration * (time)*(time))+currentY;
        return y2;
    }

    public double getCurrentX() {
        return currentX;
    }

    public double getCurrentY() {
        return currentY;
    }
}
