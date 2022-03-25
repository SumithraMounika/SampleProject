import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

// don't change the name of this class
// you can add inner classes if needed
class Main {
	public static void main (String[] args) {
                      // Your code here
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        GroupOfNumbers(arr, N);
        
	}

    public static void GroupOfNumbers(int[] arr, int N){

        HashMap<Integer, Integer> numberOccurrence = new HashMap<>();

        for(int i=0;i<N;i++){
            if(!numberOccurrence.containsKey(arr[i])){
                numberOccurrence.put(arr[i],1);
            }else{
                numberOccurrence.put(arr[i], numberOccurrence.get(arr[i])+1 );
            }
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(numberOccurrence.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>(){
            public int compare(Map.Entry<Integer,Integer> a, Map.Entry<Integer,Integer> b){
                if(a.getValue() == b.getValue()) return b.getKey() - a.getKey();
                return b.getValue() - a.getValue();
            }
        });

        for(Map.Entry<Integer,Integer> i : list){
            System.out.print(i.getKey()+" ");
        }
        // System.out.println(list);
        // System.out.println(numberOccurrence); 
    }
}
