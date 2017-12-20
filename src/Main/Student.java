package Main;

/**
 * Klasse Main.Student
 */
public class Student extends Persoon
{
    private int studentNummer;
    private String studieRichting;

    /**
     * Constructor
     */
    public Student(int studentNummer, String studieRichting)
    {
        super();
        this.studentNummer = studentNummer;
        this.studieRichting = studieRichting;
    }
    
    /**
     * parameterloze constructor
     */
    public Student()
    {
        studentNummer = 0;
        studieRichting = "";
    }

    /**
     * Getter studentNummer
     */
    public int getStudentNummer()
    {        
         return studentNummer;        
    }
    
    /**
     * getter studieRichting
     */
    public String getStudieRichting()
    {
        if (studieRichting == "")
        {
            return "Onbekend";
        }
        else
        {
            return studieRichting;
        }
    }
    
    /**
     * setter studentNummer
     */
    public void setStudentnummer(int studentNummer)
    {
        this.studentNummer = studentNummer;
    }
    
    /**
     * setter studieRichting
     */
    public void setStudentnummer(String studieRichting)
    {
        this.studieRichting = studieRichting;
    }
    
    /**
     * Drukt alle gegevens van de persoon af
     */
    public String toString()
    {
        String toReturn = super.toString();
        toReturn = toReturn + "Studentnummer : " + getStudentNummer() + ".\n";
        toReturn = toReturn + "Studierichting : " + getStudieRichting() + ".\n";
        return toReturn;
    }
}
