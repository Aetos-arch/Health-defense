package td.modele;

public class Personnage {

	private int x;
	private int y;
	private int nivCont;
	private int vitesse;
	private int dirX;
	private int dirY;
	
	public Personnage() {
		int random = (int)(Math.random()*20);
		this.x= random;
		random = (int)(Math.random()*20);
		this.y = random;
		this.nivCont = 10;
		this.vitesse = 1;
		this.dirX = 0;
		this.dirY = 0;
	}
	
	public void agit() {
		int random = (int)(Math.random()*4);
		switch (random) {
		case 0:
			dirX=0;
			dirY=0;
			break;
		case 1:
			dirX=1;
			dirY=0;
			break;
		case 2:
			dirX=-1;
			dirY=0;
			break;
		case 3:
			dirX=0;
			dirY=1;
			break;
		case 4:
			dirX=0;
			dirY=-1;
		}
		this.x += this.dirX;
		this.y += this.dirY;
		
		if(this.x<0 || this.x >20)
			this.x -= this.dirX*2;
		if(this.y<0 || this.y >20)
			this.y -= this.dirY*2;	
	}
}
