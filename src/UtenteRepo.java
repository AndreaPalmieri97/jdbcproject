import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UtenteRepo {

    public static void generateUtente() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il nome:");
        String nome = scanner.nextLine();
        System.out.println("Inserisci il cognome:");
        String cognome = scanner.nextLine();
        System.out.println("Inserisci l'email:");
        String email = scanner.nextLine();
        System.out.println("Inserisci l'età:");
        int eta = scanner.nextInt();

        newUtente(new Utente(nome, cognome, email, eta));

    }
    public static void newUtente(Utente u) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO utente " +
                "(nome, cognome, email, eta) VALUES (?, ?, ?, ?)");
        preparedStatement.setString(1,u.getNome());
        preparedStatement.setString(2,u.getCognome());
        preparedStatement.setString(3,u.getEmail());
        preparedStatement.setInt(4,u.getEta());
        int result = preparedStatement.executeUpdate();
        if(result>0){
            System.out.println("L'utente " + u.nome + " " + u.cognome + " è stato inserito " +
                    "correttamente");
        }
        else {
            System.out.println("L'utente " + u.nome + " " + u.cognome + " NON è stato inserito");
        }

    }
}
