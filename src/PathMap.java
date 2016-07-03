import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Created by pearson-brayt15 on 19/04/2016.
 */
public class PathMap extends JFrame {
    private ArrayList<PathNode> nodes;

    public PathMap(ArrayList<PathNode> nodes) {
        this.nodes = nodes;
        this.setMinimumSize(new DimensionUIResource(500, 500));
        this.setVisible(true);
        this.repaint();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        float xRange = 0;
        float yRange = 0;
        float width = this.getWidth() * 0.9F;
        float height = this.getHeight() * 0.9F;
        for(PathNode n : nodes) {
            if(n.x >xRange) {
                xRange = n.x;
            }
            if(n.y > yRange) {
                yRange = n.y;
            }
        }
        float x, y, px, py;
        for(PathNode n: nodes) {
            System.out.println("" + n.x/xRange);
            x = (n.x/xRange * width);
            y = (n.y/yRange * height);
            g.setColor(Color.black);
            g.fillOval((int) x-13, (int) y-13, 26, 26);
            for(PathNode p : n.links) {
                px = (p.x/xRange * width);
                py = (p.y/yRange * height);
                g.drawLine((int)x,(int)y,(int)px,(int)py);
                System.out.println(x + " " + y + " " + px + " " + py);
            }
        }
    }

    public void removeNode(PathNode p) {
        for(PathNode n : nodes) {
            n.removeLink(p);
        }
        nodes.remove(p);
    }

    public void addNode(PathNode p) {
        nodes.add(p);
    }



}
