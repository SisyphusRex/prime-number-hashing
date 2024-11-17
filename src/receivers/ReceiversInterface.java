package primenumberhashing.src.receivers;

//System Imports
import java.util.HashMap;
//First Party Imports

public interface ReceiversInterface {
    public void changeModulo(Integer newModulo);

    public void changeHashConstant(Integer newHashConstant);

    public void changeHashPattern(String newHashPattern);

    public void loadHashTable(HashMap<String, String> data);

    public void removeHashPattern();

}