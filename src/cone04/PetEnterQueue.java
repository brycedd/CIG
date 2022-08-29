package cone04;

/**
 * @author Bryce_dd 2022/8/29 22:43
 */
public class PetEnterQueue {
    private final Pet pet;
    private final long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return this.pet;
    }

    public long getCount() {
        return this.count;
    }

    public String getEnterPetType() {
        return this.pet.getPetType();
    }
}
