package helper;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import model.Task;

public class ChoiceBoxCell extends TableCell<Task, String> {

    ChoiceBox<String> buySellBox = new ChoiceBox<>();

    public ChoiceBoxCell(String[] items) {
        buySellBox.getItems().addAll(items);
        buySellBox.getSelectionModel().selectedIndexProperty().addListener((obs, oldValue, newValue) -> {

            String value = buySellBox.getItems().get(newValue.intValue());
            processEdit(value);
        });

    }

    private void processEdit(String value) {
        commitEdit(value);
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        setText(getItem());
        setGraphic(null);
    }

    @Override
    public void commitEdit(String value) {
        super.commitEdit(value);
        System.out.println(123);
        // ((Item) this.getTableRow().getItem()).setName(value);
        setGraphic(null);
    }

    @Override
    public void startEdit() {
        super.startEdit();
        String value = getItem();
        if (value != null) {
            setGraphic(buySellBox);
            setText(null);
        }
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null || empty) {
            setText(null);

        } else {
            setText(item);
        }
    }

}