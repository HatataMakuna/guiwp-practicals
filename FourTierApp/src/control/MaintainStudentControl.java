package control;

import da.StudentDA;
import domain.Student;
public class MaintainStudentControl {
    private StudentDA stdDA;
    
    public MaintainStudentControl() {
        stdDA = new StudentDA();
    }
    
    public Student selectRecord(String id) {
        return stdDA.getRecord(id);
    }
    
    public void addRecord(Student student) {
        stdDA.addRecord(student);
    }
    
    public void updateRecord(Student student) {
        stdDA.updateRecord(student);
    }
    
    public void deleteRecord(String id) {
        stdDA.deleteRecord(id);
    }
}
