package sample.controllers;

import sample.data.Context;
import sample.models.Dot;
import sample.models.Structure;
import sample.models.Tools;
import sample.models.Wall;

public class StructureController {
    private Context context = Context.getInstance();

    private static StructureController ourInstance = new StructureController();

    public static StructureController getInstance() {
        return ourInstance;
    }

    private StructureController() {
    }

    public Structure createStructure(Tools tool,Dot...vars) {
        Structure newStructure = null;
        switch (tool) {
            case Wall:
                newStructure = new Wall(vars);
                break;
        }

        return newStructure;
    }
}
