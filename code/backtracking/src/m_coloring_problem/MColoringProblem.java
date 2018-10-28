import java.util.*;
import java.lang.*;
import java.io.*;

class MColoringProblem {
    
	public static void McolourProblem(int[][] e, int size, int numCol) {
		
		int[] colourOfVertices=new int[size];
		System.out.println(check(e,numCol,0,size,colourOfVertices));
		
		
		
	}
	
	
    static int check(int[][] edges,int numCol, int vert1,int size,int [] colourOfVertices ){
        
    	
    	if(vert1==size){
    		return 1;
    	}
    	
    	int a=noVerticesWithMatchingColour(edges,vert1,size,colourOfVertices);
    
    	if(a>numCol){
    		return 0;
    	}
    	colourOfVertices[vert1]=a;
    	if(check(edges,numCol,vert1+1,size,colourOfVertices)==0){
    		colourOfVertices[vert1]=0;
    	}
    	else{
    		return 1;
    	}
    
    	
    	return 0;
    }
    
    static int noVerticesWithMatchingColour(int[][] edges, int vert1, int size, int[] colourOfVertices ){
    	
    	int colour=1;
    	
    	
    	for(int  i=0;i<size;i++){
    		if(edges[vert1][i]==1){
    			if(colourOfVertices[i]==colour){
    				
    				++colour;
    				/*if(vert1==6){
    					//System.out.println(i+1+" "+colour);
    				}*/
    				
    			}
    			
    			else if(colourOfVertices[i]>colour) {
    				break;
    			}
    		}
    	}
    	
    	
    	
    	
    return colour;
    }
    
    
    
	public static void main (String[] args) {
		//code
		Scanner s=new Scanner(System.in);
		
		int a=s.nextInt();
		
		for(int i=0;i<a;i++ ){
		    
		    int size=s.nextInt();
		    int [][]e=new int[size][size];
		    
		    int numCol=s.nextInt();
		    
		    int t=s.nextInt();
		    for(int j=0;j<t;j++){
		        int c=s.nextInt();
		        int b=s.nextInt();
		    	e[c-1][b-1]=1;
		    	e[b-1][c-1]=1;
		      
		    }
		    
		  
		    McolourProblem(e,size,numCol);
		    
		}
	}

	
}