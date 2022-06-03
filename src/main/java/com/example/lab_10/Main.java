package com.example.lab_10;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static SquaresList squaresList = new SquaresList();
    public static PyramidsList pyramidsList = new PyramidsList();
    private ObservableList<Square> getSquare() {
        int N = 50;
        ObservableList<Square> list = FXCollections.observableArrayList();
        for (int i = 0; i < N; i++) {
            Square square = new Square((int) (Math.random() * 20 + 1));
            squaresList.add(square);
            list.add(square);
        }
        return list;
    }
    private ObservableList<Pyramid> getPyramid(){
        int M = 50;
        ObservableList<Pyramid> list = FXCollections.observableArrayList();
        for (int i = 0; i < M; i++) {
            Pyramid pyramid = new Pyramid((int) (Math.random() * 20 + 1), (int) (Math.random() * 20 + 1));
            pyramidsList.add(pyramid);
            list.add(pyramid);
        }
        return list;
    }
    @Override
    public void start(Stage stage) throws IOException {
        TableView<Square> SquareTable = new TableView<Square>();

        TableColumn<Square, Integer> side = new TableColumn<Square, Integer>("Side");

        TableColumn<Square, Integer> perimeter = new TableColumn<Square, Integer>("Perimeter");

        TableColumn<Square, Float> square = new TableColumn<Square, Float>("Square");

        TableColumn<Square, Double> diagonal = new TableColumn<Square, Double>("Diagonal");


        side.setCellValueFactory(new PropertyValueFactory<>("Side"));
        perimeter.setCellValueFactory(new PropertyValueFactory<>("Perimeter"));
        square.setCellValueFactory(new PropertyValueFactory<>("Square"));
        diagonal.setCellValueFactory(new PropertyValueFactory<>("Diagonal"));

        side.setSortType(TableColumn.SortType.DESCENDING);

        ObservableList<Square> listS = getSquare();
        SquareTable.setItems(listS);
        SquareTable.getColumns().addAll(side, perimeter, square, diagonal);

        Label labelS = new Label("Squares and Pyramids");

        VBox vBoxS = new VBox();
        VBox.setVgrow(SquareTable, Priority.ALWAYS);
        vBoxS.setPadding(new Insets(5));
        vBoxS.getChildren().add(labelS);
        vBoxS.getChildren().add(SquareTable);
        vBoxS.getChildren().add(new Label("Avg square = " + squaresList.getAvgS()));
        vBoxS.setAlignment(Pos.CENTER);

        /*--------------------------------------------------------------------------------------------------------------------------------*/
        TableView<Pyramid> PyramidTable = new TableView<Pyramid>();

        TableColumn<Pyramid, Integer> sideP = new TableColumn<Pyramid, Integer>("Side");

        TableColumn<Pyramid, Integer> perimeterP = new TableColumn<Pyramid, Integer>("Perimeter");

        TableColumn<Pyramid, Float> squareP = new TableColumn<Pyramid, Float>("Square");

        TableColumn<Square, Double> diagonalP = new TableColumn<Square, Double>("Diagonal");

        TableColumn<Pyramid, Integer> height = new TableColumn<Pyramid, Integer>("Height");

        TableColumn<Pyramid, Double> apophem = new TableColumn<Pyramid, Double>("Apophem");

        TableColumn<Pyramid, Float> volume = new TableColumn<Pyramid, Float>("Volume");


        sideP.setCellValueFactory(new PropertyValueFactory<>("Side"));
        perimeterP.setCellValueFactory(new PropertyValueFactory<>("Perimeter"));
        squareP.setCellValueFactory(new PropertyValueFactory<>("Square"));
        diagonalP.setCellValueFactory(new PropertyValueFactory<>("Diagonal"));
        height.setCellValueFactory(new PropertyValueFactory<>("h"));
        apophem.setCellValueFactory(new PropertyValueFactory<>("Apophem"));
        volume.setCellValueFactory(new PropertyValueFactory<>("V"));

        sideP.setSortType(TableColumn.SortType.DESCENDING);

        ObservableList<Pyramid> listP = getPyramid();
        PyramidTable.setItems(listP);
        PyramidTable.getColumns().addAll(sideP, perimeterP, squareP, height, apophem, volume);

        VBox vBoxP = new VBox();
        VBox.setVgrow(PyramidTable, Priority.ALWAYS);
        vBoxP.setPadding(new Insets(5));
        vBoxP.getChildren().add(PyramidTable);
        vBoxP.getChildren().add(new Label("MinSquare  = " + pyramidsList.getMinSquare()));
        vBoxP.setAlignment(Pos.CENTER);

        HBox hBox = new HBox();
        HBox.setHgrow(vBoxS, Priority.ALWAYS);
        HBox.setHgrow(vBoxP, Priority.ALWAYS);
        hBox.getChildren().add(vBoxP);
        hBox.getChildren().add(vBoxS);
        /*--------------------------------------------------------------------------------------------------------------------------------*/
        stage.setTitle("Square");

        Scene scene = new Scene(hBox, 1000, 640);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}