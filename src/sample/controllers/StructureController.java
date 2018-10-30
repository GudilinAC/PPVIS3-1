package sample.controllers;

import sample.data.Constants;
import sample.data.Data;
import sample.models.Dot;
import sample.models.Structure;
import sample.models.Tools;
import sample.views.StructureView;

//pattern observer
public class StructureController {
    private Data context = Data.getInstance();

    private static StructureController ourInstance = new StructureController();

    public static StructureController getInstance() {
        return ourInstance;
    }

    private StructureController() {
    }

    public Structure createStructure(Tools tool, Dot... vars) {
        Structure newStructure = null;
        Class<?> struct = null;
        try {
            struct = Class.forName("sample.models." + tool.name());
            newStructure = (Structure) struct.getConstructor(Dot[].class).newInstance((Object) vars);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newStructure;
    }

    public Structure createStructure(StructureView view) {
        Structure structure = null;
        try {
            Class<?> struct = Class.forName("sample.models." + view.getClass().getSimpleName().replaceFirst("View", ""));
            structure = (Structure) struct.getConstructor(Dot[].class).newInstance((Object) view.getDotMassive());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return structure;
    }

    public StructureView createStructureView(Tools tool) {
        StructureView view = null;
        try {
            Class<?> struct = Class.forName("sample.views." + tool.name() + "View");
            view = (StructureView) struct.getConstructor(Dot[].class).newInstance((Object) new Dot[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    public StructureView createView(Structure structure) {
        StructureView view = null;
        try {
            Class<?> struct = Class.forName("sample.views." + structure.getClass().getSimpleName() + "View");
            view = (StructureView) struct.getConstructor(Dot[].class).newInstance((Object) structure.getDots());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    public StructureView createView(Tools tool, Dot... vars) {
        return createView(createStructure(tool, vars));
    }

    public Dot getBindingDot(Dot dot) {
        if (FloorController.getInstance().getBinding()) {
            Dot nearestDot = dot.nearest(context.getBindingDots(FloorController.getInstance().getCurrentFloor()));
            if (nearestDot != null && dot.distance(nearestDot) < Constants.BINDING_DISTANCE) {
                return nearestDot;
            }
        }
        return null;
    }

    public StructureView getDemoView(Class<? extends StructureView> classy) {
        StructureView view = null;
        try {
            view = classy.getConstructor(Dot[].class).newInstance((Object) new Dot[]{});
            view.demo();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return view;
    }
}
