import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class Perceptron {
	
	public Vector<Point> generationPoint(int nbPoints){
		Vector<Point> vPoints = new Vector<>();
		double x1, x2; 
		
		for(int i = 0; i < nbPoints; i++){
			x1 = Math.random();
			x2 = Math.random();
			
			if(x1+x2-1 > 0){
				vPoints.add(new Point(x1,x2,1));
			}else{
				vPoints.add(new Point(x1,x2,-1));
			}
		}
		return vPoints;
	}
	
	public void showVPoints(Vector<Point> vPoints){
		File validation = new File("validation.csv");
		File apprentissage = new File("apprentissage.csv");
		
		try{
			FileWriter fwValid = new FileWriter(validation);
			FileWriter fwApp = new FileWriter(apprentissage);
			
			for(int i = 0; i < vPoints.size(); i++){
				System.out.println(vPoints.get(i).getX() + " " + vPoints.get(i).getY()+ " " + vPoints.get(i).getTag());
				fwValid.write(vPoints.get(i).getX() + " " + vPoints.get(i).getY()+ " " + vPoints.get(i).getTag() + "\n");
				fwApp.write(vPoints.get(i).getX() + " " + vPoints.get(i).getY()+ " " + vPoints.get(i).getTag() + "\n");
				
				fwValid.flush();
				fwApp.flush();
			}
		}catch(IOException e){
			System.out.println("Ecriture a echoué ! ");
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Perceptron p = new Perceptron();
		Vector<Point> points = p.generationPoint(50);
		p.showVPoints(points);
	}

}
