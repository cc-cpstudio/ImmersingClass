package frontend.widgets;

import javafx.scene.Node;

import org.dom4j.Element;

public abstract class InfobarWidgetBase {
    public Integer position;
    public final String type = this.getClass().getSimpleName();

    public abstract Element toXML();
    public abstract Node self();
}
