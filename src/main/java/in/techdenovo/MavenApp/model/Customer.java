package in.techdenovo.MavenApp.model;

public class Customer {


    public Customer(Long id, String lname, String fname, String mob, String email) {
        this.id = id;
        this.lname = lname;
        this.fname = fname;
        this.mob = mob;
        this.email = email;
    }

    private Long id;
    private String lname;
    private String fname;
    private String mob;
    private String email;

    public Customer() {

    }


//    public int getId(){
//        return id;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}