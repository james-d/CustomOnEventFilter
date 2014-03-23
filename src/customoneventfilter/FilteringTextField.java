

package customoneventfilter;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class FilteringTextField extends TextField{

    private final ObjectProperty<EventHandler<KeyEvent>> onKeyTypedFilter ;
    
    public FilteringTextField() {
        this("");
    }

    public FilteringTextField(String text) {
        super(text);
        this.onKeyTypedFilter = new SimpleObjectProperty<>(this, "onKeyEventFilter");
        onKeyTypedFilter.addListener((obs, oldFilter, newFilter) -> {
            if (oldFilter != null) {
                removeEventFilter(KeyEvent.KEY_TYPED, oldFilter);
            }
            if (newFilter != null) {
                addEventFilter(KeyEvent.KEY_TYPED, newFilter);
            }
        });
    }
    
    public ObjectProperty<EventHandler<KeyEvent>> onKeyTypedFilterProperty() {
        return onKeyTypedFilter ;
    }
    
    public EventHandler<KeyEvent>getOnKeyTypedFilter() {
        return onKeyTypedFilter.get();
    }
    
    public void setOnKeyTypedFilter(EventHandler<KeyEvent> filter) {
        this.onKeyTypedFilter.set(filter);
    }
    
}
