package practise.genericity.one;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dao<T> {

    Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.replace(id, entity);
    }

    public List<T> list(){
        List<T> list=new ArrayList<>();
        for (String str:map.keySet()) {
          String value=map.get(str).toString();
            System.out.println(value);
        }
        return  list;
    }

    public  void delete(String id){
        map.remove(id);
    }
}
