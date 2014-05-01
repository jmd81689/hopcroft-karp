package com.hc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

/**
 * This class consists of an implementation of the Hopcroft Karp algorithm to obtain the
 * maximum matching of a bipartite graph.  According to Konigs Theorem, the maximum matching
 * is equivalent to the minimum vertex cover.
 * 
 * Forked from https://github.com/rihuber/ and modified to decouple from other project classes
 * and implement generics for increased modularity.
 * 
 * @author Jonathan DeStefano
 * @version 1.0
 */
public class HopcroftKarp<T>
{

	private LinkedList<T> srcNodes, nodeUnion;
	private LinkedList<Edge<T>> edges;
	//private Vertex nullVertex;
	private T nullVertex;
	
	private HashMap<T, T> pairs;
	private HashMap<T, Integer> distances;
	private int matching;
	private LinkedList<T> queue;

	public HopcroftKarp(LinkedList<T> srcNodes, LinkedList<T> destNodes, LinkedList<Edge<T>> edges)
	{
		this.srcNodes = srcNodes;
		this.edges = edges;
		//nullVertex = new NullVertex();
		nullVertex = null;
		
		nodeUnion = new LinkedList<T>();
		nodeUnion.addAll(srcNodes);
		nodeUnion.addAll(destNodes);
		nodeUnion.add(nullVertex);

		pairs = new HashMap<T, T>();
		distances = new HashMap<T, Integer>();

		queue = new LinkedList<T>();

		runCalculation();
	}

	/**
	 * Gets the result of the maximum matching calculation performed runCalculation() which is
	 * stored as a member variable.
	 * 
	 * @return matching
	 */
	public int getMatchingEdgesCount()
	{
		return matching;
	}

	public HashMap<T, T> getPairs()
	{
		return pairs;
	}

	private void runCalculation() 
	{
		for(T v : nodeUnion)
		{
			pairs.put(v, nullVertex);
		}
		matching = 0;

		while(breathFirstSearch() == true)
		{
			for(T v : srcNodes)
			{
				if(pairs.get(v) == nullVertex)
				{
					if(depthFirstSearch(v) == true)
						matching++;
				}
			}
		}

		// cleanup
		// Remove entries with key nullVertex
		pairs.remove(nullVertex);
		// Remove entries with value nullVertex and remove entries from dest to src		
		Iterator<Entry<T, T>> iterator = pairs.entrySet().iterator();
		while(iterator.hasNext())
		{
			Entry<T, T> currentEntry = iterator.next();
			//I have no idea what to do with the line below, commenting out the OR
			if(currentEntry.getValue() == nullVertex) //|| currentEntry.getValue().isSource())
			{
				iterator.remove();
				continue;
			}
		}
	}

	private boolean depthFirstSearch(T v) 
	{
		if(v != nullVertex)
		{
			for(T u : getAdj(v))
			{
				if(distances.get(pairs.get(u)) == distances.get(v)+1)
				{
					if(depthFirstSearch(pairs.get(u)) == true)
					{
						pairs.put(u, v);
						pairs.put(v, u);
						return true;
					}
				}
			}
			distances.put(v, -1);
			return false;
		}
		return true;
	}

	private boolean breathFirstSearch() 
	{
		for(T v : srcNodes)
		{
			if(pairs.get(v) == nullVertex)
			{
				distances.put(v, 0);
				queue.addLast(v);
			}
			else
				distances.put(v, -1);
		}

		distances.put(nullVertex, -1);

		while(!queue.isEmpty())
		{
			T v = queue.poll();
			for(T u : getAdj(v))
			{
				if(distances.get(pairs.get(u)) == -1)
				{
					distances.put(pairs.get(u), distances.get(v)+1);
					queue.add(pairs.get(u));
				}
			}
		}

		return (distances.get(nullVertex) != -1);
	}

	/**
	 * Gets the adjacent vertex to the object it is called on.
	 * 
	 * @param v
	 * @return result
	 */
	private LinkedList<T> getAdj(T v) 
	{
		LinkedList<T> result = new LinkedList<T>();
		for(Edge<T> e : edges)
		{
			if(e.isIncident(v))
				result.add((T) e.getAdj(v));
		}
		return result;
	}

}