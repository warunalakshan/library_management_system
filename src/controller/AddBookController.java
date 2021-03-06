package controller;


import bo.BOFactory;
import bo.BOType;
import bo.custom.BooksBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class AddBookController {
    public AnchorPane root;
    public JFXTextField txt_Name;
    public JFXTextField txt_Author;
    public JFXTextField txt_Quantity;
    public JFXTextField txt_ISBN;
    public JFXButton btn_Add_new;
    public Label lbl_BookId;
    public JFXButton btn_Save;

    BooksBO bookBO = BOFactory.getInstance().getBO(BOType.BOOK);
    public void btn_Add_new_OnAction(ActionEvent actionEvent) {

        try {
            lbl_BookId.setText(bookBO.getNewBookId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void txt_ISBN_OnAction(ActionEvent actionEvent) {
        saveBook();
    }

    public void btn_Save_OnAction(ActionEvent actionEvent) {
        saveBook();
    }

    private void saveBook(){

        if (lbl_BookId.getText().equals("Book ID")){
            new Alert(Alert.AlertType.ERROR, "press Add New Book Button", ButtonType.OK).show();
            btn_Add_new.requestFocus();
            return;
        }
        if (txt_Name.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, " No name included", ButtonType.OK).show();
            txt_Name.requestFocus();
            return;
        }
        if (txt_Author.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "please enter author name", ButtonType.OK).show();
            txt_Author.requestFocus();
            return;
        }
        if (txt_Quantity.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "enter quantity", ButtonType.OK).show();
            txt_Quantity.requestFocus();
            return;
        }
        if (txt_ISBN.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "enter ISBN", ButtonType.OK).show();
            txt_ISBN.requestFocus();
            return;
        }

        String id = lbl_BookId.getText();
        String name = txt_Name.getText();
        String author = txt_Author.getText();
        int qty = Integer.parseInt(txt_Quantity.getText());
        String isbn = txt_ISBN.getText();

        boolean result = false;
        try {
           result = bookBO.saveBook(lbl_BookId.getText(),
                    txt_Name.getText(),
                    txt_Author.getText(),
                    Integer.parseInt(txt_Quantity.getText()),
                    txt_ISBN.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!result){
            new Alert(Alert.AlertType.ERROR, "Failed to save the book", ButtonType.OK).show();
        }
        new Alert(Alert.AlertType.INFORMATION, "Successfully added..", ButtonType.OK).show();
        txt_Name.clear();
        txt_Author.clear();
        txt_ISBN.clear();
        txt_Quantity.clear();
        btn_Add_new.requestFocus();
    }

}
