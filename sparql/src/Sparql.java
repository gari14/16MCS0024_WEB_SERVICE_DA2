
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.util.FileManager;

public class Sparql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 
       
        // First we have load our rdf data into jena Model [First 2 Line]
        // It Contain All the data which is define in rdf file
        FileManager.get().addLocatorClassLoader(Sparql.class.getClassLoader());
  	 Model model;
        model = FileManager.get().loadModel("C:\\Users\\Pranav\\Documents\\NetBeansProjects\\sparql\\src\\data.rdf");
        
        String queryStrName;
        queryStrName = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +  
                "PREFIX foaf: <http://xmlns.com/foaf/0.1/> " +
                "SELECT * WHERE { " +
                " ?person foaf:name ?x ." + 
                " } ";
        Query queryName = QueryFactory.create(queryStrName);
        try
           (QueryExecution queExeName = QueryExecutionFactory.create(queryName, model)) {
                ResultSet resultsName = queExeName.execSelect();
                while(resultsName.hasNext()){
                    QuerySolution slnName = resultsName.nextSolution();
                    Literal name = slnName.getLiteral("x");
                    System.out.println(name);
                }
            }
    }
}
