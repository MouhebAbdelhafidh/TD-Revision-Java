public class EtudiantExisteException extends Throwable {
    private String message;

    public EtudiantExisteException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "Etudiant existe deja";
    }
}
