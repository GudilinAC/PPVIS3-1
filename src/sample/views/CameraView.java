package sample.views;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.controllers.StructureController;
import sample.data.Constants;
import sample.models.Dot;

public class CameraView implements StructureView {
    private StructureController controller = StructureController.getInstance();
    private ImageView imageView = new ImageView();

    private void setImage(){
        Image image = new Image("file:resources/camera.png");
        imageView.setImage(image);
        imageView.setFitHeight(25);
        imageView.setFitWidth(25);
    }

    public CameraView(Dot dot) {
        setImage();
        setPosition(dot);
    }

    public CameraView(Dot[] dots) {
        setImage();
        if (dots.length > 0) {
            setPosition(dots[0]);
        } else { setPosition(Constants.OUT_DOT); }
    }

    public void followMouse(Dot dot) {
        this.setPosition(dot);
    }

    @Override
    public boolean setAnchor(Dot dot) {
        setPosition(dot);
        return true;
    }

    @Override
    public Dot[] getDotMassive() {
        return new Dot[]{new Dot(imageView.getX(), imageView.getY())};
    }

    public void setPosition(Dot dot) {
        imageView.setX(dot.getX());
        imageView.setY(dot.getY());
    }

    public Node getLayout() {
        return imageView;
    }

    @Override
    public void demo() {

    }
}
