package Engine;

public class Map {
	private Node[][] nodes;
	public Map(int xwidth, int ylength)//Kartendatei übergeben
	{
		//leere Beispielkarte.
		//Hier eigentlich die übergebene Kartendatei einlesen.
		nodes=new Node[xwidth][ylength];
		for(int i=0;i<xwidth;i++)
		{
			for(int j=0;j<ylength;j++)
			{
				nodes[i][j]=new Node(i,j, true);
			}
		}
		for(int i=0;i<xwidth;i++)
		{
			for(int j=0;j<ylength;j++)
			{
				createNeighbours(getWalkableNode(i,j));
			}
		}
	}
	public void createNeighbours(Node node)
	{
		node.addNeighbour(getWalkableNode(node.getXpos()-1,node.getYpos()), 1);
		node.addNeighbour(getWalkableNode(node.getXpos()+1,node.getYpos()), 1);
		node.addNeighbour(getWalkableNode(node.getXpos(),node.getYpos()+1), 1);
		node.addNeighbour(getWalkableNode(node.getXpos(),node.getYpos()-1), 1);
		node.addNeighbour(getWalkableNode(node.getXpos()-1,node.getYpos()+1), 1.4);
		node.addNeighbour(getWalkableNode(node.getXpos()-1,node.getYpos()-1), 1.4);
		node.addNeighbour(getWalkableNode(node.getXpos()+1,node.getYpos()+1), 1.4);
		node.addNeighbour(getWalkableNode(node.getXpos()+1,node.getYpos()-1), 1.4);
	}
	public Node getWalkableNode(int xpos, int ypos)
	{
		if(xpos>-1&&xpos<nodes.length&&ypos>-1&&ypos<nodes[0].length)
		{
			if(nodes[xpos][ypos].isWalkable())
			{
				return nodes[xpos][ypos];
			}
			return null;
		}
		else
		{
			return null;
		}
	}
	public void makeWalkable(int xpos, int ypos)
	{
		if(xpos>-1&&xpos<nodes.length&&ypos>-1&&ypos<nodes[0].length)
		{
			createNeighbours(nodes[xpos][ypos]);
			nodes[xpos][ypos].setIsWalkable(true);
			nodes[xpos-1][ypos].addNeighbour(nodes[xpos][ypos],1);
			nodes[xpos+1][ypos].addNeighbour(nodes[xpos][ypos],1);
			nodes[xpos][ypos-1].addNeighbour(nodes[xpos][ypos],1);
			nodes[xpos][ypos+1].addNeighbour(nodes[xpos][ypos],1);
			nodes[xpos-1][ypos-1].addNeighbour(nodes[xpos][ypos],1.4);
			nodes[xpos-1][ypos+1].addNeighbour(nodes[xpos][ypos],1.4);
			nodes[xpos+1][ypos-1].addNeighbour(nodes[xpos][ypos],1.4);
			nodes[xpos+1][ypos+1].addNeighbour(nodes[xpos][ypos],1.4);
		}
	}
	public void makeInWalkable(int xpos, int ypos)
	{
		getWalkableNode(xpos,ypos).removeAllNeighbours();
		getWalkableNode(xpos,ypos).setIsWalkable(false);
		nodes[xpos-1][ypos].removeNeighbour(nodes[xpos][ypos]);
		nodes[xpos+1][ypos].removeNeighbour(nodes[xpos][ypos]);
		nodes[xpos][ypos-1].removeNeighbour(nodes[xpos][ypos]);
		nodes[xpos][ypos+1].removeNeighbour(nodes[xpos][ypos]);
		nodes[xpos-1][ypos-1].removeNeighbour(nodes[xpos][ypos]);
		nodes[xpos-1][ypos+1].removeNeighbour(nodes[xpos][ypos]);
		nodes[xpos+1][ypos-1].removeNeighbour(nodes[xpos][ypos]);
		nodes[xpos+1][ypos+1].removeNeighbour(nodes[xpos][ypos]);
	}
}
