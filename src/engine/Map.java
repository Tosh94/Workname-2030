package Engine;

public class Map {
	private Node[][] nodes;
	public Map(int xwidth, int ylength, Node[] blocked)
	{
		nodes=new Node[xwidth][ylength];
		for(int i=0;i<xwidth;i++)
		{
			for(int j=0;j<ylength;j++)
			{
				nodes[i][j]=new Node(i,j);
			}
		}
		for(int i=0;i<xwidth;i++)
		{
			for(int j=0;j<ylength;j++)
			{
				createNeighbours(nodes[i][j]);
			}
		}
	}
	public void createNeighbours(Node node)
	{
		if(node.getXpos()>0)
		{
			node.addNeighbour(nodes[node.getXpos()-1][node.getYpos()], 1);
			if(node.getYpos()>0)
			{
				node.addNeighbour(nodes[node.getXpos()-1][node.getYpos()-1], 1.4);	
				node.addNeighbour(nodes[node.getXpos()][node.getYpos()-1], 1);
			}
			else if(node.getYpos()==0)
			{
				node.addNeighbour(nodes[node.getXpos()-1][node.getYpos()], 1);
			}
			if(node.getYpos()<nodes[0].length)
			{
				node.addNeighbour(nodes[node.getXpos()-1][node.getYpos()+1],1.4);
				node.addNeighbour(nodes[node.getXpos()][node.getYpos()+1],1);
			}
			else if(node.getYpos()==nodes[0].length)
			{
				node.addNeighbour(nodes[node.getXpos()-1][node.getYpos()], 1);
			}
		}
		else if(node.getXpos()==0)
		{
			if(node.getYpos()>0)
			{
				node.addNeighbour(nodes[node.getXpos()][node.getYpos()-1], 1);
			}
			if(node.getYpos()<nodes[0].length)
			{
				node.addNeighbour(nodes[node.getXpos()][node.getYpos()+1],1);
			}
		}
		if(node.getXpos()<nodes.length)
		{
			node.addNeighbour(nodes[node.getXpos()+1][node.getYpos()], 1);
			if(node.getYpos()>0)
			{
				node.addNeighbour(nodes[node.getXpos()+1][node.getYpos()-1], 1.4);	
				node.addNeighbour(nodes[node.getXpos()][node.getYpos()-1], 1);
			}
			else if(node.getYpos()==0)
			{
				node.addNeighbour(nodes[node.getXpos()+1][node.getYpos()], 1);
			}
			if(node.getYpos()<nodes[0].length)
			{
				node.addNeighbour(nodes[node.getXpos()+1][node.getYpos()+1],1.4);
				node.addNeighbour(nodes[node.getXpos()][node.getYpos()+1],1);
			}
			else if(node.getYpos()==nodes[0].length)
			{
				node.addNeighbour(nodes[node.getXpos()+1][node.getYpos()], 1);
			}
		}
		else if(node.getXpos()==nodes.length)
		{
			if(node.getYpos()>0)
			{
				node.addNeighbour(nodes[node.getXpos()][node.getYpos()-1], 1);
			}
			if(node.getYpos()<nodes[0].length)
			{
				node.addNeighbour(nodes[node.getXpos()][node.getYpos()+1],1);
			}
		}
	}
	public Node getNode(int xpos, int ypos)
	{
		return nodes[xpos][ypos];
	}
}
