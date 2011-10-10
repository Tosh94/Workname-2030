package Engine;

/**
 * This class represents a tower in the game.
 * An object of type 'Tower' is able to decide which creeps to attack and attack on its own. Further it contains all relevant information about a tower.
 * 
 * @author Tosh
 * @version 0.1
 */
public class Tower {

	/**
	 * The tower큦 ID ingame.
	 * This ID is used to identify a tower in one single game. In any game any tower needs an ID to make it possible to exactly locate it.
	 */
	private int ID;
	
	/**
	 * The tower큦 Tower-ID defining the tower큦 type.
	 * This ID specializes which type of tower is represented by this class. It can choose from predefined values from the database.
	 */
	private int towerID;
	
	/**
	 * The tower큦 Owner-ID specifying the tower큦 Owner.
	 * This ID has a range from 1 to 6, which is actually the maximum of players in a single game. Every player gets one ID in the beginning and all of his towers get the same one.
	 */
	private int ownerID;
	
	/**
	 * The tower큦 maximum life.
	 * This is the highest possible value which the variable life can take.
	 */
	private int maxLife;
	
	/**
	 * The tower큦 actual life.
	 * The height of this value correlates to the time it will take for a creep to destroy it. It is capped by the variable maxLife. In the actual state of the game it is not possible that this value gets lowered because creeps damaging towers are not implemnted.
	 */
	private int life;
	
	/**
	 * The damage the tower deals with an attack.
	 * This variable defines how much damage the tower implies to a creep if the tower hits it. May be negative. In this case the tower is healing the creeps.
	 */
	private int dmg;
	
	/**
	 * The range in which splash damage is dealt.
	 * This variable is defined by the distance from the hit object in which splash damage is dealt. The splash damage dealt falls equally to the distance between the attack큦 victim and the splashed creep. If this tower does not do splash damage, this should be 0.
	 */
	private int splash;
	
	/**
	 * The strength of the poison dealt by this tower큦 attacks.
	 * If the tower큦 attacks apply a poison to a creep, this will just be written into the creep큦 stats. The running engine will damage the creep according to it큦 grade of poison. If the tower doesn큧 apply poison to creeps, this should be 0.
	 */
	private int psn;
	
	/**
	 * The strength of the freeze dealt by this tower큦 attacks.
	 * If the tower큦 attacks freeze a creep, this will just be written into the creep큦 stats. The running engine will freeze the creep according to its grade of freeze. If the tower doesn큧 freeze creeps, this should be 0.
	 */
	private int frz;
	
	/**
	 * The tower큦 cooldown between attacks.
	 * This is the amount of time in game-ticks which the tower needs until he can procedure his next attack. This value needs a minimum of 1 according to the game큦 logics. The variable cooldownLeft may not take higher values than this value.
	 */
	private int cooldown;
	
	/**
	 * The tower큦 cooldown until the next attack.
	 * This is the amount of time in game-ticks until the next attack done by this tower. This value has a minimum of zero and may not take higher values than cooldown.
	 */
	private int cooldownLeft;
	
	/**
	 * The maximum range of the tower큦 attacks.
	 * This value represents the towers shooting range in pixels (not grid-fields). A creep exactly on the limit will still be damaged. It큦 possible to do damage to creeps further away than this by dealing splash damage.
	 */
	private int range;
	
	/**
	 * The tower큦 position on the x-axis.
	 * This variable specifies the tower큦 position on the x-axis. It큦 unit are grid-fields (not pixels).
	 */
	private int xpos;
	
	/**
	 * The tower큦 position on the y-axiy.
	 * This variable specifies the tower큦 position on the y-axis. It큦 unit are grid-fields (not pixels).
	 */
	private int ypos;
	
	/**
	 * The tower큦 shape for graphics.
	 * This string is the shape큦 name. It can take values like "Rectangle", "Triangle", "Circle" etc. In later game development (when graphics are done properly) this should be replaced by the tower큦 picture큦 filename.
	 */
	private String shape;
	
	
	/**
	 * The tower큦 constructor readying it for usage.
	 * In this function all the tower큦 variables are initialized. To do so, all of these need to be given. This means the value큦 reading out of database takes place in the Game class and not here.
	 */
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

	/**
	 * Returns the tower큦 ingame ID.
	 * @return the ID as integer.
	 * @see #setID(int ID)
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Returns the tower큦 type큦 ID.
	 * @return the Tower-ID as integer.
	 * @see #setTowerID(int towerID)
	 */
	public int getTowerID() {
		return towerID;
	}

	/**
	 * Returns the tower큦 owner큦 ID.
	 * @return the owner큦 ID as integer between 1 and 6.
	 * @see #setOwnerID(int ownerID)
	 */
	public int getOwnerID() {
		return ownerID;
	}

	/**
	 * Returns the tower큦 maximum life.
	 * @return the maximum life as integer. Must be 1 or greater.
	 * @see #setMaxLife(int maxLife)
	 */
	public int getMaxLife() {
		return maxLife;
	}

	/**
	 * Returns the tower큦 actual amount of life.
	 * @return the actual tower큦 life as integer. Range: 0-maxLife
	 * @see #setLife(int life)
	 */
	public int getLife() {
		return life;
	}

	/**
	 * Returns the tower큦 dealt damage.
	 * @return the damage the tower deals with a hit as integer.
	 * @see #setDmg(int dmg)
	 */
	public int getDmg() {
		return dmg;
	}

	/**
	 * Returns the range in which the tower deals splash damage.
	 * @return the splash-range as integer in pixels. 0 if no splash, else greater than 0.
	 * @see #setSplash(int splash)
	 */
	public int getSplash() {
		return splash;
	}

	/**
	 * Returns the strength of the poison affecting hit enemies.
	 * @return the grade of the poison as integer. 0 if no poison, else greater than 0.
	 * @see #setPsn(int psn)
	 */
	public int getPsn() {
		return psn;
	}

	/**
	 * Returns the strength of the freezing effect applied to hit enemies.
	 * @return the grade of the tower큦 freezing effect as integer. 0 if no freeze, else greater than 0.
	 * @see #setFrz(int frz)
	 */
	public int getFrz() {
		return frz;
	}

	/**
	 * Returns the tower큦 position on the x-axis.
	 * @return the tower큦 position on the x-axis as integer in grid-fields. Minimum: 0
	 * @see #setXpos(int xpos)
	 */
	public int getXpos() {
		return xpos;
	}

	/**
	 * Returns the tower큦 position on the y-axis.
	 * @return the tower큦 position on the y-axis as integer in grid-fields. Minimum: 0
	 * @see #setXpos(int ypos)
	 */
	public int getYpos() {
		return ypos;
	}

	/**
	 * Returns the tower큦 shape큦 name.
	 * @return the tower큦 shape큦 name as String. Possible are f.e.: "Rectangle", "Circle", "Triangle"
	 * @see #setShape(String shape)
	 */
	public String getShape() {
		return shape;
	}
	
	/**
	 * Returns the tower큦 cooldown time between two attacks.
	 * @return the tower큦 cooldown time between two attacks as integer in ticks. Must be greater than or equal 1.
	 * @see #setCooldown(int cooldown)
	 */
	public int getCooldown() {
		return cooldown;
	}
	
	/**
	 * Returns the tower큦 left cooldown until the next attack.
	 * @return the tower큦 left cooldown until the next attack as integer in ticks. Range: 0-cooldown.
	 * @see #setCooldownLeft(int cooldownLeft)
	 */
	public int getCooldownLeft() {
		return cooldownLeft;
	}
	
	/**
	 * Returns the tower큦 shooting range.
	 * @return the tower큦 range as integer in pixels.
	 * @see #setRange(int range)
	 */
	public int getRange() {
		return range;
	}

	/**
	 * Sets the tower큦 ID. Should usually not be used.
	 * @param ID the tower큦 ingame ID. By standard a fix value. Used to identify the instance of the tower ingame.
	 * @see #getID()
	 */
	public void setID(int ID) {
		this.ID = ID;
	}

	/**
	 * Sets the tower큦 type큦 ID. Should usually be used for upgrading the tower.
	 * @param towerID the tower큦 type큦 ID. Used as reference to the database.
	 * @see #getTowerID()
	 */
	public void setTowerID(int towerID) {
		this.towerID = towerID;
	}

	/**
	 * Sets the tower큦 owner큦 ID. Should usually only be changed in case of a plyer disconnecting in game mode 'Tower Wars'.
	 * @param ownerID the tower큦 owner큦 ID. Used to specify which player 1-6 owns the tower.
	 * @see #getOwnerID()
	 */
	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	/**
	 * Sets the tower큦 maximum life. 
	 * @param maxLife the tower큦 maximum life. Must be 1 or greater.
	 * @see #getMaxLife() 
	 */
	public void setMaxLife(int maxLife) {
		this.maxLife = maxLife;
	}

	/**
	 * Sets the tower큦 actual life.
	 * @param life the tower큦 actual life as integer. Must be between 0 and maxLife. In the actual state of the game this is not just according to creeps not being able to damage towers.
	 * @see #getLife()
	 */
	public void setLife(int life) {
		this.life = life;
	}

	/**
	 * Sets the damage the tower does on a hit.
	 * @param dmg the damage dealt by the tower. May be negative meaning it heals creeps.
	 * @see #getDmg() 
	 */
	public void setDmg(int dmg) {
		this.dmg = dmg;
	}

	/**
	 * Sets the tower큦 splash range.
	 * @param splash the range starting at the hit creep in which the tower deals splash damage. 0 if no splash damage, else greater than 0.
	 * @see #getSplash()
	 */
	public void setSplash(int splash) {
		this.splash = splash;
	}

	/**
	 * Sets the tower큦 poison strength.
	 * @param psn the grade of the poison a creep is affected by if hit by this tower. 0 if no poison, else greater than 0.
	 * @see #getPsn()
	 */
	public void setPsn(int psn) {
		this.psn = psn;
	}

	/**
	 * Sets the tower큦 freeze strength.
	 * @param frz the grade of the freeze effect a creep is affected by if hit by this tower. 0 if no freeze, else greater than 0.
	 * @see #getFrz()
	 */
	public void setFrz(int frz) {
		this.frz = frz;
	}

	/**
	 * Sets the tower큦 position on the x-axis.
	 * @param xpos the tower큦 position on the x-axis in grid-fields.
	 * @see #getXpos()
	 */
	public void setXpos(int xpos) {
		this.xpos = xpos;
	}

	/**
	 * Sets the tower큦 position on the y-axis.
	 * @param ypos the tower큦 position on the y-axis in grid-fields.
	 * @see #getYpos()
	 */
	public void setYpos(int ypos) {
		this.ypos = ypos;
	}

	/**
	 * Sets the tower큦 shape
	 * @param shape the tower큦 shape as String. f.e.: "Rectangle", "Triangle", "Circle", etc.
	 * @see #getShape()
	 */
	public void setShape(String shape) {
		this.shape = shape;
	}
	
	/**
	 * Sets the tower큦 cooldown between two attacks.
	 * @param cooldown the tower큦 cooldown between two attacks in ticks. Must be 1 or greater.
	 * @see #getCooldown()
	 */
	public void setCooldown(int cooldown) {
		this.cooldown=cooldown;
	}

	/**
	 * Sets the tower큦 actual cooldown until the next attack.
	 * @param cooldownLeft the cooldown left to the next attack. Must be between 0 and cooldown.
	 * @see #getCooldownLeft()
	 */
	public void setCooldownLeft(int cooldownLeft) {
		this.cooldownLeft=cooldownLeft;
	}
	
	/**
	 * Sets the tower큦 shooting range.
	 * @param range the tower큦 shooting range in pixels. Must be greater than 0. Should be greater than 1/2 grid-field, so the tower can attack anything.
	 * @see #getRange()
	 */
	public void setRange(int range) {
		this.range=range;
	}
	
	/**
	 * Procedures an attack by this tower.
	 * To do so it uses attack() which applies damage and splash damage to the creeps in listOfCreeps chosen by decideWhichToAttack. This decides which creep has the highest priority and actually just asks for the shortest way left. To use less time only creeps in range are tested, which are searched by findCreepsInRange(). This uses the position and range of this tower to find according creeps in listOfCreeps
	 * @param listOfCreeps the array of all creeps ingame.
	 * @see #attack(Creep[] listOfCreeps, Creep victim)
	 * @see #decideWhichToAttack(Creep[] creepsInRange)
	 * @see #findCreepsInRange(Creep[] listOfCreeps, int x, int y, int range)
	 */
	public void doAttack(Creep[] listOfCreeps)
	{
		attack(listOfCreeps, decideWhichToAttack(findCreepsInRange(listOfCreeps, xpos, ypos, range)));
	}
	
	/**
	 * Searches for creeps in range of this tower.
	 * This function finds all creeps in the array listOfCreeps which are in range of this tower. This is done by calculating the distance to the tower for each creep and comparing it to the tower큦 range. All creeps with a distance smaller than range will be listed in an array and returned.
	 * @param listOfCreeps the list of all creeps ingame. This is the database for the search for the creeps in range.
	 * @param x together with y this defines the position of the tower and so the initial position to calculate with.
	 * @param y together with x this defines the position of the tower and so the initial position to calculate with.
	 * @param rng the range in which the found creeps should be.
	 * @return the list of all creeps in range of the tower.
	 */
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
	
	/**
	 * Searches for the creep in range with the highest priority and chooses it to be attacked.
	 * This is done by comparing all the creep큦 waysLeft and choosing all those with the littlest one. One of those will be randomly chosen to be attacked.
	 * @param creepsInRange the list of all creeps in the tower큦 range.
	 * @return the Creep which is chosen to be the attack큦 victim.
	 */
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
	
	/**
	 * Deals damage to a creep.
	 * This is done by at first applying the standard damage to the creep, after that the grade of poison and freeze are set and last splash damage is dealt by searching all creeps from listOfCreeps in splash range with findCreepsInRange and after that dealing damage according to the distance to the initially attacked victim.
	 * @param listOfCreeps the list of all Creeps ingame.
	 * @param victim the creep to be attackd.
	 */
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
	
	/**
	 * Adds an object to an array.
	 * @param obj the object being added to an array.
	 * @param array the array for the object to be added to.
	 * @return the array with the object added. Its length is increased by 1.
	 */
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
	
	/**
	 * Calculates the distance between two points P(x1,y1) and Q(x2,y2) using Pythagoras.
	 * @param x1 the x-coordinate of P
	 * @param y1 the y-coordinate of P
	 * @param x2 the x-coordinate of Q
	 * @param y2 the y-coordinate of Q
     * @return the distance between P and Q in the unit of x1, y1, x2, y2.
	 */
	private double calcDistance(int x1,int y1,int x2,int y2)
	{
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}
}
