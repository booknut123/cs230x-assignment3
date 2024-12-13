
/**
 * School with name and ratings of academic programs, facilities, and social life. Also includes VisitedSchool-specific preference rating.
 * 
 * @author Kailyn Lau 
 * @version v1.0
 */
public class VisitedSchool extends School
{
    // instance variables
    protected int preferenceRating; // rating of vibes after visit
    protected int overallRating; // overall rating as the weighted sum, Σ(weight * factor)

    /**
     * Constructs a VisitedSchool
     * 
     * @param name the name of the school
     * @param academicRating the rating of academic programs at the school
     * @param facilitiesRating the rating of facilities at the school
     * @param socialRating the rating of the social life at the school
     * @param preferenceRating the rating of the vibes/feelings after visiting the school
     */
    public VisitedSchool(String name, int academicRating, int facilitiesRating, int socialRating, int preferenceRating) {
        super(name, academicRating, facilitiesRating, socialRating);
        this.preferenceRating = preferenceRating;
    }

    /**
     * Updates the personal rating of the school. Will direct user to enter a new int if param n is out of range 1-10.
     * 
     * @param n the new integer rating of the school's vibes
     */
    public void setPreferenceRating(int n) {
        if ((n < 1) || (n > 10)) {
            throw new IllegalArgumentException("Error. Rating must be between 1 and 10.");
        }
        preferenceRating = n;

        /*
         * alternative if we don't want an error message and want to give the user another chance:
         * import java.util.Scanner;
         * if (1 <= n && n <= 10) {
         *     preferenceRating = n;
         *  } else{
         *      Scanner scan = new Scanner(System.in);
         *      System.out.print("Error. Please enter a preference rating between 1 and 10:");
         *      setPreferenceRating(scan.nextInt());
         *      scan.close();
         *  }
         */
    }

    /**
     * @return the int personal rating of the school
     */
    public int getPreferenceRating() {
        return preferenceRating;
    }

    /**
     * Returns the overall rating of the school, computed by the weighted sum, Σ(weight * rating).
     * 
     * @param academicWeight
     * @param facilitiesWeight
     * @param socialWeight
     * @param preferenceWeight
     * @return the overall rating of the school
     */
    public int computeOverallRating(int academicWeight, int facilitiesWeight, int socialWeight, int preferenceWeight) {
        overallRating = 0;

        if ((academicWeight < 1) || (academicWeight > 5)) {
            throw new IllegalArgumentException("Error. Weighting must be between 1 and 5.");
        }
        overallRating += academicWeight * super.academicRating;

        if ((facilitiesWeight < 1) || (facilitiesWeight > 5)) {
            throw new IllegalArgumentException("Error. Weighing must be between 1 and 5.");
        }
        overallRating += facilitiesWeight * super.facilitiesRating;

        if ((socialWeight < 1) || (socialWeight > 5)) {
            throw new IllegalArgumentException("Error. Weighting must be between 1 and 5.");
        }
        overallRating += socialWeight * super.socialRating;

        if ((preferenceWeight < 1) || (preferenceWeight > 5)) {
            throw new IllegalArgumentException("Error. Weighting must be between 1 and 5.");
        }
        overallRating += preferenceWeight * preferenceRating;

        // similar alternative: (see setPreferenceRating())
        return overallRating;
    }

    /**
     * Returns the overall rating of the school (weighted sum, Σ(weight * factor))
     * Limitation: User must have previously called computeOverallWeighting, else will return 0 because weights haven't been specified.
     * 
     * @return the int overall rating of the school (weighted sum, Σ(weight * factor))
     */
    public int getOverallRating() {
        return overallRating;
    }

    /**
     * @return String representation of the VisitedSchool
     */
    public String toString() {
        return super.toString() + " | Preference rating: " + preferenceRating + " | Overall rating: " + overallRating;
    }

    /**
     * Main method to test this class
     */
    public static void main(String[] args) {
        VisitedSchool williams = new VisitedSchool("Williams", 10, 3, 5, 7);
        VisitedSchool wellesley = new VisitedSchool("Wellesley", 10, 10, 10, 7);
        VisitedSchool brown = new VisitedSchool("Brown", 10, 1, 5, 6);
        VisitedSchool smith = new VisitedSchool("Smith", 0, 0, 0, 0);

        smith.setPreferenceRating(8);
        System.out.println("Smith's expected social rating: 8 | Computed: " + smith.getPreferenceRating());

        // smith.setPreferenceRating(11); // checking out-of-range custom error
        /*
         * java.lang.IllegalArgumentException: Error. Rating must be between 1 and 10.
         * at VisitedSchool.setPreferenceRating(VisitedSchool.java:35)
         * at VisitedSchool.main(VisitedSchool.java:122)
         */
        System.out.println("\n" + wellesley);
        System.out.println("Wellesley overall rating before computing: Expected 0 | Computed " + wellesley.getOverallRating());
        System.out.println("\nWeightings: 2, 4, 5, 1\nWellesley overall rating: Expected 117 | Computed " + wellesley.computeOverallRating(2, 4, 5, 1));
        System.out.println(wellesley);

        // System.out.println("Weightings: 2, 4, 5, 6\nWellesley overall rating: Expected *error* | Computed " + wellesley.computeOverallRating(2, 4, 5, 6));
        /* Checking out-of-range custom error
         * java.lang.IllegalArgumentException: Error. Weighting must be between 1 and 5.
         * at VisitedSchool.computeOverallRating(VisitedSchool.java:88)
         * at VisitedSchool.main(VisitedSchool.java:140)
         */
    }
}
