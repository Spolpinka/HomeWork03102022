package transport;

import java.util.LinkedList;
import java.util.Queue;

public class ServiceStation<T extends Transport> {
    private Queue<T> queue = new LinkedList<>();

    public Queue<T> getQueue() {
        return queue;
    }

    public void addTransport(T transport) {
        if (transport.getClass() != Bus.class) {
            queue.offer(transport);
        } else {
            System.out.println("Автобус " + transport.getBrand() + " " + transport.getModel() +
                    " не нуждается в техобслуживании!");
        }
    }

    public void getService() {
        for (int i = 0; i < queue.size(); i++) {
            T t = queue.poll();
            System.out.println("Транспорт " + t.getBrand() + " " + t.getModel() +
                    " проходит техобслуживание!");

        }
    }
}
