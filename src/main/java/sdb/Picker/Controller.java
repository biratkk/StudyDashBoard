package sdb.Picker;

import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Controller{
    public CheckBox calculatorCB;
    public CheckBox dictionaryCB;
    public CheckBox timerCB;
    public CheckBox whiteBoardCB;
    public CheckBox notesCB;

    public Set<String> getLis() {
        return lis;
    }

    public void setLis(Set<String> lis) {
        this.lis = lis;
    }

    private Set<String> lis = new HashSet<>();

    /*
    Action Event method to add selected checkbox to set
    as it as a set there won't be any duplicates
     */
    public void onChosen(ActionEvent event) {
        CheckBox temp = (CheckBox)event.getSource();
        if (temp.isSelected()) {
            lis.add(temp.getText());
        } else {
            // no need to check if contains to remove - if it's not present it can't be removed
            lis.remove(temp.getText());
        }
    }
/*
When application is closed this method is called so that
the features that need to be open can be obtained
 */
    List<String> getChecked(){
        // not much point streaming and collecting
        return new ArrayList<>(lis);
        // return lis.stream().collect(Collectors.toList());
    }
}
