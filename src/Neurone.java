

public class Neurone {
	private final double pas = 0.01;
	
	private double biais;
	private int sortie;
	private double poids[];
	
	public Neurone(){
		this.sortie = 0;
		this.biais = 0.5;
		for(int i = 0; i < 2; i++ ){
			this.poids[i] = Math.random(); 
		}
	}
	
	public Neurone(double diais, int sortie, double poids[]){
		this.biais = biais;
		this.poids = poids;
		this.sortie = sortie;
	}

}
