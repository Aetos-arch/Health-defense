package Tower_Defense.Modele.Personnage;

import Tower_Defense.Modele.Environnement;

public class InfecteQuiTousse extends Personnage {
	
	private int portee;
	private int delaiDeCompetence;

	public InfecteQuiTousse(int xS, int yS, Environnement e) {
		super(4, 150, xS, yS, e);
		this.portee = 100;
	}

	@Override
	public void seFaireSoigner(int d) {
        this.soin(d);
        if(delaiDeCompetence %80 ==0)
        	this.protegePersos();
        delaiDeCompetence ++;
    }

	private void protegePersos() {
		for(Personnage p : this.env.getPersos()) {
			if(p.getX()> this.getX()-this.portee && p.getX()< this.getX()+this.portee &&
					p.getY()> this.getY()-this.portee && p.getY()< this.getY()+this.portee && !p.estSain()) {
				p.protege();
			}
		}
		
	}
}
