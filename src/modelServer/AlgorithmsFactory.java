package modelServer;

import modelServer.*;

public class AlgorithmsFactory {//only create algorithm
	public Searcher getAlgorithm (String algorithm){
		if (algorithm.equals("a-star"))
		{
			return new Astar();
		}
		if(algorithm.equals("bfs"))
		{
			return new BFS();
		}
		return null;
	}
}
