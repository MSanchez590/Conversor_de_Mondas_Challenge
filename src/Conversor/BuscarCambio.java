package Conversor;

import Models.SupportedCodes;
import Models.Conversion;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

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

    public String verDivisas(SupportedCodes supportedCodes) {
        JsonArray jsonArray = supportedCodes.supported_codes();
        List<String> codes = new ArrayList<>();
        jsonArray.forEach(jsonElement -> {
            codes.add(jsonElement.toString());
        });
        return codes.toString().replace("[", "").replace("],", "\n");
    }
}
