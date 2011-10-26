package Engine;

public class Map {
	private Node[][] nodes;
	public Map(int xwidth, int ylength)//Kartendatei übergeben
	{
		nodes=new Node[xwidth][ylength];
		for(int i=0;i<xwidth;i++)
		{
			for(int j=0;j<ylength;j++)
			{
				nodes[i][j]=new Node(i,j, true);
			}
		}
		//Hier eigentlich Karteneinlesen.
		for(int i=0;i<xwidth;i++)
		{
			for(int j=0;j<ylength;j++)
			{
				//Verbinde Knoten
			}
		}
	}
	public void createNeighbours(Node node)
	{
		node.addNeighbour(nodes[node.getXpos()-1][node.getYpos()], 1);
		node.addNeighbour(nodes[node.getXpos()+1][node.getYpos()], 1);
		node.addNeighbour(nodes[node.getXpos()][node.getYpos()-1], 1);
		node.addNeighbour(nodes[node.getXpos()][node.getYpos()+1], 1);
		node.addNeighbour(nodes[node.getXpos()-1][node.getYpos()-1], 1.4);
		node.addNeighbour(nodes[node.getXpos()-1][node.getYpos()+1], 1.4);
		node.addNeighbour(nodes[node.getXpos()+1][node.getYpos()-1], 1.4);
		node.addNeighbour(nodes[node.getXpos()+1][node.getYpos()+1], 1.4);
	}
	public Node getNode(int xpos, int ypos)
	{
		if(xpos>-1&&xpos<nodes.length&&ypos>-1&&ypos<nodes[0].length)
		{
			return nodes[xpos][ypos];
		}
		else
		{
			return null;
		}
	}
}
