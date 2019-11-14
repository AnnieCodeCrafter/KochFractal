package calculate;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public interface Generator  {
     void update(ArrayList<Edge> edges);
}
