import java.util.ArrayList;

public interface DataAccess {
     void add(Object object);
     void update(int id,Object object);
     void delete(int id);
     ArrayList<String[]> getAll();
}
