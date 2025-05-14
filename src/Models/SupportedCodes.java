package Models;

import com.google.gson.JsonArray;

public record SupportedCodes(String result, String documentation, String terms_of_use, JsonArray supported_codes) {
}
