package Q3;
public class SoftwareCollection {
    private Software[] softwareArr;
    
    public SoftwareCollection() {
        softwareArr = initializeSoftwares();
    }
    
    public Software[] initializeSoftwares() {
        Software[] softwareArr = {new Software("Windows 8"),
            new Software("Windows 10"),
            new Software("Visual Studio 2015"),
            new Software("SQL Server")
        };
        return softwareArr;
    }
    
    public String[] getSoftwareNames() {
        String[] softwareNames = new String[softwareArr.length];
        for (int i = 0; i < softwareArr.length; ++i) {
            softwareNames[i] = softwareArr[i].getName();
        }
        return softwareNames;
    }
    
    public Software get(int index) {
        return softwareArr[index];
    }
}
