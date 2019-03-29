
package dixytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Александр Машьянов, mashyanov1987@gmail.com
 */
public class DepartmentManager {
    
    public String[] sort(String [] departents){
        //результирующий массив строк
        String[] result = null;
      
        //объявляем коллекцию, в которой будут храниться
        //наши строки и инициализируем ее входным массивом строк
        List<String> mainList = new ArrayList<>();
        mainList.addAll(Arrays.asList(departents));
      
        //объявляем и инициализируем коллекцию, в которую будут добавляться 
        //нехватающие строки. Set- потому что хранит только не более одного
        //экземпляра объекта-значения.
        Set<String> toAdd = new HashSet<>();
        
        //массив, в который будут помещаться разбитые строки 
        String[] depCodes = null;
        
        //делитель строк, заданный в задании. 
        String delimetr = "\\\\";
        
        //временная строка
        String temp;
        
        //StringBuilder будет собирать строку из подстрок
        StringBuilder stb;
        
        //  Добавляем недостающие строки:
        //    Для этого сначала делим исходные строки на составные подстроки, а затем,
        //    добавляя по одной подстроке, проверяем, нужно ли добавить получившуюся
        //    строку temp.
        for (String departent : mainList) {
            //очищаем StringBuilder
            stb = new StringBuilder("");
            //делим строку на подстроки заданным в условии знаком
            depCodes = departent.split(delimetr);
            //Теперь к временной строке добавляем по одной полученные подстроки 
            //и проверяем, не надо ли доавить полученную строку.
            for (int i = 0; i < depCodes.length - 1; i++) {
                stb.append(depCodes[i]);
                stb.append("\\");
                //убираем в полученной строке автоматически добавленный в ее
                //конец символ "\", чтоб внешний вид строки соответсвовал в 
                //виду в задании
                temp =stb.toString().substring(0, stb.toString().length()-1);
                if(!mainList.contains(temp)){
                    toAdd.add(temp);
                }
            }
        }
      

        mainList.addAll(toAdd);

        mainList.sort(new MyComparator(delimetr));
 
        //Теперь, когда мы знаем, сколько элементов будет в отсортированном массиве,
        // инициализируем его
        result = new String[mainList.size()];
              
        //заполняем
        for (int i = 0; i < mainList.size(); i++) {
            result[i] = mainList.get(i);
        }
        //возвращаем
        return result;
    }
    
    
    class MyComparator implements Comparator<String>{
        String delimetr;
        String[] array1, array2;

        public MyComparator(String delimetr) {
            this.delimetr = delimetr;
        }
       
        @Override
        public int compare(String s1, String s2) {
            //делим строки на подстроки заданным в задании разделителем
            array1 = s1.split(delimetr);
            array2 = s2.split(delimetr);
            
            int res = 0;
    
            for (int i = 0; array1.length <= array2.length ? i < array1.length : i < array2.length; i++) {
                //если подстроки различаются, сортируем по номеру
                if(!array1[i].equals(array2[i])) {
                    res =  Integer.valueOf(array2[i].replaceAll("[^0-9]+",""))-Integer.valueOf(array1[i].replaceAll("[^0-9]+",""));
                    break;
                }
            }
            //если после сравнения res = 0, возвращаем разницы длинны строк
            return res == 0 ? array1.length - array2.length : res;
          
        }

        
    }
    
}
