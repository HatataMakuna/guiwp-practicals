package control;

import da.ProgrammeDA;
import domain.Programme;

public class MaintainProgrammeControl {

    private ProgrammeDA progDA;

    public MaintainProgrammeControl() {
        progDA = new ProgrammeDA();
    }

    public Programme selectRecord(String code) {
        return progDA.getRecord(code);
    }
    
    public void addRecord(Programme programme) {
        progDA.addRecord(programme);
    }
    
    public void updateRecord(Programme programme) {
        progDA.updateRecord(programme);
    }
    
    public void deleteRecord(String code) {
        progDA.deleteRecord(code);
    }
}