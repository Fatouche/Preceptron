import java.util.Vector;

public class Neurone {
	private final double pas = 0.01;
	
	private double biais;
	private int sortie;
	private Vector<Double> poids;
	
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
	
	public int calculNeurone(Neurone n){
		double res = 0 ;
		
		for(int i = 0; i < n.poids.size(); i = i+2){
			res += (n.poids.elementAt(i) * n.poids.elementAt(i+1)) - n.biais;  
		}
		
		if(res > 0){
			this.sortie = 0;
		}else{
			this.sortie = -1;
		}
		
		return sortie;
	}

}
