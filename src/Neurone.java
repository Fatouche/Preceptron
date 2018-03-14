import java.util.Vector;

public class Neurone {
	
	private final double pas = 0.01;
	
	private double biais;
	private int sortie;
	private Vector<Double> poids = new Vector<>();
	private int nbErreur = 0;
	
	public Neurone(){
		this.sortie = 0;
		this.biais = 0.5;
		for(int i = 0; i < 2; i++ ){
			this.poids.add(Math.random()); 
		}
	}
	
	public Neurone(double biais, int sortie, Vector<Double> poids){
		this.biais = biais;
		this.poids = poids;
		this.sortie = sortie;
	}
	
	public int calculNeurone(Point p){
		double sigma = 0 ;
		
		sigma += ((this.poids.elementAt(0) * p.getX()) + (this.poids.elementAt(1) * p.getY())) - this.biais;  
		
		if(sigma > 0){
			this.sortie = 1;
		}else{
			this.sortie = -1;
		}
		
		return this.sortie;
	}
	
	public void MAJNeurone(Point p){
		double add1 = this.pas * (p.getTag()-this.sortie)*p.getX();
		double add2 = this.pas * (p.getTag()-this.sortie)*p.getY();
		
		this.biais += this.pas * ( p.getTag()- this.sortie)*(-0.5);
		
		this.poids.set(0, this.poids.get(0)+add1);
		this.poids.set(1, this.poids.get(1)+add2);
	}
	
	public void run(Vector<Point> points){
		nbErreur = 0;
		for (Point point : points) {
			if(this.calculNeurone(point) != point.getTag()){
				nbErreur++;
				this.MAJNeurone(point);
			}
		}
		System.out.println(" le nombre d'erreur(s) : " + nbErreur);
	}

}
