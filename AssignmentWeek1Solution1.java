import java.util.Scanner;
import java.util.Vector;

class Main{
    public static int nearestDrone(Vector<Pair<Integer,Integer>> point, Pair<Integer,Integer> target){
        int result = -1;
        int dist = Integer.MAX_VALUE;
        
        for(int i=0; i<4; i++){
            int x = point.get(i).getFirst() - target.getFirst();
            int y = point.get(i).getSecond() - target.getSecond();
            
            int maxiValue = Math.abs(x)+Math.abs(y);
            
            if(maxiValue <= dist){
                dist = maxiValue;
                result = i;
            }
        }
        return result;
    }
    
    public static Vector<Pair<Integer, Integer>> directionDrone(Pair<Integer,Integer> drone, Pair<Integer,Integer> target){
        Vector<Pair<Integer, Integer>> path = new Vector<>();
        int direction = 1; //drone is leg from target
        
        // for storing rows 
        if(drone.getFirst() > target.getFirst())
           direction  = -1;
        while(drone.getFirst() != target.getFirst()){
            path.add(drone);
            drone = new Pair<>(drone.getFirst()+direction, drone.getSecond());
        } 
        
        direction = 1;
       // for storing column 
        if(drone.getSecond() > target.getSecond())
           direction  = -1;
        while(drone.getSecond() != target.getSecond()){
            path.add(drone);
            drone = new Pair<>(drone.getFirst(), drone.getSecond()+direction);
        } 
        path.add(target);
        return path;
    }
    public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    //storing points of all 4 drones
    Vector<Pair<Integer,Integer>> point = new Vector<>();
    for(int i=0; i<4; i++){
        System.out.println("Enter position for drone "+(i+1));
        int x = input.nextInt();
        int y = input.nextInt();
        
        point.add(new Pair<>(x,y));
    }
    
    //store target point
    System.out.print("Enter position for Target ");
    Pair<Integer,Integer> target = new Pair<>(input.nextInt(),input.nextInt());
    
    //find nearest drone to the target
    int requiredDrone = nearestDrone(point, target);
    System.out.println("Selected drone is "+(requiredDrone+1));
    
    //store path from drone to target
    Vector<Pair<Integer, Integer>> path = directionDrone(point.get(requiredDrone), target);
    
    System.out.print("Path from Drone to Target is-");
    for(Pair<Integer, Integer> p :path)
      System.out.print("("+p.getFirst()+","+p.getSecond()+")"+"->");
    }
}

class Pair<A,B>{
    private A first;
    private B second;
    
    public Pair(A first, B second){
        this.first = first;
        this.second = second;
    }
    
    public A getFirst(){
        return first;
    }
    
    public B getSecond(){
        return second;
    }
}