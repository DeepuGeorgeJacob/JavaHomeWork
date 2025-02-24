import java.util.ArrayList;
import java.util.List;

public class Layer<T extends Mappable> {
    private final List<T> layerList = new ArrayList<>();

    public void addElement(final T element) {
        this.layerList.add(element);
    }

    public void addElements(final List<T> elements) {
        this.layerList.addAll(elements);
    }

    public void renderLayer() {
        for (T layer: layerList) {
            layer.render();
        }
    }
}
