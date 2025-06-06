package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.ArrayList;
import java.util.List;

public class MachineServiceImpl implements MachineService<Machine> {

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Machine> List<T> getAll(Class<? extends T> type) {
        if (type == Bulldozer.class) {
            return (List<T>) new BulldozerProducer().get();
        } else if (type == Excavator.class) {
            return (List<T>) new ExcavatorProducer().get();
        } else if (type == Truck.class) {
            return (List<T>) new TruckProducer().get();
        }
        return new ArrayList<>();
    }

    @Override
    public <T extends Machine> void fill(List<? super T> machines, T value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i, value);
        }
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {
        for (Machine machine : machines) {
            machine.doWork();
        }
    }
}

