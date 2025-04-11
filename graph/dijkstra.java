

class Solution {
    
   static class Edge implements Comparable<Edge>{
        int u;
        int v;
        int w;
        Edge(int u,int v,int w){
             this.u=u;
             this.v=v;
             this.w=w;
        }
        public int compareTo(Edge e){
             return e.w-this.w;
        } 
    }
    
    public int[] dijkstra(int V, int[][] edges, int src) {
        
        ArrayList<ArrayList<Edge>> graph=new ArrayList<>();
        
        
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        
        
        for(int i=0;i<edges.length;i++){
             graph.get(edges[i][0]).add(new Edge(edges[i][0],edges[i][1],edges[i][2]));
             graph.get(edges[i][1]).add(new Edge(edges[i][1],edges[i][0],edges[i][2]));
        }
        
        
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        int dis[]=new int[V];
         Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;


        //=======================Taking more time ===========

     //      dis[src]=0;
     //    for(int i=0;i<graph.get(src).size();i++){
     //         pq.add(graph.get(src).get(i));
     //    }
     //     while(!pq.isEmpty()){
     //             Edge curr=pq.remove();
     //              int u=curr.u;
     //              int v=curr.v;
     //              int w=curr.w;
                  
     //              if(dis[u]+w<dis[v]){
                      
     //                   dis[v]=dis[u]+w;
     //                   for(int i=0;i<graph.get(v).size();i++){
     //                        pq.add(graph.get(v).get(i));
     //                   }
                       
     //              }
         }
         
        pq.add(new Edge(src,src,0));
         while(!pq.isEmpty()){
                       int curr=pq.remove().v;
                       for(int i=0;i<graph.get(curr).size();i++){
                          int u=graph.get(curr).get(i).u;
                          int v=graph.get(curr).get(i).v;
                          int w=graph.get(curr).get(i).w;
                          if(dis[u]+w<dis[v]){
                               dis[v]=dis[u]+w;
                               pq.add(graph.get(curr).get(i));
                          }
                       }
         }
         return dis;
    }
}






