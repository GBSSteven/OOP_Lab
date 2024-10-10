abstract class House {
    @SuppressWarnings("unused")
    private String name;
    @SuppressWarnings("unused")
    private String description;
    private int total_members;

    public House(int total_members) {
        this.total_members = total_members;
    }

    // Encapsulation: Getter for total_members
    public int getTotalMembers() {
        return total_members;
    }

    // Abstract method to be implemented in LokSabha and RajyaSabha (Polymorphism)
    public abstract void passBill();
}