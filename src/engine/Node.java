package Engine;

public class Node {

	private int xpos, ypos;
	private Node[] neighbours;
	private double[] values;
	private boolean walkable;
	public Node(int xpos, int ypos, boolean walkable)
	{
		this.xpos=xpos;
		this.ypos=ypos;
		this.walkable=walkable;
	}
	public int getXpos()
	{
		return xpos;
	}
	public boolean isWalkable()
	{
		return walkable;
	}
	public int getYpos()
	{
		return ypos;
	}
	public Node[] getNeighbours()
	{
		return neighbours;
	}
	public double getValue(Node neighbour)
	{
		return values[getIndex(neighbour)];
	}
	public int getIndex(Node neighbour)
	{
		if(isNeighbour(neighbour))
		{
			int index;
			for(int i=0;i<neighbours.length;i++)
			{
				if(neighbours[i].equals(neighbour))
				{
					index=i;
					return index;
				}
			}
		}
		return -1;
	}
	
	public void setXpos(int xpos)
	{
		this.xpos=xpos;
	}
	public void setYpos(int ypos)
	{
		this.ypos=ypos;
	}
	public void setIsWalkable(boolean walkable)
	{
		this.walkable=walkable;
	}
	public void setNeighbours(Node[] neighbours, double[] values)
	{
		this.neighbours=neighbours;
		this.values=values;
	}
	
	public void addNeighbour(Node newNeighbour, double newValue)
	{
		if(!isNeighbour(newNeighbour)&&newNeighbour!=null)
		{
			Node[] newNeighbours=new Node[neighbours.length+1];
			double[] newValues=new double[values.length+1];
			for(int i=0;i<neighbours.length;i++)
			{
				newNeighbours[i]=neighbours[i];
				newValues[i]=values[i];
			}
			newNeighbours[newNeighbours.length-1]=newNeighbour;
			newValues[newValues.length-1]=newValue;
			neighbours=newNeighbours;
			values=newValues;
		}
	}
	public void removeNeighbour(Node removedNeighbour)
	{
		if(isNeighbour(removedNeighbour)&&removedNeighbour!=null)
		{
			int index=getIndex(removedNeighbour);
			Node[] newNeighbours=new Node[neighbours.length-1];
			double[] newValues=new double[values.length-1];
			for(int i=0;i<index;i++)
			{
				newNeighbours[i]=neighbours[i];
				newValues[i]=values[i];
			}
			for(int j=index+1;j<neighbours.length;j++)
			{
				newNeighbours[j-1]=neighbours[j];
				newValues[j-1]=values[j];
			}
			neighbours=newNeighbours;
			values=newValues;
		}
	}
	public boolean isNeighbour(Node possibleNeighbour)
	{
		boolean inside=false;
		if(possibleNeighbour!=null)
		{
			for(int i=0;i<neighbours.length;i++)
			{
				if(neighbours[i].equals(possibleNeighbour))
				{
					inside=true;
				}
			}
		}
		return inside;
	}
	
	public boolean equals(Node checkedNode)
	{
		return xpos==checkedNode.getXpos()&&ypos==checkedNode.getYpos();
	}
}
