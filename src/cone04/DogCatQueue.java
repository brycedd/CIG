package cone04;

import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Bryce_dd 2022/8/29 22:46
 */
public class DogCatQueue {
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;

    private long count;

    public DogCatQueue() {
        this.dogQ = new LinkedList<PetEnterQueue>();
        this.catQ = new LinkedList<PetEnterQueue>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if ("dog".equals(pet.getPetType())) {
            this.dogQ.add(new PetEnterQueue(pet, count++));
        } else if ("cat".equals(pet.getPetType())) {
            this.catQ.add(new PetEnterQueue(pet, count++));
        } else {
            throw new RuntimeException("type error");
        }
    }

    public Pet pollAll() {
        if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
            // 比较计数大小选择弹出
            if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
                return this.dogQ.poll().getPet();
            } else {
                return this.catQ.poll().getPet();
            }
        } else if (!this.dogQ.isEmpty()) {
            return this.dogQ.poll().getPet();
        } else if (!this.catQ.isEmpty()) {
            return this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("queue is empty");
        }
    }
}
