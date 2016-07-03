import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by pearson-brayt15 on 19/04/2016.
 */
public class PathNode {
    int x;
    int y;
    ArrayList<PathNode> links;

    public PathNode() {
        links = new ArrayList<>();
    }

    public PathNode(int x, int y) {
        links = new ArrayList<>();
        this.x = x;
        this.y = y;
    }

    public PathNode(int x, int y, PathNode... links) {
        this.x = x;
        this.y = y;
        if(this.links == null) {
            this.links = new ArrayList<>();
        }
        Collections.addAll(this.links, links);
    }

    public void addLink(PathNode p) {
        links.add(p);
    }

    public void removeLink(PathNode p) {
        links.remove(p);
    }

    public void removeAllLinks() {
        links.clear();
    }



}
