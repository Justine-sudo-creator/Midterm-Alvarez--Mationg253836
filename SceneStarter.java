/**
 * SceneStarter serves as the entry point for the midterm project application. 
 * It instantiates the main frame and invokes the necessary setup methods 
 * to initialize the user interface and event listeners.
 * * @author Justine T. Mationg (253836)
 * @author Adrian Adam Alvarez (250266)
 * @version February 26, 2026
 * * I have not discussed the Java language code in my program
 * with anyone other than my instructor or the teaching assistants
 * assigned to this course.
 * I have not used Java language code obtained from another student,
 * or any other unauthorized source, either modified or unmodified.
 * If any Java language code or documentation used in my program
 * was obtained from another source, such as a textbook or website,
 * that has been clearly noted with a proper citation in the comments
 * of my program.
 */
public class SceneStarter {
    
    /**
     * The main method that launches the application.
     * It creates the SceneFrame object and triggers the setup of 
     * the frame and button listeners.
     * * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        SceneFrame sf = new SceneFrame(); 
        sf.setUpButtonListener();
        sf.setUpFrame();
    }
}