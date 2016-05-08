import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

public class InputHandler {

    public static Customer[] getArrayofCustomers(String jsonLocation) {
        JSONParser parser = new JSONParser();
        JSONObject customerJSON = new JSONObject();
        try {
            customerJSON = (JSONObject) parser.parse(new FileReader(jsonLocation));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONArray customerArray = (JSONArray) customerJSON.get("customers");

        List<Customer> customers  = new ArrayList<>();
        for(Object customerObj : customerArray)
        {
            customers.add(new Customer( (JSONObject) customerObj));
        }

        Customer[] resultsArray = new Customer[customers.size()];
        resultsArray = customers.toArray(resultsArray);

        return resultsArray;

    }
}
