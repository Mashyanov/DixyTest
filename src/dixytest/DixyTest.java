
package dixytest;


public class DixyTest {

   
    public static void main(String[] args) {
        String[] unsorted = {"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", 
            "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2" };
        String [] sorted;
  
        DepartmentManager dm = new DepartmentManager();
        sorted = dm.sort(unsorted);
        
        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i]);
        }

    } 
    
}
