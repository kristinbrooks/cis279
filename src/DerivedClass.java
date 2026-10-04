// DerivedClass.java
// Kristin Brooks
// 10/3/26
// Show how to call the base class version of toString() in a derived class.

public class DerivedClass {

    // property
    private String misc; // miscellaneous property created just to set up the class

    //constructor
    public DerivedClass() {
        this.misc = "";
    }

    public DerivedClass(String misc) {
        this.misc = misc;
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }

    @Override
    public String toString() {
        return super.toString() + // This is how you call the base class version of toString()
                "misc='" + misc +
                '}';
    }
}
