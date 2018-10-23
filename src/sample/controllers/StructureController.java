package sample.controllers;

import sample.data.Context;
import sample.models.Dot;
import sample.models.Structure;
import sample.models.Tools;
import sample.models.Wall;
import sample.views.StructureView;

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

    public Structure createStructure(StructureView view) {
        Structure structure = null;
        try {
            Class<?> struct = Class.forName("sample.models." + view.getClass().getSimpleName().replaceFirst("View",""));
            structure = (Structure) struct.getConstructor(Dot[].class).newInstance((Object) view.getDotMassive());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return structure;
    }

    public StructureView createView(Structure structure){
        StructureView view = null;
        try {
            Class<?> struct = Class.forName("sample.views." + structure.getClass().getSimpleName() + "View");
            view = (StructureView) struct.getConstructor(Dot[].class).newInstance((Object) structure.getDotMassive());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    public StructureView createView(Tools tool,Dot...vars) {
        return createView(createStructure(tool, vars));
    }

    public Dot getBindingDot(Dot dot) {
        if(FloorController.getInstance().getBinding()){
            Dot nearestDot = dot.nearest(context.getBindingDots(FloorController.getInstance().getCurrentFloor()));
            if (nearestDot != null && dot.distance(nearestDot) < 20){
                return nearestDot;
            }
        }
        return null;
    }
}
