package sample.controllers;

import sample.data.Context;
import sample.models.Floor;
import sample.views.CameraView;
import sample.views.StatsView;
import sample.views.StructureView;
import sample.views.WallView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StatsController {
    private Context context = Context.getInstance();

    private static StatsController ourInstance = new StatsController();

    public static StatsController getInstance() {
        return ourInstance;
    }

    private StatsController() {
    }

    public ArrayList<String> getFloorNames() {
        return context.getFloorNames();
    }

    public void addFloor() {
        Floor newFloor = new Floor();
        context.getFloors().add(newFloor);
        context.saveChanges();
        PlanController.getInstance().update(context.getFloors().indexOf(newFloor));
    }

    public void setFloor(int floorNumber) {
        StatsView.getInstance().update(floorNumber);
    }

    public void changeFloor(int floor) {
        FloorController.getInstance().setFloor(floor);
    }

    public void renameFloor(String newName, int selectedFloor) {
        context.getFloor(selectedFloor).setName(newName);
    }

    public void removeFloor(int floorNumber) {
        FloorController.getInstance().removeFloor(floorNumber);
    }

    public Map<Class<? extends StructureView>, Integer> getStatistics() {
        Map<Class<? extends StructureView>, Integer> stats = new HashMap<>();
        stats.put(CameraView.class, 0);
        stats.put(WallView.class, 0);


        context.getFloor(FloorController.getInstance().getCurrentFloor()).getStructures().forEach(s -> {
            switch (s.getClass().getSimpleName()) {
                case "Wall":
                    stats.put(WallView.class, stats.get(WallView.class) + 1);
                    break;
                case "Camera":
                    stats.put(CameraView.class, stats.get(CameraView.class) + 1);
                    break;
            }
        });
        return stats;
    }

    public void updateStats() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0, 0));
        context.getFloor(FloorController.getInstance().getCurrentFloor()).getStructures().forEach(s -> {
            switch (s.getClass().getSimpleName()) {
                case "Wall":
                    list.set(0, list.get(0) + 1);
                    break;
                case "Camera":
                    list.set(1, list.get(1) + 1);
                    break;
            }
            StatsView.getInstance().setStats(list);
        });
    }
}
