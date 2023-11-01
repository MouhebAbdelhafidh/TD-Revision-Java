import java.util.Objects;

abstract public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private float moyenne;

    public Etudiant(int id, String nom, String prenom, float moyenne) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.moyenne = moyenne;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public float getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etudiant etudiant = (Etudiant) o;
        return id == etudiant.id && Objects.equals(nom, etudiant.nom);
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", moyenne=" + moyenne +
                '}';
    }

    abstract void ajouterUneAbsence();


}
