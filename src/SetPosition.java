public class SetPosition {

    // Fields:
    private String firstHalf;

    //------------------------------------------------------------------------------------------//

    // Constructor:
    public SetPosition() {
        this.firstHalf = "The position is...";
    }

    //------------------------------------------------------------------------------------------//

    //
    public void controlled() {
        System.out.println(firstHalf + "Controlled,");
    }

    //------------------------------------------------------------------------------------------//

    //
    public void risky() {
        System.out.println(firstHalf + "Risky,");
    }

    //------------------------------------------------------------------------------------------//

    //
    public void desperate() {
        System.out.println(firstHalf + "Deseperate,");
    }

}
