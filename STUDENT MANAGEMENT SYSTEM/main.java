import java.util.*;
class Student {
    private String id, name;
    private int marks;

    public Student(String id, String name,int marks){
        this.id = id;
        this.name = name;
        this.marks = marks;


    }

    public String getId(){
        return id;
    }
    public int getMarks(){
        return marks;
    }
    public String getRole(){
        return "Undergrad";
    }
    @Override
    public String toString(){
        return id + "-" + name + " (" + marks + ") " + getRole();
    }
   
    
}

class GraduateStudent extends Student {
    private String area;

    public GraduateStudent(String id, String name, int marks,String area){
        super(id,name,marks);
        this.area = area;
    }
   
    public String getRole(){
        return "Grad ( " + area + " ) ";

    }

}
class HonorStudent extends Student{
    private int BonusMarks;
    
    HonorStudent(String id, String name, int marks,int BonusMarks,String area){
        super(id, name, marks);
        this.BonusMarks = BonusMarks;
        
    }
    public int getMarks(){
        return super.getMarks() + BonusMarks;
    }

}
class Repository<T> {
        private Map<String,T> data = new HashMap<>();
        public void add(String id,T obj){
            data.put(id,obj);
        }
        public T find(String id){
            return data.get(id);
        }
        public void delete(String id){
            data.remove(id);
        }

}

public class main {
    public void max_marks(){
        int max_marks = 0;
        for (Student st : list) {
            max_marks = Math.max(max_marks, st.getMarks());
        }
        System.out.println("\nTopper(s):");
        for (Student st : list) {
            if (st.getMarks() == max_marks) {
                System.out.println(st.getId() + ": " + st);
            }
        }
    }
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("S1","Armaan",75));
        list.add(new Student("S2", "Anshu", 100));
        list.add(new Student("S3", "Tarak", 60));

        list.add(new GraduateStudent("G1", "Ansh", 80, "CS"));

        Repository<Student> repo = new Repository<>();
        for (Student s:list) repo.add(s.getId(),s);

        System.out.println("All : ");
        for (Student st : list) System.out.println(st);

        System.out.println("\n LOOKUP S2: ");
        Student s = repo.find("S2");
        System.out.println(s != null ? s : "Not found");

        Iterator<Student> it = list.iterator();
        while(it.hasNext()){
            Student st = it.next();

            if (st.getMarks() < 80){
                it.remove();
                repo.delete(st.getId());
            }
        }

        System.out.println("\nAfter Removal: ");
        for (Student st : list) System.out.println(st);

        int max_marks = 0;
        for (Student st : list) {
            max_marks = Math.max(max_marks, st.getMarks());
        }
        System.out.println("\nTopper(s):");
        for (Student st : list) {
            if (st.getMarks() == max_marks) {
                System.out.println(st.getId() + ": " + st);
            }
        }

       
        
        
    }
}
