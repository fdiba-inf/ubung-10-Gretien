package exercise10;

public class Ellipse extends Figure {
    private Point startPoint;
    private double side2;
    private double side1;

    public Ellipse() {
        super(new Point(0 ,0),1,1);
    }

    public Ellipse(Point startPoint, double side2, double side1) {
        super(new Point(startPoint), side2 ,side1);
    }
  
    public Ellipse(Ellipse otherEllipse) {
        super(new Point(otherEllipse.startPoint),otherEllipse.side2,otherEllipse.side1);
       
    }
    @Override
    public double calculatePerimeter() {
        return Math.PI * (3.0 * (side2 + side1) - Math.sqrt((3.0 * side2 + side1) * (side2 + 3.0 * side1)));
    }
    @Override
    public double calculateArea() {
        return Math.PI * side2 * side1;
    }
   @Override
   public String getType() {
        return (side2 == side1) ? "Circle" : "Ellipse";
    }
   @Override 
   public boolean equal(Figure otherFigure) {
        if (otherFigure instanceof Ellipse) {
            return super.equal(otherFigure);
        } else {
            return false;
        }
    }
    
    @Override
    public boolean containsClick(Point click) {
        double solution = Math.pow((click.getx()-startPoint.getx()),2)/(side2*side2) + Maht.pow((click.gety()-startPoint.gety()),2)/(side1*side1);
        if(solution<=1) return true;
        return false;
    }
}
