
/**
 * A school ranking system with an array of VisitedSchools.
 *
 * @author Kailyn Lau
 * @version v1.0
 */
public class SchoolRankingSystem
{
    // instance variables
    private VisitedSchool[] schools; // VisitedSchool collection
    private int count;

    /**
     * Constructs a SchoolRankingSystem of specified size.
     */
    public SchoolRankingSystem(int size) {
        schools = new VisitedSchool[size]; // Currently specifiying a small size. Can also add expand() method similar to previous work.
        count = 0;
    }

    /**
     * Adds a VisitedSchool to the collection. If the school is already in the collection, will update preference rating of that School.
     * 
     * @param s the School to add
     * @param ratePref the preference rating of the school
     */
    public void addSchool(School s, int ratePref) {
        VisitedSchool newSchool = (VisitedSchool) s;

        for (int i = 0; i < count; i++) {
            if (schools[i].isEqual(newSchool)) { // if already in collection
                schools[i].setPreferenceRating(ratePref);
                return;
            }
        }

        newSchool.setPreferenceRating(ratePref);
        schools[count] = newSchool;
        count++;
    }

    /**
     * Computes overall ratings (Σ(weight * rating)) (see VisitedSchool.computeOverallRating()) using the given weights for all schools.
     * 
     * @param academicWeight
     * @param facilitiesWeight
     * @param socialWeight
     * @param preferenceWeight
     */
    public void computeAllRatings(int academicWeight, int facilitiesWeight, int socialWeight, int preferenceWeight) {
        for (int i = 0; i < count; i++) {
            schools[i].computeOverallRating(academicWeight, facilitiesWeight, socialWeight, preferenceWeight);
        }
    }

    /**
     * Returns the name of the school with the top rating (if tie, will return the first one in the array)
     * Limitation: If computeAllRatings has not been called, findTopSchool() will always return the first School in the array because all overallRatings = 0.
     * Expansion: Instead of returning the first school in case of tie, can set to return the one with the higher preference rating, or the one with the highest rating in the highest weighted category.
     * 
     * @return the name of the highest-rated school
     */
    public String findTopSchool() {
        int max = 0;

        for (int i = 0; i < count; i++) {
            if (schools[i].getOverallRating() > schools[max].getOverallRating()) {
                max = i;
            }
        }

        return schools[max].getName();
    }

    /**
     * @return a list of all VisitedSchools in the collection
     */
    public String toString() {
        String s = "There are " + count + " schools in the database: \n";
        for (int i = 0; i < count; i++) {
            s += schools[i] + "\n";
        }
        return s;
    }

    /**
     * Main method to test this class
     */
    public static void main(String[] args) {
        VisitedSchool williams = new VisitedSchool("Williams", 10, 3, 5, 7);
        VisitedSchool wellesley = new VisitedSchool("Wellesley", 10, 10, 10, 7);
        VisitedSchool brown = new VisitedSchool("Brown", 10, 1, 5, 6);
        VisitedSchool smith = new VisitedSchool("Smith", 4, 3, 10, 8);

        SchoolRankingSystem mySystem = new SchoolRankingSystem(5);
        mySystem.addSchool(williams, 7);
        mySystem.addSchool(wellesley, 10);
        mySystem.addSchool(brown, 6);
        mySystem.addSchool(smith, 8);

        System.out.println(mySystem);

        mySystem.computeAllRatings(2, 4, 5, 1);

        System.out.println("Weights for academics, facilities, social, and preferences are: 2, 4, 5, 1");
        System.out.println(mySystem);

        System.out.println("Top school: Expected Wellesley | Computed " + mySystem.findTopSchool());

        // There are 4 schools in the database:
        // Williams Academic rating: 10 Social rating: 5 Facilities rating: 3 *Preference rating*: 7
        // ***Overall Rating***: 68
        // Wellesley Academic rating: 10 Social rating: 10 Facilities rating: 10 *Preference rating*: 7
        // ***Overall Rating***: 108
        // Brown Academic rating: 10 Social rating: 5 Facilities rating: 1 *Preference rating*: 6
        // ***Overall Rating***: 54
        // Smith Academic rating: 4 Social rating: 10 Facilities rating: 3 *Preference rating*: 8
        // ***Overall Rating***: 65

        // #### Printing top schools overall ####
        // #### Weights for Academics, Facilities, Social and Preferences are: 2, 4, 5, 1 ####
        // Wellesley Academic rating: 10 Social rating: 10 Facilities rating: 10 *Preference rating*: 7
        // ***Overall Rating***: 108
    }
}
