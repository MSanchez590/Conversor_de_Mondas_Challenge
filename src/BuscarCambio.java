import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class BuscarCambio {

    public Double busqueda(String cambio, Conversion conversion) {
        try{
            JsonObject jsonObject = conversion.conversion_rates();
            return jsonObject.get(cambio).getAsDouble();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
