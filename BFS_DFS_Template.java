/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package bfs_dfs_template;
import java.util.*;
import java.io.*;


/**
 *
 * @author MdFarhadur
 */


//template <typename T>
class Graph2<E extends Number>{

    private int vertices;
    final int v_n=7;
    private Vector<E> []adj;
    private List vertex;
    private int array_index;
    
    
    

    public Graph2(int v)
    {
        array_index=0;
        vertices=v;
        vertex=new Vector(v);
        adj= new Vector[v_n];
        for(int i=0;i<v;i++)
            adj[i]=new Vector<E>();        
    }
    
    public void addVertex(E v)
    {
        if(!vertex.contains(v))   
        {
            vertex.add(v);
            System.out.println("Vertex is added: "+v);
        }
        else
        {
            System.out.println("Vertex already exist in the graph: "+v);
            //return;
        }
    }
    
    public void addEdge(E v, E w)
    {
        System.out.println("Size of the Vector: "+adj.length);
     
        addVertex(v);
        addVertex(w);
    
        
         if(!(adj[v.intValue()].contains(w))) {
             adj[v.intValue()].addElement(w);
        }
        else
            System.out.println("Edge already exist in the graph");
               
 }
    
    public void DFS_iterative(E s)
    {
        Stack<E> sg= new Stack<E>();
        
        boolean []discovered=new boolean[vertices];
        for(int i=0;i<vertices;i++)
        {
            discovered[i]=false;
        }
        
        sg.push(s);
        
        System.out.println("Visited Node:");
        
        while(!sg.empty())
        {
            s=sg.peek();
            sg.pop();
            
          //  if(!discovered[(Integer)s])
             if(!discovered[s.intValue()])
            {
                discovered[(Integer)s]=true;
                System.out.println(s+" ");
                
               // for(list<int>::iterator lit=adj[s].begin();lit!=adj[s].end();++lit)
                for(E lit :adj[(Integer)s])
                {
               // try{
                    
              // Enumeration en = adj[s].elements();
               //for(Object lit: adj[s])
              //  while(en.hasMoreElements())
               // {
                  //  sg.push(*lit);
                    sg.push(lit);
                //     sg.push((Integer)en.nextElement());
                //}
               // }
              //  catch ( IndexOutOfBoundsException ind_e) 
              //  {
                // catch ( NullPointerException ind_e2)
                // {
                // }
                }
            }
            
            
        }
    }
    
   public void DFS_recursive(E s)
   {
       System.out.println("Visited Node:");
       boolean []discovered=new boolean[vertices];
        for(int i=0;i<vertices;i++)
        {
            discovered[i]=false;
        }
       
       DFS_recursive_util(s,discovered);
   }  
   
    public void DFS_recursive_util(E s, boolean discovered[])
    {
        discovered[(Integer)s]=true;
        System.out.println(s+" ");
        for(E lit: adj[(Integer)s])
           {
             
            if(!discovered[(Integer)lit])
              {
                    //DFS_recursive_util(n_e, discovered);
                     DFS_recursive_util(lit, discovered);
               }
         
           }
        
    }
    
    
    public void BFS_iterative(E s)
    {
        Queue<E> sg=new LinkedList<E>();
        
        boolean []discovered=new boolean[vertices];
        for(int i=0;i<vertices;i++)
        {
            discovered[i]=false;
        }
        
        sg.offer(s);
        
        System.out.println("Visited Node:");
        
        while(!sg.isEmpty())
        {
            s=sg.peek();
            sg.poll();
            
            if(!discovered[(Integer)s])
            {
                discovered[(Integer)s]=true;
                System.out.println(s+" ");
                
              
            for(E lit :adj[(Integer)s])
            {
           
                    System.out.println(lit+" ");
                   
                    sg.offer(lit);
                }
           
                System.out.println();
            }
            
            
        }
    }
    
    public void printEdges()
    {        
        for(int i=0;i<vertices;i++)
        {
            System.out.println("Edges adjacent to vertex index:\t"+i+"\t are:\t");
          
         try{
         
           Enumeration en = adj[i].elements();
               
                while(en.hasMoreElements())   
           {
                  
                    System.out.println((Integer)en.nextElement()+" ");
           }
      
         } catch ( NullPointerException ind_e2) 
         {
             System.out.println("Element doesn't have any edge from this source");
         }
         }
          System.out.println();
        }
        
    
    
    //no of vertices in the graph
    public int getSize()
    {
        return vertex.size();
    }
    
    
    public List getVertices()
    {
        return vertex;
    }
    
    public int getEdgeSize()
    {
        int edge_count=0;
        try{
        for(int i=0;i<vertex.size();i++)
        {
         
            edge_count+=adj[i].size();
            
            
        }
      
         } catch ( NullPointerException ind_e2) 
         {
         }
        
        return edge_count;
        
    }
    public int getNeighborSize(int v)
    {
       
        return adj[v].size();
    }
    
    public int getVertex(int index)
    {
        return (Integer) vertex.get(index);
    }
    
     public int getIndex(int v)
     {
         for(int i=0;i<vertex.size();i++)
         {
             if((Integer)vertex.get(i)==v)
             {
                 return i;
             }
         }
         return -1;
     }
     
     public void clear()
     {      
         //  adj.clear();
           vertex.clear();
     }
    
};

public class BFS_DFS_Template {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
   Graph2<Integer> g=new Graph2(7);
   
    /* g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);*/
   
  /*  g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);*/
   
  /* g.addEdge(1, 2);
    g.addEdge(1, 3);
    g.addEdge(2, 3);
    g.addEdge(3, 1);
    g.addEdge(3, 4);
    g.addEdge(4, 4);*/
    
  /*  g.addEdge(0, 1);
    g.addEdge(0, 2);
    
   // g.addEdge(2, 0);
    g.addEdge(0, 4);
    
     g.addEdge(1, 3);
    g.addEdge(1, 5);
      g.addEdge(2, 6);
     g.addEdge(3, 4);
    g.addEdge(4, 1);
    
 
       g.addEdge(5, 4);
       
      */
     
     g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(2, 6);
     g.addEdge(2, 6);
    
   // g.addEdge(2, 0);
    g.addEdge(0, 4);
    
     g.addEdge(1, 3);
    g.addEdge(1, 5);
      
     g.addEdge(3, 4);
    g.addEdge(4, 1);
    
 
       g.addEdge(5, 4);
    
   
    
    
  
    
     System.out.println("Print the Edges of the Graph:\n");
    g.printEdges();
    
    
            
 /* g.addEdge(Character.getNumericValue('A')-Character.getNumericValue('A'), Character.getNumericValue('B')-Character.getNumericValue('A'));
  g.addEdge(Character.getNumericValue('A')-Character.getNumericValue('A'), Character.getNumericValue('C')-Character.getNumericValue('A'));
    g.addEdge(Character.getNumericValue('A')-Character.getNumericValue('A'), Character.getNumericValue('E')-Character.getNumericValue('A'));
    
     g.addEdge(Character.getNumericValue('B')-Character.getNumericValue('A'), Character.getNumericValue('D')-Character.getNumericValue('A'));
    g.addEdge(Character.getNumericValue('B')-Character.getNumericValue('A'), Character.getNumericValue('F')-Character.getNumericValue('A'));
    
    g.addEdge(Character.getNumericValue('F')-Character.getNumericValue('A'), Character.getNumericValue('B')-Character.getNumericValue('A'));
    g.addEdge(Character.getNumericValue('F')-Character.getNumericValue('A'), Character.getNumericValue('E')-Character.getNumericValue('A'));
    g.addEdge(Character.getNumericValue('E')-Character.getNumericValue('A'), Character.getNumericValue('F')-Character.getNumericValue('A'));
    
     g.addEdge(Character.getNumericValue('C')-Character.getNumericValue('A'), Character.getNumericValue('G')-Character.getNumericValue('A'));
  */
    
    
    
    System.out.println("Iterative Depth First Traversal:");
  //  g.DFS_iterative(0);

    g.DFS_iterative(Character.getNumericValue('A')-Character.getNumericValue('A'));
    System.out.println("\n");
    
    System.out.println("Recursive Depth First Traversal:");
   // g.DFS_recursive(0);

    g.DFS_recursive(Character.getNumericValue('A')-Character.getNumericValue('A'));
    
    System.out.println("\n");
    System.out.println("Iterative Breadth First Traversal:");
  //  g.BFS_iterative(0);

    g.BFS_iterative(Character.getNumericValue('A')-Character.getNumericValue('A'));
    
    System.out.println("Print the Edges of the Graph:\n");
    g.printEdges();
    
   
    System.out.println("Print vertices of the Graph:");
    
    List<Integer> vertex_2=g.getVertices();
    
    try{
    
    for(int i=0;i<vertex_2.size();i++)
    {
        //System.out.println("Vertex:\t"+vertex_2.get(i)+" "+"Vertex Index:\t"+g.getIndex(vertex_2.get(i))+" ");
        //System.out.println("Neighbor Size:\t"+g.getNeighborSize(vertex_2.get(i)));
        
        System.out.println("Vertex:\t"+i+" "+"Vertex Index:\t"+g.getIndex(i)+" ");
        System.out.println("Neighbor Size:\t"+g.getNeighborSize(i));
    }
  
    } catch ( NullPointerException ind_e2) 
         {
         }
    
    System.out.println("Total no. of Edges:\t"+g.getEdgeSize());
    
    g.clear();
    }
    
}
