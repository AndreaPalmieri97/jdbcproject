import java.sql.*;
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

    public static void checkUtente() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci l'ID dell'utente che vuoi ricercare");
        int id_utente = scanner.nextInt();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM utente " +
                "WHERE id = " + id_utente);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String nome = resultSet.getString("nome");
            String cognome = resultSet.getString("cognome");
            String email = resultSet.getString("email");
            int eta = resultSet.getInt("eta");

            System.out.println("L'utente con ID: " + id_utente + " è il seguente: \n"
                    + nome + "\n" + cognome + "\n" + email + "\n" + eta);
        }
        else{
            System.out.println("Non è presente nessun utente con quell'ID");
        }
    }

    public static void deleteUtente() throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci l'ID dell'utente che vuoi eliminare");
        int id_utente = scanner.nextInt();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM utente " +
                "WHERE id = " + id_utente);
        int result = preparedStatement.executeUpdate();
        if(result > 0){
            System.out.println("Utente eliminato correttamente");
        }
        else {
            System.out.println("Errore nell'eliminazione");
        }
    }
}
