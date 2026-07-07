import java.util.ArrayList;
import java.util.List;

public class Listas {
    List<Integer> nums = new ArrayList<Integer>();

    void main(){
        nums.add(10); //1
        nums.add(20); //2
        nums.add(10); //3
        for(int v : nums){
            IO.println(v);
        }
    }
    
}
