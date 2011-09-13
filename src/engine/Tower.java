package Engine;

public class Tower {

	private int ID, towerID, ownerID, maxLife, life, dmg, splash, psn, frz, cooldown, cooldownLeft, range, xpos, ypos;
	private String shape;
	
	public Tower(int iD, int towerID, int ownerID, int maxLife, int life, int dmg, int splash, int psn, int frz, int xpos, int ypos, int range, int cooldown, int cooldownLeft, String shape) 
	{
		ID = iD;
		this.towerID = towerID;
		this.ownerID = ownerID;
		this.maxLife = maxLife;
		this.life = life;
		this.dmg = dmg;
		this.splash = splash;
		this.psn = psn;
		this.frz = frz;
		this.xpos = xpos;
		this.ypos = ypos;
		this.shape = shape;
		this.cooldown=cooldown;
		this.cooldownLeft=cooldownLeft;
		this.range=range;
	}

	public int getID() {
		return ID;
	}

	public int getTowerID() {
		return towerID;
	}

	public int getOwnerID() {
		return ownerID;
	}

	public int getMaxLife() {
		return maxLife;
	}

	public int getLife() {
		return life;
	}

	public int getDmg() {
		return dmg;
	}

	public int getSplash() {
		return splash;
	}

	public int getPsn() {
		return psn;
	}

	public int getFrz() {
		return frz;
	}

	public int getXpos() {
		return xpos;
	}

	public int getYpos() {
		return ypos;
	}

	public String getShape() {
		return shape;
	}
	public int getCooldown() {
		return cooldown;
	}
	public int getCooldownLeft() {
		return cooldownLeft;
	}
	public int getRange() {
		return range;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setTowerID(int towerID) {
		this.towerID = towerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	public void setMaxLife(int maxLife) {
		this.maxLife = maxLife;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	public void setSplash(int splash) {
		this.splash = splash;
	}

	public void setPsn(int psn) {
		this.psn = psn;
	}

	public void setFrz(int frz) {
		this.frz = frz;
	}

	public void setXpos(int xpos) {
		this.xpos = xpos;
	}

	public void setYpos(int ypos) {
		this.ypos = ypos;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}
	public void setCooldown(int cooldown) {
		this.cooldown=cooldown;
	}

	public void setCooldownLeft(int cooldownLeft) {
		this.cooldownLeft=cooldownLeft;
	}
	public void setRange(int range) {
		this.range=range;
	}
	
	public void attack(Creep[] listOfCreeps)
	{
		attack(listOfCreeps, decideWhichToAttack(findCreepsInRange(listOfCreeps, xpos, ypos, range)));
	}
	private Creep[] findCreepsInRange(Creep[] listOfCreeps, int x, int y, int rng)
	{
		Creep[] creepsInRange=new Creep[0];
		for(int i=0;i<listOfCreeps.length;i++)
		{
			if(calcDistance(listOfCreeps[i].getXpos(), listOfCreeps[i].getYpos(),x,y)<=rng)
			{
				creepsInRange=(Creep[])(addToArray(creepsInRange, listOfCreeps[i]));
			}
		}
		return creepsInRange;
	}
	private Creep decideWhichToAttack(Creep[] creepsInRange)
	{
		Creep victim=null;
		Creep[] attackable=new Creep[0];
		for(int i=0;i<creepsInRange.length;i++)
		{
			int wayLeft=creepsInRange[i].getWayLeft();
			boolean x=true;
			for(int j=0;j<attackable.length;j++)
			{
				if(attackable[j].getWayLeft()<wayLeft)
				{
					attackable=new Creep[0];
					x=true;
				}
				else if(attackable[j].getWayLeft()==wayLeft)
				{
					x=true;
				}
			}
			if(x)
			{
				attackable=(Creep[])(addToArray(attackable, creepsInRange[i]));
			}
		}
		if(attackable.length>1)
		{
			int random=(int)(Math.random()*attackable.length);
			victim=attackable[random];
		}
		else if(attackable.length==1)
		{
			victim=attackable[0];
		}
		return victim;
	}
	private void attack(Creep[] listOfCreeps, Creep victim)
	{
		victim.setLife(victim.getLife()-dmg);
		victim.setFrz(frz);
		victim.setPsn(psn);
		Creep[] splashedCreeps=findCreepsInRange(listOfCreeps, victim.getXpos(), victim.getYpos(), splash);
		for(int i=0;i<splashedCreeps.length;i++)
		{
			splashedCreeps[i].setLife(splashedCreeps[i].getLife()-(int)((1-(calcDistance(victim.getXpos(), victim.getYpos(), splashedCreeps[i].getXpos(), splashedCreeps[i].getYpos())/splash))*dmg));
		}
	}
	private Object[] addToArray(Object[] array, Object obj)
	{
		Object[] newArray=new Object[array.length+1];
		for(int i=0;i<array.length;i++)
		{
			newArray[i]=array[i];
		}
		newArray[newArray.length-1]=obj;
		return newArray;
	}
	private double calcDistance(int x1,int y1,int x2,int y2)
	{
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
}
