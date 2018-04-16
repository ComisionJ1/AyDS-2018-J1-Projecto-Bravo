package ayds.dictionary.bravo.fulllogic.Modelo.LocalSource;import ayds.dictionary.bravo.fulllogic.Modelo.Article;import java.sql.*;public class LocalSourceImp implements LocalSource {    private static final String CREATE_TABLE    = "create table terms (id INTEGER PRIMARY KEY AUTOINCREMENT,"+                                                  " term string, meaning string, source integer)";    private static final String DATABASE_URL    = "jdbc:sqlite:./dictionary.db";    private static final int SOURCE_WIKIPEDIA   = 1;    public LocalSourceImp() {        createNewDatabase();    }    private static void createNewDatabase() {        try (Connection connection = createConnection()) {            if (connection != null) {                Statement statement = createStatement(connection);                ResultSet rs = statement.executeQuery("SELECT * FROM sqlite_master");                if (!rs.next() || !rs.next() && !rs.getString(2).equals("terms")) {                    statement.executeUpdate(CREATE_TABLE);                }            }        }        catch (SQLException e) {            System.out.println(e.getMessage());        }    }    public Article getMeaning(String term) {        Article article = null;        Connection connection = null;        try {            connection = createConnection();            Statement statement = createStatement(connection);            ResultSet rs = statement.executeQuery("select * from terms WHERE term = '" + term + "'");            if (rs.next())                article = new Article(term, rs.getString("meaning"));        }        catch (SQLException errorGettingArticle) {            System.err.println("Get term error " + errorGettingArticle.getMessage());        }        finally {            closeConnection(connection);        }        return article;    }    public void saveArticle(Article article) {        Connection connection = null;        String term = article.getTerm();        if (!article.isMeaningNull()) {            String meaning = article.getMeaning();            try {                connection = createConnection();                Statement statement = createStatement(connection);                statement.executeUpdate("insert into terms values(null, '" + term + "', '" + meaning + "', " + SOURCE_WIKIPEDIA +")");            }            catch (SQLException errorSaving) {                System.err.println("Error saving " + errorSaving.getMessage());            }            finally {                closeConnection(connection);            }        }    }    private static Connection createConnection() throws SQLException{        return DriverManager.getConnection(DATABASE_URL);    }    private static Statement createStatement(Connection connection) throws SQLException{        Statement statement = connection.createStatement();        statement.setQueryTimeout(30);        return statement;    }    private void closeConnection(Connection connection){        try {            if (connection != null)                connection.close();        }        catch (SQLException connectionCloseFailed) {            System.err.println(connectionCloseFailed);        }    }}