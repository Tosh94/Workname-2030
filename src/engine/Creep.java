package Engine;
import java.awt.Point;

public class Creep {

	private int ID, creepID, speed, maxLife, life, dmg, psn, frz, xpos, ypos, wayLeft;
	private Point[] path;
	private String shape;
	
	public Creep(int iD, int creepID, int speed, int maxLife, int life, int dmg, int psn, int frz, int xpos, int ypos, String shape, int xgoal, int ygoal) 
	{
		ID = iD;
		this.creepID = creepID;
		this.speed = speed;
		this.maxLife = maxLife;
		this.life = life;
		this.dmg = dmg;
		this.psn = psn;
		this.frz = frz;
		this.xpos = xpos;
		this.ypos = ypos;
		this.shape = shape;
		findPath(xpos, ypos, xgoal, ygoal);
	}
	
	public int getID() {
		return ID;
	}
	public int getCreepID() {
		return creepID;
	}
	public int getSpeed() {
		return speed;
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
	public int getWayLeft() {
		return wayLeft;
	}
	public String getShape() {
		return shape;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public void setCreepID(int creepID) {
		this.creepID = creepID;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
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
	
	public Point[] findPath(int xstart, int ystart, int xgoal, int ygoal)
	{
		Point[] pathFound=new Point[2];
		pathFound[0]=new Point(xstart, ystart);
		pathFound[1]=new Point(xgoal, ygoal);
		return pathFound;
	}
}
