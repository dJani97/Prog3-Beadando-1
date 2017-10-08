package adatkezeles;


import java.util.List;
import javax.swing.AbstractListModel;


public interface AdatInput<T>{
    
    public List<T> adatLista() throws Exception;
    public AbstractListModel<T> adatModel() throws Exception;
    
}
