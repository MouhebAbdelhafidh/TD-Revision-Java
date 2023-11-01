import java.util.Arrays;

public class Ecole {
    private String nom;
    private Etudiant[] E;
    private int nbrE = 0;
    EtudiantExisteException EX = null;

    public Ecole(String nom) {
        E = new Etudiant[500];
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Etudiant[] getE() {
        return E;
    }

    public void setE(Etudiant[] e) {
        E = e;
    }

    public int rechercherEtudiant (Etudiant e) {
        for(int i=0; i<E.length; i++)
            if(E[i].getId()==(e.getId()))
                return i;
        return -1;
    }

    public void ajouterEtudiant(Etudiant e) {

        if(nbrE<500) {
            try {
                E[nbrE] = e;
                nbrE++;
            } catch (Exception Ec) {
                System.err.println(EX.getMessage());
            }
        } else {
            System.out.println("Pas despace dans l'ecole ou Etudiant deja existe");
        }
    }

    public float getMoyenneDes3A() {
        float m = 0F;
        int nbr = 0;
        for(Etudiant e : E) {
            if(e instanceof Etudiant3eme) {
                m += e.getMoyenne();
                nbr++;
            }
        }
        return m/nbr;
    }

    public int moyenneSalaireAlternants() {
        int m = 0;
        int nbr = 0;
        for(Etudiant e : E) {
            if(e instanceof EtudiantAlternance) {
                m += ((EtudiantAlternance) e).getSalaire();
                nbr++;
            }
        }
        return m/nbr;
    }

    @Override
    public String toString() {
        return "Ecole{" +
                "nom='" + nom + '\'' +
                ", E=" + Arrays.toString(E) +
                '}';
    }

    public void changerEcole(Etudiant etd, Ecole e) {
        //Tester si letudiant existe dans l'ancienne ecole
        try {
            //tester si la nouvelle ecole est pleine
            if(e.E.length<500) {
                //on ajoute letudiant etd dans la derniere case
                e.E[E.length-1] = etd;
                //Chercher la case ou l'etudiant de l'ancienne ecole existe
                for(int i=0; i<E.length; i++) {
                    if(E[i].getId() == etd.getId()) {
                        for(int j=i; j<E.length;j++) {
                            //Ecraser la case dans l'ancienne ecole + diminuer le nbr d'eleves
                            E[j] = E[j+1];
                            nbrE--;
                        }
                    }


                }
            } else {
                System.out.println("La nouvelle ecole est pleine");
            }
        } catch (Exception Ec) {
            System.err.println(EX.getMessage());
        }
    }
}
