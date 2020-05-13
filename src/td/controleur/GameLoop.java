package td.controleur;

import td.modele.Environnement;

public class GameLoop extends Thread{

	private Environnement env;
	
	public GameLoop(Environnement e) {
		this.env = e;
	}
	public  void run() {
			System.out.println("Allo?");
	       int n =  0 ; 
	       while (n++ <  5) {
	         this.env.unTour();
	         System.out.println("Tour " + n);
	         System.out.println(this.env.getPersos().get(0).getX().getValue());
	         System.out.println(this.env.getPersos().get(0).getY().getValue());
	          try {
	        	System.out.println("On fait dodo...");
	            Thread.sleep(3000) ;
	         }  catch (InterruptedException e) {
	         
	             System.out.println("Ca marche pas chef!");
	         }
	      }
	}
}
