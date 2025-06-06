package core.mate.academy.service;

import core.mate.academy.model.*;
import java.util.ArrayList;
import java.util.List;

public class MachineServiceImpl<T extends Machine> implements MachineService<T> {

    @Override
    public List<? extends T> getAll(Class<? extends T> type) {
        if (type == Bulldozer.class) {
            return (List<? extends T>) new BulldozerProducer().get();
        } else if (type == Truck.class) {
            return (List<? extends T>) new TruckProducer().get();
        } else if (type == Excavator.class) {
            return (List<? extends T>) new ExcavatorProducer().get();
        }
        return new ArrayList<>();
    }

    @Override
    public void fill(List<? super T> machines, T value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i, value);
        }
    }

    @Override
    public void startWorking(List<? extends T> machines) {
        for (T machine : machines) {
            machine.doWork();
        }
    }
}
