package sample.controllers;

import sample.data.Context;
import sample.models.Structure;
import sample.models.Tools;

public class StructureController {
    private Context context = Context.getInstance();

    private static StructureController ourInstance = new StructureController();

    public static StructureController getInstance() {
        return ourInstance;
    }

    private StructureController() {
    }

    public Structure createStructure(Tools tool/*,var...vars*/ ){
        switch (tool){
            case Wall:{

            }
        }

        return null;
    }
}
