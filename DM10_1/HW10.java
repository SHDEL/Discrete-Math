package DM10_1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class HW10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String [] data = input.split(" ");
        GraphMap g = new GraphMap(data);
        sc.close();
    }
    
}
class GraphMap {
    private String [][] adja = {{"v1", "e1,e2", "", "", "", ""},
                                {"e1,e2", "v2", "e3", "", "", "e8"},
                                {"", "e3", "v3,e4", "e5", "e6", "e7"},
                                {"", "", "e5", "v4", "e10", ""},
                                {"", "", "e6", "e10", "v5", "e9"},
                                {"", "e8", "e7", "", "e9", "v6"}};
    private boolean hasRepEdge = false;
    private boolean hasRepVer = false;
    private boolean isStartEndsame = false;
    private boolean circuit = false;
    private boolean walk = false;
    private boolean simplecircuit = false;
    private ArrayList<String> graph = new ArrayList<>();
    private ArrayList<String> repVer = new ArrayList<>();
    private ArrayList<String> tmprepVer = new ArrayList<>(2);

    private Boolean isGraph = false;
    GraphMap(String [] data){
        checkGraph(data);
    }
    private void checkGraph(String [] data){
        for (int i = 0; i < adja.length; i++){
            for (int j = 0; j < adja[0].length; j++){
                if (adja[i][j].contains(data[i])){
                    graph.add(data[i]);
                }
                
            }
        }
        List<String> input = Arrays.asList(data);
        System.out.println(graph);
        System.out.println(input);
        if (graph.equals(input)){
            summarizeGraph(data);
        }
        
    }
    private void summarizeGraph(String[] data){
        String tmpEdge = "";
        String tmpVer = "";
        String tmpidx = data[0];
        if (data[data.length - 1].equals(tmpidx)){
            tmprepVer.add(tmpidx);
            tmprepVer.add(data[data.length - 1]);
            isStartEndsame = true;
        }
        for (int i = 0; i < data.length; i++){
            
            if (data[i].charAt(0) == 'v'){
                tmpVer = data[i];
            }
            else if (data[i].charAt(0) == 'e'){
                tmpEdge = data[i];
            }
            for (int j = i + 1; j < data.length; j++){
                if (tmpVer.equals(data[j])){
                    hasRepVer = true;
                    repVer.add(tmpVer);
                    repVer.add(data[j]);
                }
                if (tmpEdge.equals(data[j])){
                    hasRepEdge = true;
                }
            }
        }
        if (hasRepEdge == false && data.length > 1){
            circuit = true;
        }
        else if (hasRepVer == false){
            walk = true;
        }
        if(repVer.equals(tmprepVer) && !(repVer.isEmpty() && tmprepVer.isEmpty())){
            simplecircuit = true;
        }
        System.out.println( "is Walk: " + isWalk());
        System.out.println("is Trail: " + isTrail());
        System.out.println("is Path: " + isPath());
        System.out.println("is ClosedWalk: " + isClosedWalk(data));
        System.out.println("is Circuit: " + isCircuit());
        System.out.println("is Simple circuit: " + simplecircuit);
        
    }
    private boolean isWalk(){
        return (hasRepEdge || hasRepVer || isStartEndsame) && circuit == false;
    }
    private boolean isTrail(){
        if ((!hasRepEdge && isStartEndsame == false && hasRepVer)){
            return true;
        }
        else {
            return false;
        }
    }
    private boolean isPath(){
        if (!hasRepEdge && !hasRepVer && !isStartEndsame){
            return true;
        }
        else {
            return false;
        }

    }
    private boolean isClosedWalk(String [] data){
        if (data.length == 1){
            return true;
        }
        if (hasRepEdge && hasRepVer && isStartEndsame){
            return true;
        }
        else {
            return false;
        }
    }
    private boolean isCircuit(){
        if (circuit && hasRepEdge == false && simplecircuit == false && walk == false && isStartEndsame){
            return true;
        }
        else {
            return false;
        }
    }
}
