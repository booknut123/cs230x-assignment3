
/**
 * School with name and ratings of academic programs, facilities, and social life.
 *
 * @author Kailyn Lau
 * @version v1.0
 */
public class School
{
    //instance variables
    protected String name; // name of school
    protected int academicRating; // rating of academics
    protected int facilitiesRating; // rating of facilities
    protected int socialRating; // rating of social life

    /**
     * Constructs a School
     * 
     * @param name the name of the school
     * @param academicRating the rating of academic programs at the school
     * @param facilitiesRating the rating of facilities at the school
     * @param socialRating the rating of the social life at the school
     */
    public School(String name, int academicRating, int facilitiesRating, int socialRating) {
        this.name = name;
        this.academicRating = academicRating;
        this.facilitiesRating = facilitiesRating;
        this.socialRating = socialRating;
    }

    /**
     * Updates the school's name.
     * 
     * @param name the new name of the school
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the name of the school
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the rating of the school's academic programs. Will direct user to enter a new int if param n is out of range 1-10.
     * 
     * @param n the new integer rating of the school's academic programs
     */
    public void setAcademicRating(int n) {
        if ((n < 1) || (n > 10)) {
            throw new IllegalArgumentException("Error. Rating must be between 1 and 10.");
        }
        academicRating = n;

        /* 
         * alternative if we don't want an error message and want to give the user another chance:
         * import java.util.Scanner;
         * if (1 <= n && n <= 10) {
         *     academicRating = n;
         *  } else{
         *      Scanner scan = new Scanner(System.in);
         *      System.out.print("Error. Please enter an academic rating between 1 and 10:");
         *      setAcademicRating(scan.nextInt());
         *      scan.close();
        // }
         */
    }

    /**
     * @return the int rating of the school's academic programs
     */
    public int getAcademicRating() {
        return academicRating;
    }

    /**
     * Updates the rating of the school's facilities. Will direct user to enter a new int if param n is out of range 1-10.
     * 
     * @param n the new integer rating of the school's facilities
     */
    public void setFacilitiesRating(int n) {
        if ((n < 1) || (n > 10)) {
            throw new IllegalArgumentException("Error. Rating must be between 1 and 10.");
        }
        facilitiesRating = n;

        // similar alternative (see setAcademicRating())
    }

    /**
     * @return the int rating of the school's facilities
     */
    public int getFacilitiesRating() {
        return facilitiesRating;
    }

    /**
     * Updates the rating of the school's social life. Will direct user to enter a new int if param n is out of range 1-10.
     * 
     * @param n the new integer rating of the school's social life
     */
    public void setSocialRating(int n) {
        if ((n < 1) || (n > 10)) {
            throw new IllegalArgumentException("Error. Rating must be between 1 and 10.");
        }
        socialRating = n;

        // similar alternative: (see setAcademicRating())
    }

    /**
     * @return the int rating of the school's social life
     */
    public int getSocialRating() {
        return socialRating;
    }

    /**
     * Checks whether this School and another School have the same name (regardless of case)
     * 
     * @param s the School this School is to be compared to
     * @return true if this School and School s are equal (have the same name)
     */
    public boolean isEqual(School s) {
        return this.name.equalsIgnoreCase(s.getName());
    }

    /**
     * @return String representation of the School
     */
    public String toString() {
        return name + " | Academics: " + academicRating + " | Facilities rating: " + facilitiesRating + " | Social rating: " + socialRating;
    }

    /**
     * Main method to test this class
     */
    public static void main(String[] args) {
        School williams = new School("Williams", 10, 3, 5);
        School wellesley = new School("Wellesley", 10, 10, 10);
        School brown = new School("Brown", 10, 1, 5);
        School smith = new School("Smith", 0, 0, 0);

        smith.setAcademicRating(4);
        System.out.println("Smith's expected academic rating: 4 | Computed: " + smith.getAcademicRating());
        smith.setFacilitiesRating(3);
        System.out.println("Smith's expected facilities rating: 3 | Computed: " + smith.getFacilitiesRating());
        smith.setSocialRating(10);
        System.out.println("Smith's expected social rating: 10 | Computed: " + smith.getSocialRating());

        // smith.setSocialRating(11); // checking out-of-range custom error
        /*
         * java.lang.IllegalArgumentException: Error. Rating must be between 1 and 10.
         * at School.setSocialRating(School.java:107)
         * at School.main(School.java:151)
         */

        System.out.println("\n" + williams);
        System.out.println(wellesley);
        System.out.println(brown);
        System.out.println(smith);

        School williams2 = new School("williams", 5, 5, 5);
        System.out.println("\n" + williams2);
        System.out.println("Williams is the same as williams: Expected true | Computed " + williams.isEqual(williams2));
    }
}
